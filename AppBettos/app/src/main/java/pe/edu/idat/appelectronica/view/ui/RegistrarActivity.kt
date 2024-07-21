package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityRegistrarBinding
import pe.edu.idat.appelectronica.retrofit.response.RegistroResponse
import pe.edu.idat.appelectronica.util.TipoMensaje
import pe.edu.idat.appelectronica.util.AppMensaje
import pe.edu.idat.appelectronica.viewmodel.AuthViewModel

class RegistrarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var authViewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.btnVolver.setOnClickListener(this)
        binding.btnRegistrar.setOnClickListener(this)
        authViewModel.registroResponse.observe(this, Observer {
                response -> obtenerDatosRegistro(response)
        })
    }

    private fun obtenerDatosRegistro(response: RegistroResponse) {
        binding.btnVolver.isEnabled = true
        binding.btnRegistrar.isEnabled = true
        AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ADVERTENCIA)
    }


    override fun onClick(v: View) {
        when(v.id){
            R.id.btnVolver -> startActivity(Intent(applicationContext, LoginActivity::class.java))
            R.id.btnRegistrar -> registrarUsuario()
        }


    }

    private fun registrarUsuario() {
        binding.btnVolver.isEnabled = false
        binding.btnRegistrar.isEnabled = false
        authViewModel.registro(
            binding.tvCorreo.text.toString(),
            binding.tvUsuario.text.toString(),
            binding.tvPassword.text.toString()
        )

    }

}

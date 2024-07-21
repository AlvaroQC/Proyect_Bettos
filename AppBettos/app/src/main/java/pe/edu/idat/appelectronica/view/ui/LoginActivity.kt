package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.appelectronica.R

import pe.edu.idat.appelectronica.databinding.ActivityLoginBinding
import pe.edu.idat.appelectronica.retrofit.response.LoginResponse
import pe.edu.idat.appelectronica.util.AppMensaje
import pe.edu.idat.appelectronica.util.TipoMensaje
import pe.edu.idat.appelectronica.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.btnIniciarSesion.setOnClickListener(this)
        binding.btnRegistrarse.setOnClickListener(this)
        authViewModel.loginResponse.observe(this, Observer {
            response -> obtenerDatosLogin(response)
        })

    }

    private fun obtenerDatosLogin(response: LoginResponse) {
        if(response.rpta){
            startActivity(Intent(applicationContext, GetStartActivity_inicio::class.java))
        }else{
            AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ERROR)
        }
        binding.btnIniciarSesion.isEnabled = true
        binding.btnRegistrarse.isEnabled = true
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnIniciarSesion -> autenticarUsuario()
            R.id.btnRegistrarse -> startActivity(Intent(applicationContext, RegistrarActivity::class.java))
        }
    }

    private fun autenticarUsuario() {
        binding.btnIniciarSesion.isEnabled = false
        binding.btnRegistrarse.isEnabled = false

        authViewModel.login(binding.tvUsuario.text.toString(),
            binding.tvPassword.text.toString())
    }

}
package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityTarjetaBinding
import pe.edu.idat.appelectronica.retrofit.response.RegistroTarjetaResponse
import pe.edu.idat.appelectronica.retrofit.response.ValidarTarjetaResponse
import pe.edu.idat.appelectronica.util.AppMensaje
import pe.edu.idat.appelectronica.util.TipoMensaje
import pe.edu.idat.appelectronica.viewmodel.AuthViewModel

class TarjetaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTarjetaBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTarjetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.btnGuatarTarjeta.setOnClickListener(this)
        binding.btnpagarT.setOnClickListener(this)
        authViewModel.registroTarjetaResponse.observe(this) { response ->
            obtenerDatosRegistro(response)
        }
        authViewModel.validarTarjetaResponse.observe(this){
            response -> validarDatosTarjeta(response)
        }
    }

    private fun validarDatosTarjeta(response: ValidarTarjetaResponse) {
        if(response.rpta){
            startActivity(Intent(applicationContext, CompraExitosaActivity::class.java))
        }else{
            startActivity(Intent(applicationContext, ErrorCompraActivity::class.java))
            AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ERROR)
        }
        //binding.btnIniciarSesion.isEnabled = true
        //binding.btnRegistrarse.isEnabled = true
    }

    private fun obtenerDatosRegistro(response: RegistroTarjetaResponse) {
        binding.btnpagarT.isEnabled = true
        binding.btnGuatarTarjeta.isEnabled = true
        AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ADVERTENCIA)
        limpiarCampos()
    }

    private fun limpiarCampos() {
        binding.txtnombreT.setText("")
        binding.txttarjetaT.setText("")
        binding.txtfechaT.setText("")
        binding.txtanioT.setText("")
        binding.txtccvT.setText("")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_guatar_tarjeta -> registrarTarjeta()
            R.id.btnpagarT -> validarCompra()
        }
    }

    private fun validarCompra() {
        authViewModel.validarTarjeta(binding.txtccvVT.text.toString())
    }

    private fun registrarTarjeta() {
        binding.btnGuatarTarjeta.isEnabled = false
        binding.btnpagarT.isEnabled = false
        authViewModel.regitroTarjeta(
            binding.txtnombreT.text.toString(),
            binding.txttarjetaT.text.toString(),
            binding.txtfechaT.text.toString(),
            binding.txtanioT.text.toString(),
            binding.txtccvT.text.toString()
        )
    }
}

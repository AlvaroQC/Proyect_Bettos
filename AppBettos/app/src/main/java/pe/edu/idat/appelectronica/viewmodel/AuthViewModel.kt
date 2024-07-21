package pe.edu.idat.appelectronica.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.appelectronica.repository.AuthRepository
import pe.edu.idat.appelectronica.retrofit.request.LoginRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.request.ValidarTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.response.LoginResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroTarjetaResponse
import pe.edu.idat.appelectronica.retrofit.response.ValidarTarjetaResponse

class AuthViewModel : ViewModel(){

    var loginResponse: LiveData<LoginResponse>
    var registroResponse: LiveData<RegistroResponse>
    var registroTarjetaResponse: LiveData<RegistroTarjetaResponse>
    var validarTarjetaResponse: LiveData<ValidarTarjetaResponse>

    private var repository = AuthRepository()
    init {
        loginResponse = repository.loginResponse
        registroResponse = repository.registroResponse
        registroTarjetaResponse = repository.registroTarjetaResponse
       validarTarjetaResponse = repository.validarTarjetaResponse
    }
    fun login(user:String, pass:String){
        loginResponse = repository.login(LoginRequest(user, pass))
    }

    fun validarTarjeta(CCV:String){
        validarTarjetaResponse = repository.validarTarjeta(ValidarTarjetaRequest(CCV))
    }

    fun registro(correo:String,
                 user:String,
                 pass:String){
        registroResponse = repository.registro(RegistroRequest(correo,user,pass))
    }

    fun regitroTarjeta(
        nombre:String,
        numeroTarjeta:String,
        fecha:String,
        anio:String,
        CCV:String,

    ){
        registroTarjetaResponse= repository.registroTarjeta(RegistroTarjetaRequest(nombre,numeroTarjeta,fecha,anio,CCV))
    }
}
package pe.edu.idat.appelectronica.retrofit

import pe.edu.idat.appelectronica.retrofit.request.LoginRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.request.ValidarTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.response.LoginResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroTarjetaResponse
import pe.edu.idat.appelectronica.retrofit.response.ValidarTarjetaResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ElectroServicio {

    //Aqui iran todos los recursos de la API realizado en Node
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("usuario")
    fun registrar(@Body registroRequest: RegistroRequest): Call<RegistroResponse>

    @POST("tarjeta")
    fun registrarTarjeta(@Body registroTarjetaRequest: RegistroTarjetaRequest): Call<RegistroTarjetaResponse>

    @POST("ccv")
    fun validarTarjeta(@Body validarTarjetaRequest: ValidarTarjetaRequest): Call<ValidarTarjetaResponse>
}
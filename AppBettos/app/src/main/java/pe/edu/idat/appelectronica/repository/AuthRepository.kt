package pe.edu.idat.appelectronica.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.appelectronica.retrofit.ElectroCliente
import pe.edu.idat.appelectronica.retrofit.request.LoginRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroRequest
import pe.edu.idat.appelectronica.retrofit.request.RegistroTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.request.ValidarTarjetaRequest
import pe.edu.idat.appelectronica.retrofit.response.LoginResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroResponse
import pe.edu.idat.appelectronica.retrofit.response.RegistroTarjetaResponse
import pe.edu.idat.appelectronica.retrofit.response.ValidarTarjetaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    var loginResponse= MutableLiveData<LoginResponse>()
    var registroResponse = MutableLiveData<RegistroResponse>()
    var registroTarjetaResponse = MutableLiveData<RegistroTarjetaResponse>()
    var validarTarjetaResponse = MutableLiveData<ValidarTarjetaResponse>()

    fun login(loginRequest: LoginRequest): MutableLiveData<LoginResponse> {
        val call: Call<LoginResponse> = ElectroCliente.retrofitService.login(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginResponse.value = response.body()
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return loginResponse
    }

    fun validarTarjeta( validarTarjetaRequest: ValidarTarjetaRequest): MutableLiveData<ValidarTarjetaResponse> {
        val call: Call<ValidarTarjetaResponse> = ElectroCliente.retrofitService.validarTarjeta(validarTarjetaRequest)
        call.enqueue(object : Callback<ValidarTarjetaResponse> {
            override fun onResponse(call: Call<ValidarTarjetaResponse>, response: Response<ValidarTarjetaResponse>) {
                 validarTarjetaResponse.value = response.body()
            }
            override fun onFailure(call: Call<ValidarTarjetaResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return validarTarjetaResponse
    }


    fun registro(registroRequest: RegistroRequest): MutableLiveData<RegistroResponse> {
        val call: Call<RegistroResponse> = ElectroCliente.retrofitService.registrar(registroRequest)
        call.enqueue(object : Callback<RegistroResponse> {
            override fun onResponse(call: Call<RegistroResponse>, response: Response<RegistroResponse>) {
                registroResponse.value = response.body()
            }
            override fun onFailure(call: Call<RegistroResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return registroResponse
    }

    fun registroTarjeta(registroTarjetaRequest: RegistroTarjetaRequest): MutableLiveData<RegistroTarjetaResponse> {
        val call: Call<RegistroTarjetaResponse> = ElectroCliente.retrofitService.registrarTarjeta(registroTarjetaRequest)
        call.enqueue(object : Callback<RegistroTarjetaResponse> {
            override fun onResponse(call: Call<RegistroTarjetaResponse>, response: Response<RegistroTarjetaResponse>) {
                registroTarjetaResponse.value = response.body()
            }
            override fun onFailure(call: Call<RegistroTarjetaResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return registroTarjetaResponse
    }
}
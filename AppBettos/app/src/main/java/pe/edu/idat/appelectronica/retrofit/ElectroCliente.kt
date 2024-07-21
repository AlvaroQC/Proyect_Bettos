package pe.edu.idat.appelectronica.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ElectroCliente {

    private var retrofitCliente = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(15, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("http://192.168.1.171:4000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(retrofitCliente)
        .build()

    val retrofitService: ElectroServicio by lazy {
        buildRetrofit().create(ElectroServicio::class.java)
    }
}
package pe.edu.idat.appelectronica.retrofit.request

data class RegistroTarjetaRequest(
    val nombre:String,
    val numeroTarjeta:String,
    val fecha:String,
    val anio:String,
    val CCV:String,
)



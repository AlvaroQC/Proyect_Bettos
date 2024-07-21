package pe.edu.idat.appelectronica.retrofit.response

data class ValidarTarjetaResponse (
    val nombre:String,
    val numeroTarjeta:String,
    val fecha:String,
    val anio:String,
    val CCV:String,
    val rpta: Boolean,
    val mensaje: String

)
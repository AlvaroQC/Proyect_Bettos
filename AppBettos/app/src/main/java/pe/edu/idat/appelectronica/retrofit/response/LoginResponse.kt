package pe.edu.idat.appelectronica.retrofit.response

data class LoginResponse (
    val id:Int,
    val correo:String,
    val user:String,
    val pass:String,
    var rpta: Boolean,
    var mensaje:String
)
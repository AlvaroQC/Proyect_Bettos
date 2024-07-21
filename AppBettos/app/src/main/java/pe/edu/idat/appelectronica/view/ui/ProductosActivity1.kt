package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityProductos1Binding

class ProductosActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityProductos1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductos1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProd1.setImageResource(R.drawable.monitor)
        binding.btnVolver1.setOnClickListener {
            finish()
        }
        binding.buttonComprar1.setOnClickListener {
            startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }
    private fun finish(v: View){
        when(v.id){
            R.id.btn_volver1 -> startActivity(Intent(applicationContext, CatologoActivity::class.java))
            R.id.button_comprar1 -> startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }
}

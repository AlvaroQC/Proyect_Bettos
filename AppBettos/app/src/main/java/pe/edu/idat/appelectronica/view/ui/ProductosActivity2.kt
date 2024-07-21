package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityProductos2Binding

class ProductosActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityProductos2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductos2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProd2.setImageResource(R.drawable.gaca)
        binding.btnVolver2.setOnClickListener {
            finish()
        }
        binding.btnComprar2.setOnClickListener {
            startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }

    private fun finish(v: View){
        when(v.id){
            R.id.btn_volver2 -> startActivity(Intent(applicationContext, CatologoActivity::class.java))
            R.id.btn_comprar2 -> startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }
}

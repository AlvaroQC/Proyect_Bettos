package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityProductos3Binding

class ProductosActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityProductos3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductos3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProd3.setImageResource(R.drawable.mr1)
        binding.btnVolver3.setOnClickListener {
            finish()
        }
        binding.btnComprar3.setOnClickListener {
            startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }

    private fun finish(v: View){
        when(v.id){
            R.id.btn_volver3 -> startActivity(Intent(applicationContext, CatologoActivity::class.java))
            R.id.btn_comprar3 -> startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }
}

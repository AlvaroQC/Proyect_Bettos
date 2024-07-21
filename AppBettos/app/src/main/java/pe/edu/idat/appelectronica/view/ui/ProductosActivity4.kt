package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityProductos4Binding

class ProductosActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityProductos4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductos4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProd4.setImageResource(R.drawable.fa)
        binding.btnVolver4.setOnClickListener {
            finish()
        }
        binding.btnComprar4.setOnClickListener {
            startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }

    private fun finish(v: View){
        when(v.id){
            R.id.btn_volver4 -> startActivity(Intent(applicationContext, CatologoActivity::class.java))
            R.id.btn_comprar4 -> startActivity(Intent(applicationContext, TipoPagoActivity::class.java))
        }
    }
}

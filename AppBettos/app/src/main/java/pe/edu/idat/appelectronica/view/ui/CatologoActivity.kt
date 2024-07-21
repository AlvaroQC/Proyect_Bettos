package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityCatologoBinding

class CatologoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatologoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatologoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCataProd1.setOnClickListener {
            startActivity(Intent(this, ProductosActivity1::class.java))
        }
        binding.btnCataProd2.setOnClickListener {
            startActivity(Intent(this, ProductosActivity2::class.java))
        }
        binding.btnCataProd3.setOnClickListener {
            startActivity(Intent(this, ProductosActivity3::class.java))
        }
        binding.btnCataProd4.setOnClickListener {
            startActivity(Intent(this, ProductosActivity4::class.java))
        }
        binding.btnImgmetodopago.setOnClickListener {
            startActivity(Intent(this, TipoPagoActivity::class.java))
        }
        binding.btnCataDatos.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
        binding.btnImgregistrar.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
    }
}

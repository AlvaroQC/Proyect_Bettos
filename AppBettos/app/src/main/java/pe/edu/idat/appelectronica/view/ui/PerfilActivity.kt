package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVolverRegistro.setOnClickListener {
            startActivity(Intent(this, CatologoActivity::class.java))
        }
        binding.btnCatalogoRegistro.setOnClickListener {
            startActivity(Intent(this, CatologoActivity::class.java))
        }
        binding.btnPagoRegistro.setOnClickListener {
            startActivity(Intent(this, TipoPagoActivity::class.java))
        }
    }
}


package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityCompraExitosaBinding



class CompraExitosaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCompraExitosaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraExitosaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnvolvermenu.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnvolvermenu -> startActivity(Intent(applicationContext, TarjetaActivity::class.java))

        }
    }
}
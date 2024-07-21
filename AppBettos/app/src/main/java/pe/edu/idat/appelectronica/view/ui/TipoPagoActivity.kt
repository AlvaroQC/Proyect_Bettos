package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityTipoPagoBinding

class TipoPagoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTipoPagoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTipoPagoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btndebito.setOnClickListener(this)
        binding.btncredito.setOnClickListener(this)
        binding.imgcredito.setImageResource(R.drawable.credito)
        binding.imgdebito.setImageResource(R.drawable.debito)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btndebito -> startActivity(Intent(applicationContext, TarjetaActivity::class.java))
            R.id.btncredito -> startActivity(Intent(applicationContext, TarjetaActivity::class.java))
        }
    }
}
package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appelectronica.R
import pe.edu.idat.appelectronica.databinding.ActivityErrorCompraBinding

class ErrorCompraActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityErrorCompraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErrorCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnretorno.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnretorno -> startActivity(Intent(applicationContext, TarjetaActivity::class.java))

        }
    }
}
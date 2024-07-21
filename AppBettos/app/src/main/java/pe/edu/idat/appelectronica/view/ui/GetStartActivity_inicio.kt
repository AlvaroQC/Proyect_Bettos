package pe.edu.idat.appelectronica.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.appelectronica.databinding.ActivityGetStartInicioBinding

class GetStartActivity_inicio : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGetStartInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetstarted.isEnabled = true
        binding.btnInicioSesionStarted.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, LOGIN_REQUEST_CODE)
        }
        binding.btnGetstarted.setOnClickListener {
            val intent = Intent(this, CatologoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LOGIN_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                binding.btnGetstarted.isEnabled = true
            }
        }
    }
    companion object{
        private const val LOGIN_REQUEST_CODE = 1001
    }
}

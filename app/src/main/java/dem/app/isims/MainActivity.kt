package dem.app.isims

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dem.app.isims.databinding.ActivityMainBinding
import java.io.Serializable

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()
    }

    private fun initEvent() {
        binding.next.setOnClickListener {
            val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
            loginIntent.putExtra(EXTRA_TAG, User())
            startActivity(loginIntent)

            //val callIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "59092722", null))
            //startActivity(callIntent)
        }
    }
}

class User : Serializable {
    val user = "hello"
}
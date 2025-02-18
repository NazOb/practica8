package mx.edu.itesca.practica8

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class movie_detaill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detaill)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val iv_movie_image:ImageView=findViewById(R.id.iv_movie_image)
        val tv_movie_name:TextView=findViewById(R.id.tv_movie_name)
        val tv_movie_desc:TextView=findViewById(R.id.tv_movie_desc)

        val bundle = intent.extras

        if(bundle!=null){
            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_name.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("sinopsis"))
        }

    }
}
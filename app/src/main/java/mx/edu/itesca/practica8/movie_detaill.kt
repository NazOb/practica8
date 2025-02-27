package mx.edu.itesca.practica8

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val tv_seats_left:TextView=findViewById(R.id.tv_seat_left)

        val btn_buy_tickets:Button=findViewById(R.id.btn_buy_tickets)

        val bundle = intent.extras

        if(bundle!=null){
            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_name.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("sinopsis"))
            tv_seats_left.setText(bundle.getInt("num_seats").toString()+" Seats available")
        }

        btn_buy_tickets.setOnClickListener {
            var intent : Intent = Intent(this,seat_selection::class.java)
            intent.putExtra("name", tv_movie_name.text.toString())
            startActivity(intent)
        }

    }
}
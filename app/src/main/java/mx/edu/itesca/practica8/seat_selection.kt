package mx.edu.itesca.practica8

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class seat_selection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv_title_seats : TextView = findViewById(R.id.tv_title_seats)
        var pos_movie = -1

        val bundle = intent.extras

        if (bundle!=null){
            tv_title_seats.setText(bundle.getString("name"))
            pos_movie = bundle.getInt("id")
        }

        val btn_confirm : Button = findViewById(R.id.btn_confirm)

        btn_confirm.setOnClickListener {
            Toast.makeText(this,"Enjoy the Movie! :D",Toast.LENGTH_LONG).show()
        }

        val rg_row1 : RadioGroup = findViewById(R.id.rg_row1)
        val rg_row2 : RadioGroup = findViewById(R.id.rg_row2)
        val rg_row3 : RadioGroup = findViewById(R.id.rg_row3)
        val rg_row4 : RadioGroup = findViewById(R.id.rg_row4)

        rg_row1.setOnCheckedChangeListener{
            group, checkedId->
            if(checkedId > -1){
                rg_row1.check(checkedId)
                rg_row2.clearCheck()
                rg_row3.clearCheck()
                rg_row4.clearCheck()
            }
        }

        rg_row2.setOnCheckedChangeListener{
                group, checkedId->
            if(checkedId > -1){
                rg_row2.check(checkedId)
                rg_row1.clearCheck()
                rg_row3.clearCheck()
                rg_row4.clearCheck()
            }
        }

        rg_row3.setOnCheckedChangeListener{
                group, checkedId->
            if(checkedId > -1){
                rg_row3.check(checkedId)
                rg_row1.clearCheck()
                rg_row2.clearCheck()
                rg_row4.clearCheck()
            }
        }

        rg_row4.setOnCheckedChangeListener{
                group, checkedId->
            if(checkedId > -1){
                rg_row4.check(checkedId)
                rg_row1.clearCheck()
                rg_row2.clearCheck()
                rg_row3.clearCheck()
            }
        }

    }
}
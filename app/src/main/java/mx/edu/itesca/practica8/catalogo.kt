package mx.edu.itesca.practica8

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridLayout
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class catalogo : AppCompatActivity() {
    var movies_adapter: MovieAdapter? = null
    var series_adapter: MovieAdapter? = null
    var movies = ArrayList<Movies>()
    var series = ArrayList<Movies>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catalogo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadMovies()

        movies_adapter = MovieAdapter(this,movies)
        series_adapter = MovieAdapter(this,series)

        var g_movies:GridView = findViewById(R.id.g_movies_catalog)
        var g_series:GridView = findViewById(R.id.g_series_catalog)

        g_movies.adapter = movies_adapter
        g_series.adapter = series_adapter

    }

    fun loadMovies(){
        movies.add(Movies("Big Hero 6",R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called \"Big Hero 6.\""))
        movies.add(Movies("Leap year",R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        series.add(Movies("",R.drawable.drhouse,R.drawable.drhouse,"The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        series.add(Movies("",R.drawable.smallville,R.drawable.smallvilleheader,"The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he's either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. Clark's friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark's outlandish valor. However, on the face of it, Clark just seems a normal boy who's slightly more secretive than usual."))

    }

    class MovieAdapter:BaseAdapter{
        var movies = ArrayList<Movies>()
        var context:Context? = null

        constructor(context: Context,movies: ArrayList<Movies>):super(){
            this.movies = movies
            this.context = context
        }

        override fun getCount(): Int {
            return movies.size
        }

        override fun getItem(position: Int): Any {
            return movies[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var movie = movies[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.movies,null)
//            flat
        }
    }
}
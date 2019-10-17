package com.husein.digitalent.moviee

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPoster: TypedArray
    private lateinit var dataLanguage: Array<String>
    private lateinit var dataRuntime: Array<String>
    private lateinit var dataGenres: Array<String>
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            Toast.makeText(this@MainActivity, movies[position].title, Toast.LENGTH_SHORT).show()
            val movie = Movie(
                movies[position].poster,
                movies[position].title,
                movies[position].description,
                movies[position].language,
                movies[position].runtime,
                movies[position].genres
            )
            val moveDetailIntent = Intent(this@MainActivity, DetailActivity::class.java)
            moveDetailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
            startActivity(moveDetailIntent)
        }
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.data_title)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
        dataLanguage = resources.getStringArray(R.array.data_language)
        dataRuntime = resources.getStringArray(R.array.data_runtime)
        dataGenres = resources.getStringArray(R.array.data_genres)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPoster.getResourceId(position, -1),
                dataTitle[position],
                dataDescription[position],
                dataLanguage[position],
                dataRuntime[position],
                dataGenres[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}

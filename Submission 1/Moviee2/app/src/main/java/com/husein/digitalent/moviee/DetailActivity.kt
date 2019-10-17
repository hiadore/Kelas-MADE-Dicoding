package com.husein.digitalent.moviee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivPoster: ImageView = findViewById(R.id.dt_poster)
        val tvTitle: TextView = findViewById(R.id.dt_title)
        val tvDesc: TextView = findViewById(R.id.dt_desc)
        val tvLang: TextView = findViewById(R.id.dt_lang_content)
        val tvRuntime: TextView = findViewById(R.id.dt_rt_content)
        val tvGenres: TextView = findViewById(R.id.dt_genre_content)

        val movieDetail = intent.getParcelableExtra(EXTRA_MOVIE) as Movie
        ivPoster.setImageResource(movieDetail.poster)
        tvTitle.text = movieDetail.title
        tvDesc.text = movieDetail.description
        tvLang.text = movieDetail.language
        tvRuntime.text = movieDetail.runtime
        tvGenres.text = movieDetail.genres
    }
}
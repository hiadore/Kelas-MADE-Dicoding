package com.husein.digitalent.moviee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var movies = arrayListOf<Movie>()

    override fun getCount(): Int {
        return movies.size
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getItem(i: Int): Any {
        return movies[i]
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.movie_item, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Movie
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_title)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_poster)
        internal fun bind(movie: Movie) {
            txtName.text = movie.title
            txtDescription.text = movie.description
            imgPhoto.setImageResource(movie.poster)
        }
    }
}
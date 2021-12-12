package com.example.clonealfred.prenseter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clonealfred.databinding.ItemListBinding
import com.example.clonealfred.model.Film

class FilmAdapter(private val films: ArrayList<Film>, var onItemClick: (Film) -> Unit = {}) :
    RecyclerView.Adapter<FilmAdapter.Holder>() {

    inner class Holder(private val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root), View.OnClickListener {

        private lateinit var film: Film

        init {
            itemListBinding.handleClick = this
        }

        fun add(user: Film) {
            itemListBinding.film = user
            this.film = user
        }

        override fun onClick(v: View?) {
            if(::film.isInitialized){
                onItemClick(film)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.add(films[position])
    }

    override fun getItemCount(): Int {
        return films.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newFilms: ArrayList<Film>) {
        films.addAll(newFilms)
        this.notifyDataSetChanged()
    }
}
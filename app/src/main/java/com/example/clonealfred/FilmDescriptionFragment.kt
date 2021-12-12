package com.example.clonealfred

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.clonealfred.databinding.FragmentFilmDescriptionBinding

class FilmDescriptionFragment : Fragment() {

    private lateinit var filmDescriptionBinding: FragmentFilmDescriptionBinding
    private val args: FilmDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        filmDescriptionBinding =
            FragmentFilmDescriptionBinding.inflate(LayoutInflater.from(context), container, false)
        filmDescriptionBinding.film = args.film
        return filmDescriptionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmDescriptionBinding.topAppBar.setNavigationOnClickListener { findNavController().popBackStack() }
    }
}
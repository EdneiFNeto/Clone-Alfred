package com.example.clonealfred.prenseter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.clonealfred.databinding.FragmentMainBinding
import com.example.clonealfred.model.Film
import com.example.clonealfred.prenseter.adapter.FilmAdapter
import com.example.clonealfred.prenseter.viewmodel.FilmViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val filmViewModel by viewModel<FilmViewModel>()
    private val films: ArrayList<Film> = ArrayList()
    private lateinit var filmAdater: FilmAdapter
    private lateinit var fragmentMainBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding =
            FragmentMainBinding.inflate(LayoutInflater.from(context), container, false)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun onResume() {
        super.onResume()
        addItemAdapter()
        goToDescriptionFilm()
    }

    private fun initAdapter() {
        filmAdater = FilmAdapter(films)
        fragmentMainBinding.recycleViewAgenda.apply {
            adapter = filmAdater
        }
    }

    private fun addItemAdapter() {
        fragmentMainBinding.progressBar.visibility = View.VISIBLE

        filmViewModel.getFilms().observe(viewLifecycleOwner, {
            fragmentMainBinding.progressBar.visibility = View.GONE
            it?.let {
                filmAdater.update(it.data)
            }
        })
    }

    private fun goToDescriptionFilm() {
        filmAdater.onItemClick = {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToFilmDescriptionFragment(
                    it
                )
            )
        }
    }
}
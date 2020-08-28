package com.example.rssfinaltask.ui.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rssfinaltask.data.Constants.LOG_TAG
import com.example.rssfinaltask.data.repository.Resource
import com.example.rssfinaltask.databinding.FragmentMainBinding
import com.example.rssfinaltask.ui.mainscreen.adapter.MovieAdapter
import com.example.rssfinaltask.viewmodel.mainscreen.MainFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.KoinComponent
import org.koin.core.get

class MainFragment : Fragment(), KoinComponent {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MainFragmentViewModel = get()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter()
        with(binding.recyclerView) {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
        viewModel.getMovies().observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
//                    Log.d(LOG_TAG, it.data[0].title)
                    movieAdapter.submitList(it.data)
                }
                is Resource.Error -> {
                    Log.e(LOG_TAG, it.throwable.message.toString())
                    Log.e(LOG_TAG, it.throwable.printStackTrace().toString())
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG = MainFragment::class.java.simpleName

        fun newInstance() = MainFragment()
    }
}

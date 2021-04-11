package com.example.mvvmimagesearch.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmimagesearch.R
import com.example.mvvmimagesearch.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {


    private var _binding: FragmentGalleryBinding? = null
    private val viewModel : GalleryViewModel by viewModels()
   // private val exampleViewModel: ExampleViewModel by viewModels()
    private val binding  get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       _binding = FragmentGalleryBinding.bind(view)
        val adapter = UnsplashPhotoAdapter()
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter

        }

        viewModel.photos.observe(viewLifecycleOwner) {
        adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
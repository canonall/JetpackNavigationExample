package com.canonal.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.canonal.jetpacknavigation.databinding.FragmentDeepLinkBinding


class DeepLinkFragment : Fragment() {

    private lateinit var binding: FragmentDeepLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDeepLinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DeepLinkFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
package com.canonal.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.canonal.jetpacknavigation.R
import com.canonal.jetpacknavigation.databinding.FragmentHomeBinding
import com.canonal.jetpacknavigation.util.AnimUtil


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navOptions = AnimUtil.getDefaultSlideNavOption()

        binding.btnNavigateDestination.setOnClickListener {
            findNavController().navigate(
                R.id.flowStepOneFragment,
                null,
                navOptions
            )
        }

        binding.btnNavigateAction.setOnClickListener {
            //create action and give actionID rather than destinationID
            //you can define a bundle and pass it as parameter and get the data
            //from destination fragment
            findNavController().navigate(
                R.id.action_homeFragment_to_flowStepOneFragment,
                null,
                navOptions
            )

        }
       // binding.btnNavigateAction.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_flowStepOneFragment,null))

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
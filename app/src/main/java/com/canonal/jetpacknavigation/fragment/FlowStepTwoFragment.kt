package com.canonal.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canonal.jetpacknavigation.R
import com.canonal.jetpacknavigation.databinding.FragmentFlowStepTwoBinding

class FlowStepTwoFragment : Fragment() {

    private lateinit var binding: FragmentFlowStepTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowStepTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val safeArgs: FlowStepOneFragmentArgs by navArgs()
        val number = safeArgs.number

        binding.tvName.text = number.toString()

        binding.btnNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_flowStepTwoFragment_to_homeFragment,
                null
            )
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            FlowStepTwoFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
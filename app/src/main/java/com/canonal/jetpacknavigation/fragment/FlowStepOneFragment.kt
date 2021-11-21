package com.canonal.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canonal.jetpacknavigation.R
import com.canonal.jetpacknavigation.databinding.FragmentFlowStepOneBinding
import com.canonal.jetpacknavigation.util.AnimUtil


class FlowStepOneFragment : Fragment() {

    private lateinit var binding: FragmentFlowStepOneBinding

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
        binding = FragmentFlowStepOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navOption = AnimUtil.getDefaultSlideNavOption()

        binding.btnNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_flowStepOneFragment_to_flowStepTwoFragment,
                null,
                navOption
            )
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FlowStepOneFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
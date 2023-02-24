package com.example.jsonplaceholder.ui

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.jsonplaceholder.R
import com.example.jsonplaceholder.databinding.FragmentGetCommentsBinding
import com.example.jsonplaceholder.result


class GetCommentsFragment :
    BaseFragment<FragmentGetCommentsBinding>(FragmentGetCommentsBinding::inflate) {

    private var isOpen = false
    private val adapter = CommentAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fabOpen = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_clockwise)
        val fabRAntiClockwise =
            AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_anticlockwise)

        viewBinding.recyclerView.adapter = adapter
        viewmodel.getComments.observe(viewLifecycleOwner) {
            it.result(onSuccess = {
                adapter.submitList(it)
            },
                onError = {},
                onLoading = {

                }

            )
        }

        viewBinding.showActionWithComments.setOnClickListener {
            isOpen = if (isOpen) {
                viewBinding.showActionWithComments.startAnimation(fabRClockwise)
                viewBinding.topFab.startAnimation(fabClose)
                viewBinding.bottomFab.startAnimation(fabClose)
                false
            } else {
                viewBinding.showActionWithComments.startAnimation(fabRAntiClockwise)
                viewBinding.topFab.startAnimation(fabOpen)
                viewBinding.bottomFab.startAnimation(fabOpen)
                true
            }
        }
        viewmodel.getComments.observe(viewLifecycleOwner) {

        }

        viewBinding.topFab.setOnClickListener {
            viewmodel.getComments()
        }

        viewBinding.bottomFab.setOnClickListener {
            viewmodel.getComments("posts/2/comments")
        }
    }
}
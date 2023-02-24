package com.example.jsonplaceholder.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.example.jsonplaceholder.R
import com.example.jsonplaceholder.databinding.FragmentGetPostBinding
import com.example.jsonplaceholder.result

class GetPostFragment :
    BaseFragment<FragmentGetPostBinding>(FragmentGetPostBinding::inflate) {
    val adapter = Adapter()

    val parameter: MutableMap<String, String> = HashMap<String, String>().apply {
        put("userId", "1")
        put("_sort", "id")
        put("_order", "desc")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getPosts()
        viewBinding.recyclerView.adapter = adapter

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.getposts, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.empty -> {
                        viewmodel.getPosts()
                        return true
                    }
                    R.id.map -> {
                        viewmodel.getPosts(parameter)
                        return true
                    }
                    R.id.query -> {
                        viewmodel.getPosts(1, "id", "desc")
                        return true
                    }
                    else ->
                        return false

                }
            }
        }, viewLifecycleOwner, Lifecycle.State.STARTED)
    }

    override fun onStart() {
        super.onStart()
        viewmodel.getPosts.observe(viewLifecycleOwner) {
            it.result(onSuccess = { posts ->
                viewBinding.progress.visibility = View.INVISIBLE
                adapter.submitList(posts)
            },
                onError = {

                },
                onLoading = {
                    viewBinding.progress.visibility = View.VISIBLE
                })
        }
    }
}
package com.example.jsonplaceholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jsonplaceholder.databinding.ActivityMainBinding
import com.example.jsonplaceholder.viewmodel.MainViewModel
import com.example.jsonplaceholder.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController!!)

        val api = (application as App).provideApi()

        val viewModel =
            ViewModelProvider(this, MainViewModelFactory(api))[MainViewModel::class.java]

//        viewModel.getPosts()
//        viewModel.data.observe(this) { event ->
//            if (!event.code.isNullOrEmpty()) {
//                binding.textViewResult.text = "Code: ${event.code}"
//            } else if (!event.data.isNullOrEmpty()) {
//                for (comment in event.data!!) {
//                    var content = ""
//                    content += """
//                    ${"ID: " + comment.id}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Post ID: " + comment.id}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Name: " + comment.title}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Email: " + comment.text}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Text: " + comment.text}
//
//
//                    """.trimIndent()
//                    binding.textViewResult.append(content)
//                }
//            }
//
//        }
//
//        //getPosts();
        //getComments();
        //createPost();
        //updatePost();

        //getPosts();
        //getComments();
        //createPost();
        //updatePost();
        // viewModel.deletePost()

    }
//    private fun getComments() {
//        val call: Call<List<Comment>> = jsonPlaceHolderApi
//            .getComments("https://jsonplaceholder.typicode.com/posts/3/comments")
//        call.enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (!response.isSuccessful) {
//                    binding.textViewResult.text = "Code: " + response.code()
//                    return
//                }
//                val comments: List<Comment> = response.body()!!
//                for (comment in comments) {
//                    var content = ""
//                    content += """
//                    ${"ID: " + comment.id}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Post ID: " + comment.postId}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Name: " + comment.name}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Email: " + comment.email}
//
//                    """.trimIndent()
//                    content += """
//                    ${"Text: " + comment.text}
//
//
//                    """.trimIndent()
//                    binding.textViewResult.append(content)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                binding.textViewResult.text = t.message
//            }
//        })
//    }
//
//    private fun createPost() {
//        val post = Post(23, "New Title", "New Text")
//        val fields: MutableMap<String, String> = HashMap()
//        fields["userId"] = "25"
//        fields["title"] = "New Title"
//        val call: Call<Post> = jsonPlaceHolderApi.createPost(fields)
//        call.enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                if (!response.isSuccessful) {
//                    binding.textViewResult.text = "Code: " + response.code()
//                    return
//                }
//                val postResponse: Post = response.body()!!
//                var content = ""
//                content += """
//                 ${"Code: " + response.code()}
//
//                 """.trimIndent()
//                content += """
//                 ${"ID: " + postResponse.id}
//
//                 """.trimIndent()
//                content += """
//                 ${"User ID: " + postResponse.userId}
//
//                 """.trimIndent()
//                content += """
//                 ${"Title: " + postResponse.title}
//
//                 """.trimIndent()
//                content += """
//                 ${"Text: " + postResponse.text}
//
//
//                 """.trimIndent()
//                binding.textViewResult.text = content
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                binding.textViewResult.text = t.message
//            }
//        })
//    }
//
//    private fun updatePost() {
//        val post = Post(12, null, "New Text")
//        val call = jsonPlaceHolderApi.patchPost(5, post)
//        call.enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                if (!response.isSuccessful) {
//                    binding.textViewResult.text = "Code: " + response.code()
//                    return
//                }
//                val postResponse: Post = response.body()!!
//                var content = ""
//                content += """
//                 ${"Code: " + response.code()}
//
//                 """.trimIndent()
//                content += """
//                 ${"ID: " + postResponse.id}
//
//                 """.trimIndent()
//                content += """
//                 ${"User ID: " + postResponse.userId}
//
//                 """.trimIndent()
//                content += """
//                 ${"Title: " + postResponse.title}
//
//                 """.trimIndent()
//                content += """
//                 ${"Text: " + postResponse.text}
//
//
//                 """.trimIndent()
//                binding.textViewResult.text = content
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                binding.textViewResult.text = t.message
//            }
//        })
//    }

//    private fun deletePost() {
//        val handler = CoroutineExceptionHandler { _, exception ->
//            binding.textViewResult.text = exception.message
//        }
//        lifecycleScope.launch(Dispatchers.Main + handler) {
//            val call = jsonPlaceHolderApi.deletePost(5)
//            val result = call.enqueueGETCall<Nothing, Int>()
//            Log.d("TAG", result.toString())
//        }
//    }

//    val call = jsonPlaceHolderApi.deletePost(5)
//    call.enqueue(
//    object : Callback<Nothing> {
//        override fun onResponse(call: Call<Nothing>, response: Response<Nothing>) {
//            binding.textViewResult.text = "Code: " + response.code()
//        }
//
//        override fun onFailure(call: Call<Nothing>, t: Throwable) {
//            binding.textViewResult.text = t.message
//        }
//    })
}
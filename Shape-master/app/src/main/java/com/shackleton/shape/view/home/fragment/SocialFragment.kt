package com.shackleton.shape.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.custom.adapter.PostAdapter
import com.shackleton.shape.databinding.FragmentSocialBinding
import com.shackleton.shape.db.laravel.model.Post
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.service.PostAPI
import com.shackleton.shape.view.home.MainHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SocialFragment : Fragment() {

    private var _binding: FragmentSocialBinding? = null

    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openConnection().create(PostAPI::class.java).getAllPost(getAuthHeader())
            .enqueue(object : Callback<GeneralListResponse<Post>>{
                override fun onResponse(
                    call: Call<GeneralListResponse<Post>>,
                    response: Response<GeneralListResponse<Post>>
                ) {
                    if (response.isSuccessful){
                        binding.postAdapter.adapter =
                            response.body()?.data?.let { PostAdapter(it, binding.root) }
                    }
                }

                override fun onFailure(call: Call<GeneralListResponse<Post>>, t: Throwable) {
                    println("Error: ${t.message}")
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSocialBinding.inflate(inflater, container, false)
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)

        return binding.root
    }


}
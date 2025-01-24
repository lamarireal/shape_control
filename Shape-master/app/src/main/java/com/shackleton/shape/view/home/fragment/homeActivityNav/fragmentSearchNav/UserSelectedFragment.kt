package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentSearchNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shackleton.shape.custom.adapter.PostAdapter
import com.shackleton.shape.databinding.FragmentUserSelectedBinding
import com.shackleton.shape.db.laravel.model.Post
import com.shackleton.shape.db.laravel.model.User
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import com.shackleton.shape.db.laravel.request.service.PostAPI
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.view.home.MainHome
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserSelectedFragment : Fragment() {
    private var _binding: FragmentUserSelectedBinding? = null

    private val binding get() = _binding!!

    private val args: UserSelectedFragmentArgs by navArgs()

    private lateinit var user: User
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserSelectedBinding.inflate(inflater, container, false)

        (activity as? MainHome)?.setBottomNavigationVisibility(View.GONE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isFollowing()

        openConnection().create(UserApi::class.java).getUserByNick(args.parameter[0])
            .enqueue(object : Callback<GeneralResponse2<User>> {
                override fun onResponse(
                    call: Call<GeneralResponse2<User>>,
                    response: Response<GeneralResponse2<User>>
                ) {
                    if (response.isSuccessful) {
                        user = response.body()?.data!!
                        Picasso.get().load(user.user_image_url).into(binding.imagenPerfil)
                        binding.titleUserNick.text = user.nick
                        binding.titleName.text = user.full_name

                        openConnection().create(PostAPI::class.java).getPostsFromUser(getAuthHeader(),user.id)
                            .enqueue(object : Callback<GeneralListResponse<Post>>{
                                override fun onResponse(
                                    call: Call<GeneralListResponse<Post>>,
                                    response: Response<GeneralListResponse<Post>>
                                ) {
                                    if (response.isSuccessful){
                                        binding.postsUser.adapter = response.body()?.data?.let { PostAdapter(it,binding.root) }
                                    }
                                }

                                override fun onFailure(call: Call<GeneralListResponse<Post>>, t: Throwable) {
                                    println("Error : ${t.message}")
                                }
                            })

                        binding.numeroSeguidores.text = user.followers_count.toString()

                    }
                }

                override fun onFailure(call: Call<GeneralResponse2<User>>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })

        binding.btnSeguir.setOnClickListener {

            with(binding){
                if (btnSeguir.text ==  "SEGUIR"){
                    var s = numeroSeguidores.text.toString().toInt()
                    s+=1
                    numeroSeguidores.text = s.toString()
                    follow()
                    btnSeguir.text = "DEJAR DE SEGUIR"
                }else{
                    var s = numeroSeguidores.text.toString().toInt()
                    s-=1
                    numeroSeguidores.text = s.toString()
                    btnSeguir.text = "SEGUIR"
                    unfollow()
                }
            }
        }
    }

    private fun isFollowing(){
        openConnection().create(UserApi::class.java).isFollowing1(getAuthHeader(),args.parameter[1].toInt())
            .enqueue(object : Callback<GeneralResponse>{
                override fun onResponse(
                    call: Call<GeneralResponse>,
                    response: Response<GeneralResponse>
                ) {
                    if (response.isSuccessful){
                        val isF = response.body()?.data
                        println(isF)
                        if (isF == "1"){
                            binding.btnSeguir.text ="DEJAR DE SEGUIR"
                        }else{
                            binding.btnSeguir.text ="SEGUIR"
                        }
                    }
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    println("Error: ${t.message}")
                }

            })
    }
    private fun follow(){
        openConnection().create(UserApi::class.java).follow(getAuthHeader(),args.parameter[1].toInt())
            .enqueue(object : Callback<GeneralResponse>{
                override fun onResponse(
                    call: Call<GeneralResponse>,
                    response: Response<GeneralResponse>
                ) {

                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    println("Error: ${t.message}")
                }

            })
    }
    private fun unfollow(){
        openConnection().create(UserApi::class.java).unfollow(getAuthHeader(),args.parameter[1].toInt())
            .enqueue(object : Callback<GeneralResponse>{
                override fun onResponse(
                    call: Call<GeneralResponse>,
                    response: Response<GeneralResponse>
                ) {

                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                   println("Error: ${t.message}")
                }

            })
    }

}
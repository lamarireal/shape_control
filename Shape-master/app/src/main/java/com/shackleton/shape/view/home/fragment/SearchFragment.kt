package com.shackleton.shape.view.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shackleton.shape.custom.adapter.UsuarioAdapter
import com.shackleton.shape.databinding.FragmentSeachBinding
import com.shackleton.shape.db.laravel.model.User
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse2
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.view.home.MainHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale


class SearchFragment : Fragment() {
    private var _binding: FragmentSeachBinding? = null
    private val binding get() = _binding!!

    private lateinit var mlistU : MutableList<User>

    private lateinit var usuarioAdapter : UsuarioAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeachBinding.inflate(inflater, container, false)

        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mlistU = mutableListOf()
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(LinearLayoutManager(requireContext()));


        openConnection().create(UserApi::class.java).getAllUsers()
            .enqueue(object : Callback<GeneralListResponse2<User>>{
                override fun onResponse(
                    call: Call<GeneralListResponse2<User>>,
                    response: Response<GeneralListResponse2<User>>
                ) {
                    if(response.isSuccessful){
                        mlistU = response.body()?.data!!
                        usuarioAdapter = UsuarioAdapter(mlistU,requireContext(),binding.root)

                        binding.recyclerView.adapter = usuarioAdapter
                        usuarioAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<GeneralListResponse2<User>>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })



    }
    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList: ArrayList<User> = ArrayList()
            for (item in mlistU) {
                if (item.nick.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(item)
                }
            }
            if (filteredList.isNotEmpty()) {

                usuarioAdapter.setFilteredList(filteredList)
            }
        }
    }

}
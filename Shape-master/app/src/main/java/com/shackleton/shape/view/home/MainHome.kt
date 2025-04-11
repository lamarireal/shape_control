package com.shackleton.shape.view.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ActivityMainHomeBinding
import com.shackleton.shape.shared.SharedApp
import com.shackleton.shape.view.home.fragment.HomeFragmentDirections
import com.shackleton.shape.view.home.fragment.ProfileFragmentDirections
import com.shackleton.shape.view.home.fragment.ProjectFragmentDirections
import com.shackleton.shape.view.home.fragment.SearchFragmentDirections
import com.shackleton.shape.view.home.fragment.SocialFragmentDirections
import com.shackleton.shape.view.session.MainSession


class MainHome : AppCompatActivity() {

    companion object {
        val HOME_ITEM = R.id.fragment_home
        val SOCIAL_ITEM = R.id.fragment_Social
        val PROJECT_ITEM = R.id.fragment_Project
        val SEARCH_ITEM = R.id.fragment_Search
        val PROFILE_ITEM = R.id.fragment_profile
    }

    private lateinit var binding: ActivityMainHomeBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigationVisibility(View.VISIBLE)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        binding.setUpBottomNavigation()
        setupOnBackPressed()

        //val navigationView = binding.conf
        //val headerView = navigationView.getHeaderView(0)

        //val imageView = headerView.findViewById<ImageView>(R.id.imagenUser)
        //val textViewNombre = headerView.findViewById<TextView>(R.id.nombreUser)
        //val textViewCorreo = headerView.findViewById<TextView>(R.id.correoUser)

        binding.logout.setOnClickListener {
            finish()
            SharedApp.preferences.user =
                com.shackleton.shape.db.laravel.model.User(-1, "null", "null", "null","",0)
            SharedApp.preferences.session = ""
            SharedApp.preferences.imageURL = "dx"

            val intent = Intent(this, MainSession::class.java)
            startActivity(intent)
        }


        //val name = "${SharedApp.preferences.user.name} ${SharedApp.preferences.user.last_name}"

        /*textViewNombre.text = name
        textViewCorreo.text = SharedApp.preferences.user.email*/

        /*binding.menuAccess.setOnClickListener {
            binding.main.open()
            binding.conf
        }*/
    }

    private fun ActivityMainHomeBinding.setUpBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener {menu->
            getCurrentFragmentId()?.let {
                navigateToFragment(menu.itemId,it)
            }
            true
        }
    }

    private fun navigateToFragment(itemId: Int, fragmentId: Int) {
        val action = when {
            itemId == R.id.Social && fragmentId == HOME_ITEM -> HomeFragmentDirections.actionHomeFragmentToSocialFragment2()
            itemId == R.id.Proyectos && fragmentId == HOME_ITEM -> HomeFragmentDirections.actionHomeFragmentToProjectFragment4()
            itemId == R.id.Explorar && fragmentId == HOME_ITEM -> HomeFragmentDirections.actionHomeFragmentToSearchFragment3()
            itemId == R.id.Perfil && fragmentId == HOME_ITEM -> HomeFragmentDirections.actionHomeFragmentToProfileFragment4()

            itemId == R.id.Inicio && fragmentId == SOCIAL_ITEM -> SocialFragmentDirections.actionSocialFragment2ToHomeFragment()
            itemId == R.id.Proyectos && fragmentId == SOCIAL_ITEM -> SocialFragmentDirections.actionSocialFragment2ToProjectFragment4()
            itemId == R.id.Explorar && fragmentId == SOCIAL_ITEM -> SocialFragmentDirections.actionSocialFragment2ToSearchFragment3()
            itemId == R.id.Perfil && fragmentId == SOCIAL_ITEM -> SocialFragmentDirections.actionSocialFragment2ToProfileFragment4()

            itemId == R.id.Inicio && fragmentId == PROJECT_ITEM -> ProjectFragmentDirections.actionProjectFragment4ToHomeFragment()
            itemId == R.id.Social && fragmentId == PROJECT_ITEM -> ProjectFragmentDirections.actionProjectFragment4ToSocialFragment2()
            itemId == R.id.Explorar && fragmentId == PROJECT_ITEM -> ProjectFragmentDirections.actionProjectFragment4ToSearchFragment3()
            itemId == R.id.Perfil && fragmentId == PROJECT_ITEM -> ProjectFragmentDirections.actionProjectFragment4ToProfileFragment4()

            itemId == R.id.Inicio && fragmentId == SEARCH_ITEM -> SearchFragmentDirections.actionSearchFragment3ToHomeFragment()
            itemId == R.id.Social && fragmentId == SEARCH_ITEM -> SearchFragmentDirections.actionSearchFragment3ToSocialFragment2()
            itemId == R.id.Proyectos && fragmentId == SEARCH_ITEM -> SearchFragmentDirections.actionSearchFragment3ToProjectFragment4()
            itemId == R.id.Perfil && fragmentId == SEARCH_ITEM -> SearchFragmentDirections.actionSearchFragment3ToProfileFragment4()

            itemId == R.id.Inicio && fragmentId == PROFILE_ITEM -> ProfileFragmentDirections.actionProfileFragment4ToHomeFragment()
            itemId == R.id.Social && fragmentId == PROFILE_ITEM -> ProfileFragmentDirections.actionProfileFragment4ToSocialFragment2()
            itemId == R.id.Proyectos && fragmentId == PROFILE_ITEM -> ProfileFragmentDirections.actionProfileFragment4ToProjectFragment42()
            itemId == R.id.Explorar && fragmentId == PROFILE_ITEM -> ProfileFragmentDirections.actionProfileFragment4ToSearchFragment3()

            else -> null

        }
        /*if (
            (itemId == PROFILE_ITEM && fragmentId == EVALUA2_ITEM) ||
            (itemId == SOCIAL_ITEM && fragmentId == EVALUA2_ITEM) ||
            (itemId == PROJECT_ITEM && fragmentId == EVALUA2_ITEM) ||
            (itemId == SEARCH_ITEM && fragmentId == EVALUA2_ITEM) ||
            (itemId == PROFILE_ITEM && fragmentId == EVALUA_ITEM) ||
            (itemId == SOCIAL_ITEM && fragmentId == EVALUA_ITEM) ||
            (itemId == PROJECT_ITEM && fragmentId == EVALUA_ITEM) ||
            (itemId == SEARCH_ITEM && fragmentId == EVALUA_ITEM)
            )
            {
                warningMessage()
            }*/
        action?.let {
            navController.navigate(it)
        }
    }


    private fun setupOnBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (getCurrentFragmentId() == HOME_ITEM) {
                    super.handleOnBackCancelled()
                } else {
                    when (getCurrentFragmentId()) {
                        PROFILE_ITEM -> {
                            val action =
                                ProfileFragmentDirections.actionProfileFragment4ToHomeFragment()
                            navController.navigate(action)
                        }

                        SEARCH_ITEM -> {
                            val action =
                                SearchFragmentDirections.actionSearchFragment3ToHomeFragment()
                            navController.navigate(action)
                        }

                        PROJECT_ITEM -> {
                            val action =
                                ProjectFragmentDirections.actionProjectFragment4ToHomeFragment()
                            navController.navigate(action)
                        }

                        SOCIAL_ITEM -> {
                            val action =
                                SocialFragmentDirections.actionSocialFragment2ToHomeFragment()
                            navController.navigate(action)
                        }

                        else -> {
                            navController.navigateUp()
                        }
                    }
                }
            }
        })
    }


    private fun getCurrentFragmentId(): Int? {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val currentFragment = navHostFragment.childFragmentManager
        return currentFragment.primaryNavigationFragment?.view?.id
    }
    fun setBottomNavigationVisibility(visibility: Int) {
        binding.bottomNavigation.visibility = visibility
    }


    fun hideToolbar() {
        binding.toolbar.visibility = View.GONE
    }

    fun showToolbar() {
        binding.toolbar.visibility = View.VISIBLE
    }


}
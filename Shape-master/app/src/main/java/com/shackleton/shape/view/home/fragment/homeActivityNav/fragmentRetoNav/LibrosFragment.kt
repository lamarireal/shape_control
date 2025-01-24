package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentRetoNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shackleton.shape.databinding.FragmentLibrosBinding
import com.squareup.picasso.Picasso


class LibrosFragment : Fragment() {

    private val args: LibrosFragmentArgs by navArgs()

    private var _binding: FragmentLibrosBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = args.resumen[0]
        val resumen = args.resumen[1]
        val url = args.resumen[2]

        binding.title.text = title
        binding.description.text = resumen
        Picasso.get().load(url).into(binding.imagenReto)

        binding.button.setOnClickListener{
            findNavController().navigate(LibrosFragmentDirections.actionLibrosFragmentToPreguntasFragment(title = arrayOf(title,url)))
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLibrosBinding.inflate(inflater, container, false)

        return binding.root
    }

}
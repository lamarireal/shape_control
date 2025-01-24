package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentInspirateNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.custom.adapter.PodcastAdapter
import com.shackleton.shape.databinding.FragmentPodcastBinding
import com.shackleton.shape.db.laravel.model.Inspirate

class PodcastFragment : Fragment() {

    private lateinit var binding: FragmentPodcastBinding
    private var cargar: List<Inspirate> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPodcastBinding.inflate(inflater, container, false)
        cargar = cargarList()

        binding.recyclerInspirate.adapter = PodcastAdapter(cargar, requireActivity())

        return binding.root
    }

    private fun cargarList(): List<Inspirate> {
        return listOf(
            Inspirate(
                "Itnig - Podcast",
                "Descubre las últimas tendencias y consejos sobre emprendimiento, tecnología y startups con los expertos de Itnig en este podcast inspirador.",
                "Escuchar Podcast",
                "https://images.unsplash.com/photo-1593697820826-2e76c9720a99?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw5fHxwb2RjYXN0fGVufDF8fHx8MTY4ODAyNjYyNHww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Inspirate(
                "Dementes - Podcast",
                "Adentrate en las mentes creativas y visionarias de los emprendedores más exitosos mientras comparten sus historias y consejos para el exito empresarial",
                "Escuchar Podcast",
                "https://images.unsplash.com/photo-1625123628171-67518580f951?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzMXx8cG9kY2FzdHxlbnwxfHx8fDE2ODgwMjY2NDF8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Inspirate(
                "Boss Tank - Podcast",
                "Sumérgete en el mundo de los emprendedores y startups con este podcast. Escucha historias inspiradoras y aprende valiosas lecciones de negocios.",
                "Escuchar Podcast",
                "https://images.unsplash.com/photo-1625645841510-c32e9a68bf5e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw2N3x8cG9kY2FzdHxlbnwxfHx8fDE2ODgwMjY2OTd8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Inspirate(
                "Mujeres Emprendedoras - Podcast",
                "Inspírate con las historias de mujeres emprendedoras que han superado obstáculos y han logrado el éxito en el mundo empresarial.",
                "Escuchar Podcast",
                "https://images.unsplash.com/photo-1625123627242-97ef1000c6d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzOHx8cG9kY2FzdHxlbnwxfHx8fDE2ODgwMjY2NDF8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Inspirate(
                "Open - Podcast",
                "Explora los deafíos y oportunidades del emprendimiento y la innovación con entrevistas a líderes empresariales, expertos y pensadores creativos.",
                "Escuchar Podcast",
                "https://images.unsplash.com/photo-1567596275753-92607c3ce1ae?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzN3x8cG9kY2FzdHxlbnwxfHx8fDE2ODgwMjY2NDF8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
}
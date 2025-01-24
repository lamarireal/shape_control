package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.databinding.FragmentRetoMainBinding
import com.shackleton.shape.db.laravel.model.Reto
import com.squareup.picasso.Picasso

class RetoMainFragment : Fragment() {

    private var _binding: FragmentRetoMainBinding? = null

    private val binding get() = _binding!!
    private var currentPosition: Int = 0
    private var lista: List<Reto> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRetoMainBinding.inflate(inflater, container, false)
        lista = cargarLista()
        cargaIndex(currentPosition)
        binding.botonAceptarReto.setOnClickListener {
            if (currentPosition == 0) findNavController().navigate(RetoMainFragmentDirections.actionRetoMainFragmentToBibliotecaFragment2())
            else Toast.makeText(requireContext(),"Sección en proceso", Toast.LENGTH_SHORT).show()
        }
        binding.arrowBack.setOnClickListener {
            requireActivity().finish()
        }
        binding.arrowLeft.setOnClickListener {
            currentPosition = if (currentPosition > 0) currentPosition - 1 else lista.size - 1
            cargaIndex(currentPosition)
        }
        binding.arrowRight.setOnClickListener {
            currentPosition = if (currentPosition < lista.size - 1) currentPosition + 1 else 0
            cargaIndex(currentPosition)
        }
        return binding.root
    }

    private fun cargaIndex(pos: Int) {
        binding.tituloReto.text = lista[pos].title
        binding.objetivo.text = lista[pos].goal
        Picasso.get().load(lista[pos].url).into(binding.imagenReto)
        binding.beneficio1.text = lista[pos].benefit1
        binding.beneficio2.text = lista[pos].benefit2
        binding.beneficio3.text = lista[pos].benefit3
        binding.beneficio4.text = lista[pos].benefit4
        binding.duracion.text = lista[pos].duration
        binding.nombreCategoria.text = lista[pos].category
    }

    private fun cargarLista(): List<Reto> {
        return listOf(
            Reto(
                "Lee el resumen de un libro",
                "desarrollo personal",
                "https://images.unsplash.com/photo-1553729784-e91953dec042?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw1fHxyZWFkaW5nfGVufDF8fHx8MTY4NzI2MDUxMHww&ixlib=rb-4.0.3&q=80&w=1080&quot",
                "1 día",
                "Objetivo: establecer el hábito de lectura diario y adquirir nuevos conocimientos",
                "·Amplía tus conocimientos",
                "·Estimula tu creatividad",
                "Fomenta el hábito de la lectura",
                "Aprende conceptos nuevos"
            ),
            Reto(
                "Organiza tus documentos",
                "organización",
                "https://images.unsplash.com/photo-1584573062914-a1f7848470a2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxvcmdhbml6YXRpb258ZW58MXx8fHwxNjg3MjIwMDE5fDA&ixlib=rb-4.0.3&q=80&w=1080&quot",
                "1 día",
                "Objetivo: organizar y clasificar tus documentos digitales para mejorar la eficiencia y el acceso a la información en tu negocio",
                "·Ahorro de tiempo al acceder a tus documentos",
                "·Mayor productividad debido al fácil acceso",
                "·Seguridad de datos (respaldo de documentos)",
                "·Reducción del estrés (documentos accesibles)"
            ),
            Reto(
                "Crece tu red de contactos",
                "networking",
                "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzOHx8bmV0d29ya2luZ3xlbnwxfHx8fDE2ODcyNjA0MzZ8MA&ixlib=rb-4.0.3&q=80&w=1080&quot",
                "1 día",
                "Objetivo: enviar invitaciones de conexión a expertos, profesionales y posibles clientes, a través de LinkedIn para crecer tu red",
                "·Expande tu red de contactos",
                "·Aumenta la visibilidad de tu perfíl profesional",
                "·Genera nuevas oportunidades",
                "Aprende de otras personas"
            )
        )
    }

}
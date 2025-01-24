package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentInspirateNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.custom.adapter.SuccessAdapter
import com.shackleton.shape.databinding.FragmentSuccesCasesBinding
import com.shackleton.shape.db.laravel.model.Inspirate

class SuccesCasesFragment : Fragment() {

    private var _binding: FragmentSuccesCasesBinding? = null
    private val binding get() = _binding!!
    private var cargar: List<Inspirate> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargar = cargarList()

        binding.recyclerInspirate.adapter = SuccessAdapter(cargar, requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccesCasesBinding.inflate(inflater, container, false)


        return binding.root
    }

    private fun cargarList(): List<Inspirate> {
        return listOf(
            Inspirate(
                "¿Cómo nacio Stripe?",
                "Patrick y John Collison fundaron y vendieron su primera empresa antes de los 20. Crearon un software para facilitar la gestión de inventario en eBay, y ahora son los fundadores de Stripe, una empresa de software que revoluciona los pagos en línea.",
                "Ver caso de éxito",
                "https://images.unsplash.com/photo-1589561253898-768105ca91a8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyNnx8c3VjY2Vzc3xlbnwxfHx8fDE2ODc4NzcyNjZ8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Inspirate(
                "La primera mujer en fundar una empresa \"unicornio\" en la India",
                "Ankiti Bose, de 27 años y su camino para convertirse en la primera mujer fundadora de una empresa unicornio en India con su startup de moda Zilingo, valuada en casi 1.000 millones de dólares.",
                "Ver caso de éxito",
                "https://images.unsplash.com/photo-1484627147104-f5197bcd6651?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw4fHxzdWNjZXNzJTIwd29tYW58ZW58MXx8fHwxNjg3OTM2MjY3fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Inspirate(
                "Una startup creada para foodies",
                "El amor por la comida llevó a Joe y Vanessa Ariel a recaudar $130 millones para su startup Goldbelly: un servicio de entrega de alimentos a nivel nacional (Estados Unidos).",
                "Ver caso de éxito",
                "https://images.unsplash.com/photo-1600728619239-d2a73f7aa541?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw1fHxmb29kJTIwZGVsaXZlcnl8ZW58MXx8fHwxNjg3OTM2NzI3fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
}
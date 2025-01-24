package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.LienzosAdapter
import com.shackleton.shape.databinding.FragmentLienzosMainBinding
import com.shackleton.shape.db.laravel.model.Lienzos

class LienzosMainFragment : Fragment() {

    private var _binding: FragmentLienzosMainBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLienzosMainBinding.inflate(inflater, container, false)

        binding.recyclerLienzos.adapter = LienzosAdapter(cargarList())

        return binding.root
    }

    private fun cargarList(): List<Lienzos> {
        return listOf(
            Lienzos(
                getString(R.string.businessTitle),
                getString(R.string.businessDescription),
                getString(
                    R.string.businessButton
                ),
                "https://images.unsplash.com/photo-1598368195835-91e67f80c9d7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxfHxza2V0Y2glMjBwcm9qZWN0fGVufDF8fHx8MTY4MTczMTc1Ng&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Lienzos(
                getString(R.string.pitchTitle),
                getString(R.string.pitchDescription),
                getString(
                    R.string.pitchTitle
                ),
                "https://images.unsplash.com/photo-1532619187608-e5375cab36aa?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw1fHxza2V0Y2glMjBwcmVzZW50YXRpb258ZW58MXx8fHwxNjgxNzMxNjc5&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Lienzos(
                "Lienzo Validación ligera",
                "Comprende mejor a tus clientes al explorar sus necesidades, deseos, pensamientos y emociones.",
                "Lienzo Validación ligera",
                "https://images.unsplash.com/photo-1532619187608-e5375cab36aa?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw0fHxwZW9wbGUlMjBza2V0Y2h8ZW58MXx8fHwxNjg3NDE5MTk0fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Lienzos(
                getString(R.string.propuestaTitle),
                getString(R.string.propuestaDescription),
                getString(
                    R.string.propuestaButton
                ),
                "https://images.unsplash.com/photo-1532622785990-d2c36a76f5a6?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw4fHxza2V0Y2glMjBpZGVhfGVufDF8fHx8MTY4MTczMTY2Mg&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Lienzos(
                "Lienzo LEAN Project",
                "Herramienta visual para diseñar proyectos enfocados en la eficiencia y reducción de desperdicios.",
                getString(
                    R.string.propuestaButton
                ),
                "https://images.unsplash.com/photo-1586296835409-fe3fe6b35b56?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxfHxwcm90b3R5cGV8ZW58MXx8fHwxNjg3NDE5MTc3fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
        )
    }

}
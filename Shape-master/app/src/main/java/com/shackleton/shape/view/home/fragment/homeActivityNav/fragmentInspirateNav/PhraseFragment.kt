package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentInspirateNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.databinding.FragmentPhraseBinding
import com.squareup.picasso.Picasso

class PhraseFragment : Fragment() {

    private lateinit var binding : FragmentPhraseBinding
    private var cargar : List<PhraseClass> = listOf()
    private  var currentPosition : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhraseBinding.inflate(inflater, container, false)
        cargar=cargarList()

        change(currentPosition)
        binding.previous.setOnClickListener{
            currentPosition = if (currentPosition > 0) currentPosition - 1 else cargar.size - 1
            change(currentPosition)
        }
        binding.next.setOnClickListener{
            currentPosition = if (currentPosition < cargar.size - 1) currentPosition + 1 else 0
            change(currentPosition)
        }
        return binding.root
    }

    private fun change(pos : Int){
        binding.Autor.text = cargar[pos].autor
        binding.description.text = cargar[pos].descripcion
        Picasso.get().load(cargar[pos].url).into(binding.imagenReto)
    }


    private data class PhraseClass(var descripcion : String, var autor :String, var url : String)
    private fun cargarList(): List<PhraseClass> {
        return listOf(
            PhraseClass(
                "\"El estilo no es algo que se pueda comprar.\n Es algo que se debe poseer.\"",
                "- Giorgio Armani",
                "https://images.unsplash.com/photo-1605859465655-84c45e14a0af?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyfHxzdHlsZXxlbnwxfHx8fDE2ODc5Mzc5MjJ8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"Cuando algo es suficientemente importante, lo haces incluso si las probabilidades de éxito no están a tu favor.\"",
                "- Elon Musk",
                "https://images.unsplash.com/photo-1446776877081-d282a0f896e2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyNnx8c3BhY2V8ZW58MXx8fHwxNjg4MDI0NDEzfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"La pasión es la diferencia entre tener un trabajo y tener una carrera.\"",
                "- Gordon Ramsay",
                "https://images.unsplash.com/photo-1577106263724-2c8e03bfe9cf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzfHxjaGVmfGVufDF8fHx8MTY4ODAyOTAyNnww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"Soy no sólo un empresario, sino un visionario\".",
                "- Jay-Z",
                "https://images.unsplash.com/photo-1541788968749-7683d395688d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMXx8cmFwfGVufDF8fHx8MTY4ODAyOTEzNXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"La gente quiere algo real, algo fresco, algo con sustancia\".",
                "- Banksy",
                "https://images.unsplash.com/photo-1581394267679-42ecb02d9f0d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw2fHxiYW5rc3l8ZW58MXx8fHwxNjg4MDI5MjA1fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"No hay atajos en la vida, solo trabajo duro, perseverancia y pasión\".",
                "- Rafael Nadal",
                "https://images.unsplash.com/photo-1615117572888-49e8520c4d42?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxfHx0ZW5pc3xlbnwxfHx8fDE2ODgwMjkzNzF8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"El éxito no es para los que piensan que lo merecen, sino para los que se lo ganan\".",
                "- Amancio Ortega (fundador de Inditex)",
                "https://images.unsplash.com/photo-1490481651871-ab68de25d43d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw5fHxmYXNoaW9ufGVufDF8fHx8MTY4ODAxNjQwMXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"No debemos tener miedo de decir quiénes somos\".",
                "- Emma Watson",
                "https://images.unsplash.com/photo-1468818438311-4bab781ab9b8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxmcmVlZG9tfGVufDF8fHx8MTY4ODAyOTQ4M3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"Elige un problema que te apasione y resuélvelo de la mejor manera posible\".",
                "- Melanie Perkins (fundadora de Canva)",
                "https://images.unsplash.com/photo-1561070791-36c11767b26a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxM3x8ZGVzaWdufGVufDF8fHx8MTY4ODAyOTEzM3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            PhraseClass(
                "\"Nunca debemos tener miedo de levantar la voz por lo que creemos\".",
                "- Malala Yousafzai",
                "https://images.unsplash.com/photo-1505682614136-0a12f9f7beea?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw2fHx2b2ljZSUyMHdvbWFufGVufDF8fHx8MTY4ODAyOTYxNHww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"Haz lo que amas y el éxito seguirá\".",
                "- Oprah Winfrey",
                "https://images.unsplash.com/photo-1499209974431-9dddcece7f88?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyfHxzdWNjZXNzfGVufDF8fHx8MTY4ODM5NDkyM3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"La clave para el éxito, a menudo, es la confianza en uno mismo y la perseverancia\".",
                "- Arianna Huffington (co-fundadora de The Huffington Post)",
                "https://images.unsplash.com/photo-1502139214982-d0ad755818d8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMDV8fGNvbmZpZGVuY2V8ZW58MXx8fHwxNjg4Mzk0OTY5fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"Haz exactamente lo que quieras hacer, sé quien quieras ser\".",
                "- Billie Eilish",
                "https://images.unsplash.com/photo-1548438294-1ad5d5f4f063?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw5fHx2aXNpb258ZW58MXx8fHwxNjg4Mzk1MDEzfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"Nunca subestimes el poder de tus sueños y de influir en los demás\".",
                "- Michelle Obama",
                "https://images.unsplash.com/photo-1536602012356-86c345795580?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw5fHxkcmVhbXxlbnwxfHx8fDE2ODgzOTUwNDJ8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"No hay conflicto entre hacer un buen producto y hacer el bien\".",
                "- Joey Zwillinger (cofundador de Allbirds)",
                "https://images.unsplash.com/photo-1632948177278-5ab29b5b6e68?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMXx8ZG9pbmd8ZW58MXx8fHwxNjg4NTQ5MDU4fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"Si todos tomamos pequeñas acciones, podemos crear un gran cambio\".",
                "- Blake Mycoskie (fundador de Toms)",
                "https://images.unsplash.com/photo-1499244571948-7ccddb3583f1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxfHxjaGFuZ2V8ZW58MXx8fHwxNjg4NTQ5MDkwfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"El mejor negocio es hacer el bien para el planeta\".",
                "- Yvon Chouinard  (fundador de Patagonia)",
                "https://images.unsplash.com/photo-1490730141103-6cac27aaab94?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyM3x8ZG9pbmclMjBnb29kfGVufDF8fHx8MTY4ODU0OTI0M3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"La pasión y el propósito son la clave para construir un negocio que realmente importe\".",
                "- Rose Marcario (ex CEO de Patagonia)",
                "https://images.unsplash.com/photo-1421789665209-c9b2a435e3dc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMnx8ZWFydGh8ZW58MXx8fHwxNjg4NTQ5Mjk3fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"No subestimes el poder de una experiencia excepcional para el cliente\".",
                "- Emily Weiss (fundadora de Glossier)",
                "https://images.unsplash.com/photo-1556740738-b6a63e27c4df?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxjb3N0dW1lciUyMGV4cGVyaWVuY2V8ZW58MXx8fHwxNjg4NTQ5MzQzfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), PhraseClass(
                "\"Si crees en algo, lucha por ello. Tu voz puede marcar la diferencia\".",
                "- Anita Roddick (fundadora de The Body Shop)",
                "https://images.unsplash.com/photo-1468818438311-4bab781ab9b8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxmcmVlZG9tfGVufDF8fHx8MTY4ODAyOTQ4M3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
}
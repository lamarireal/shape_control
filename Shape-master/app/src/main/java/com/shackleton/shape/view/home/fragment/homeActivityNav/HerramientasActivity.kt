package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ActivityHerramientasBinding
import com.shackleton.shape.db.laravel.model.Herramientas
import com.squareup.picasso.Picasso


class HerramientasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHerramientasBinding

    private var adapterViewMain : View? = null
    private var adapterViewIA : View? = null
    private var adapterViewDesing : View? = null
    private var adapterViewSocialNetwork : View? =null
    private var adapterViewProto : View? = null
    private var adapterViewProject : View? = null
    private var cargar : List<Herramientas> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHerramientasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inflater = LayoutInflater.from(this)

        adapterViewMain = inflater.inflate(R.layout.img_container, binding.contenedor, false)
        val imagenRetoMain = adapterViewMain!!.findViewById<ShapeableImageView>(R.id.imagenRetoIMG)
        Picasso.get().load("https://images.unsplash.com/flagged/photo-1575227057258-50cb9bffb1af?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzNHx8d29ya2luZ3xlbnwxfHx8fDE2ODcxNjA5Nzh8MA&ixlib=rb-4.0.3&q=80&w=1080&quot").into(imagenRetoMain)
        binding.contenedor.addView(adapterViewMain)


        //Acciones de los botones

        binding.arrowBack.setOnClickListener {
            finish() // Cierra la actividad actual y vuelve a la anterior
        }




        binding.btnIA.setOnClickListener {
            removerVistas()

            cargar = cargarListIA()
            for ((index, item) in cargar.withIndex()) {
                adapterViewIA = inflater.inflate(R.layout.herramientas_adapter, binding.contenedor, false)

                val imagenReto = adapterViewIA!!.findViewById<ShapeableImageView>(R.id.imagenReto)
                val title = adapterViewIA!!.findViewById<TextView>(R.id.title)
                val description = adapterViewIA!!.findViewById<TextView>(R.id.description)
                val button = adapterViewIA!!.findViewById<Button>(R.id.button)

                Picasso.get().load(item.url).into(imagenReto)
                title.text = item.title
                description.text = item.description
                button.text = item.button

                val url = when (index) {
                    0 -> "https://chat.openai.com/"
                    1 -> "https://openai.com/dall-e/"
                    2 -> "https://www.beautiful.ai/"
                    3 -> "https://tome.app/"
                    4 -> "https://durable.co/"
                    5 -> "https://predis.ai/"
                    6 -> "https://doclime.com/"
                    7 -> "https://namelix.com/"
                    else -> "https://chat.openai.com/"
                }
                button.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                binding.contenedor.addView(adapterViewIA)
            }
        }

        binding.desing.setOnClickListener{
            removerVistas()

            cargar = cargarListDesing()

            for ((index, item) in cargar.withIndex()) {
                adapterViewDesing = inflater.inflate(R.layout.herramientas_adapter, binding.contenedor, false)

                val imagenReto = adapterViewDesing!!.findViewById<ShapeableImageView>(R.id.imagenReto)
                val title = adapterViewDesing!!.findViewById<TextView>(R.id.title)
                val description = adapterViewDesing!!.findViewById<TextView>(R.id.description)
                val button = adapterViewDesing!!.findViewById<Button>(R.id.button)

                Picasso.get().load(item.url).into(imagenReto)
                title.text = item.title
                description.text = item.description
                button.text = item.button

                val url = when (index) {
                    0 -> "https://www.canva.com/"
                    1 -> "https://designer.microsoft.com/"
                    2 -> "https://piktochart.com/"
                    3 -> "https://pixabay.com/"
                    4 -> "https://www.freepik.es/"
                    else -> "https://www.canva.com/"
                }
                button.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                binding.contenedor.addView(adapterViewDesing)
            }

        }
        binding.socialNetwork.setOnClickListener{
            removerVistas()

            cargar = cargarListSocialNetwork()
            for  ((index, item) in cargar.withIndex()){
                adapterViewSocialNetwork = inflater.inflate(R.layout.herramientas_adapter, binding.contenedor, false)

                val imagenReto = adapterViewSocialNetwork!!.findViewById<ShapeableImageView>(R.id.imagenReto)
                val title = adapterViewSocialNetwork!!.findViewById<TextView>(R.id.title)
                val description = adapterViewSocialNetwork!!.findViewById<TextView>(R.id.description)
                val button = adapterViewSocialNetwork!!.findViewById<Button>(R.id.button)

                Picasso.get().load(item.url).into(imagenReto)
                title.text = item.title
                description.text = item.description
                button.text = item.button

                val url = when (index) {
                    0 -> "https://www.hootsuite.com/es"
                    1 -> "https://later.com/"
                    2 -> "https://metricool.com/es/"
                    3 -> "https://keyhole.co/"
                    4 -> "https://www.agorapulse.com/es/"
                    else -> "https://www.agorapulse.com/es/"
                }
                button.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                binding.contenedor.addView(adapterViewSocialNetwork)
            }

        }
        binding.proto.setOnClickListener{
            removerVistas()
            cargar = cargarListProto()

            for ((index, item) in cargar.withIndex()) {
                adapterViewProto = inflater.inflate(R.layout.herramientas_adapter, binding.contenedor, false)

                val imagenReto = adapterViewProto!!.findViewById<ShapeableImageView>(R.id.imagenReto)
                val title = adapterViewProto!!.findViewById<TextView>(R.id.title)
                val description = adapterViewProto!!.findViewById<TextView>(R.id.description)
                val button = adapterViewProto!!.findViewById<Button>(R.id.button)

                Picasso.get().load(item.url).into(imagenReto)
                title.text = item.title
                description.text = item.description
                button.text = item.button

                val url = when (index) {
                    0 -> "https://uizard.io/"
                    1 -> "https://8b.com/"
                    2 -> "https://www.shopify.com/es"
                    3 -> "https://www.figma.com/"
                    4 -> "https://proto.io/"
                    else -> "https://proto.io/"
                }
                button.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                binding.contenedor.addView(adapterViewProto)
            }

        }
        binding.project.setOnClickListener{
            removerVistas()

            cargar = cargarListProject()
            for ((index, item) in cargar.withIndex()) {
                adapterViewProject = inflater.inflate(R.layout.herramientas_adapter, binding.contenedor, false)

                val imagenReto = adapterViewProject!!.findViewById<ShapeableImageView>(R.id.imagenReto)
                val title = adapterViewProject!!.findViewById<TextView>(R.id.title)
                val description = adapterViewProject!!.findViewById<TextView>(R.id.description)
                val button = adapterViewProject!!.findViewById<Button>(R.id.button)

                Picasso.get().load(item.url).into(imagenReto)
                title.text = item.title
                description.text = item.description
                button.text = item.button

                val url = when (index) {
                    0 -> "https://slack.com/intl/es-es"
                    1 -> "https://trello.com/"
                    2 -> "https://asana.com/es?noredirect="
                    3 -> "https://monday.com/lang/es"
                    4 -> "https://www.wrike.com/es/"
                    else -> "https://www.wrike.com/es/"
                }
                button.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                binding.contenedor.addView(adapterViewProject!!)
            }
        }

    }

    private fun removerVistas(){
        adapterViewMain?.let { binding.contenedor.removeAllViews() }
        adapterViewIA?.let { binding.contenedor.removeAllViews() }
        adapterViewDesing?.let { binding.contenedor.removeAllViews() }
        adapterViewProto?.let { binding.contenedor.removeAllViews() }
        adapterViewProject?.let { binding.contenedor.removeAllViews() }
        adapterViewSocialNetwork?.let { binding.contenedor.removeAllViews() }
    }
    private fun cargarListIA(): List<Herramientas> {
        return listOf(
            Herramientas(
                getString(R.string.chatgptTitle),
                getString(R.string.chatgptDescription),
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1526378722484-bd91ca387e72?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxMXx8aW50ZWxpZ2VuY2lhJTIwYXJ0aWZpY2lhbHxlbnwxfHx8fDE2ODA2MDY5MzM&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Herramientas(
                getString(R.string.dalleTitle),
                getString(R.string.dalleDescription),
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1562575214-da9fcf59b907?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwyMnx8Z3JhcGhpY3xlbnwxfHx8fDE2ODA1NTQ3NzM&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Herramientas(
                getString(R.string.beautifulaiTitle),
                getString(R.string.beautifulaiDescription),
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1560439514-0fc9d2cd5e1b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw4fHxzbGlkZXN8ZW58MXx8fHwxNjgwNjA3MDk1&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Herramientas(
                "TomeApp",
                getString(R.string.chatgptDescription),
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1590103514924-009a76183beb?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxNTV8fHByZXNlbnRhdGlvbiUyMGRlc2lnbnxlbnwxfHx8fDE2ODcxNjYxNjl8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Durable AI",
                "Genera un sitio web en segundos",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1461749280684-dccba630e2f6?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw1fHx3ZWJzaXRlfGVufDF8fHx8MTY4NzE2NjcxMXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Namelix",
                "Proporciona ideas de nombre para tu negocio",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1520453803296-c39eabe2dab4?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw4fHxuYW1lfGVufDF8fHx8MTY4NzE2NjcyMXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Predis AI",
                "Genera contenidos para tus redes sociales",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyfHxzb2NpYWwlMjBtZWRpYXxlbnwxfHx8fDE2ODcxNjY4MzN8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Doclime",
                "Obtén respuestas a preguntas sobre tus PDFs",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1557318041-1ce374d55ebf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyfHxxdWVzdGlvbnxlbnwxfHx8fDE2ODcxMTI1MjF8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
    private fun cargarListDesing(): List<Herramientas> {
        return listOf(
            Herramientas(
                "Canva",
                "Esta herramienta te ayudará a crear diseños personalizados",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1475669698648-2f144fcaaeb1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxkZXNpZ258ZW58MXx8fHwxNjg3MjU4ODM1fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Microsoft Designer",
                "De texto a imagen con inteligencia artificial",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1476357471311-43c0db9fb2b4?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyMXx8ZGVzaWdufGVufDF8fHx8MTY4NzI1ODgzNXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Piktochart",
                "Ideal para crear fotografías e informar sobre datos",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1618788372246-79faff0c3742?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw1MHx8ZGVzaWdufGVufDF8fHx8MTY4NzI1ODg1M3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Pixabay",
                "Encuentra fotografías de stock para usar en tus diseños",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1506097425191-7ad538b29cef?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzM3x8ZGVzaWdufGVufDF8fHx8MTY4NzI1ODg1M3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Freepik",
                "Encuentra recursos gráficos como fotografías y vectores",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1581291518633-83b4ebd1d83e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3Mnx8ZGVzaWdufGVufDF8fHx8MTY4NzI1ODg2OXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )

        )
    }
    private fun cargarListSocialNetwork(): List<Herramientas> {
        return listOf(
            Herramientas(
                "Hootsuite",
                "Esta herramienta te ayudará a gestionar tus redes sociales",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1622782914767-404fb9ab3f57?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwzM3x8c29jaWFsJTIwbWVkaWF8ZW58MXx8fHwxNjg3MjU4NjI3fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Later",
                "Esta herramienta te permite programar contenido en redes sociales",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1547032175-7fc8c7bd15b3?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxOXx8c29jaWFsJTIwbWVkaWF8ZW58MXx8fHwxNjg3MjU4NTkxfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Metricool",
                "Obtén métricas relevantes sobre tus redes sociales",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1533022422823-39f3ad778be4?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHxjZWxscGhvbmV8ZW58MXx8fHwxNjg3MjU4NjY1fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "Keyhole",
                "Programa, publica y optimiza todas tus publicaciones",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1621184078903-6bfe9482d935?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMDF8fHNvY2lhbCUyMG1lZGlhfGVufDF8fHx8MTY4NzI1ODY5N3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ), Herramientas(
                "AgoraPulse",
                "Herramienta útil para la gestión simplificada de tus redes",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1526854497059-89ac894e3168?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3OHx8Y2VsbHBob25lfGVufDF8fHx8MTY4NzI1ODcyM3ww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
    private fun cargarListProto(): List<Herramientas> {
        return listOf(
            Herramientas(
                "Uizard",
                "Crea prototipos de tus aplicaciones",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1586296835409-fe3fe6b35b56?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxfHxwcm90b3R5cGV8ZW58MXx8fHwxNjg3MjYyMzQyfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "8b",
                "Crea páginas web con diferentes plantillas",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1547658719-da2b51169166?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw3fHx3ZWIlMjBkZXNpZ258ZW58MXx8fHwxNjg3MjYyMzEzfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Shopify",
                "Crea tu tienda en línea con plantillas prediseñadas",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1472851294608-062f824d29cc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxMHx8b25saW5lJTIwc2hvcHxlbnwxfHx8fDE2ODcyNjI1Njl8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Figma",
                "Herramienta para generación de prototipos",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1492551557933-34265f7af79e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxOXx8cHJvdG90eXBlfGVufDF8fHx8MTY4NzI2MjM0Mnww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Proto",
                "Trae tu idea a la vida con esta herramienta de prototipado",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1600132806370-bf17e65e942f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw4fHxwcm90b3R5cGV8ZW58MXx8fHwxNjg3MjYyMzQyfDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            )
        )
    }
    private fun cargarListProject(): List<Herramientas> {
        return listOf(
            Herramientas(
                "Slack",
                "Esta herramienta te ayudará a enviar mensajes a tu equipo",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1508685096489-7aacd43bd3b1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw5fHxub3RpZmljYXRpb258ZW58MXx8fHwxNjg3MjUyODQ5fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Trello",
                "Esta herramienta te ayudará a enviar mensajes a tu equipo",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1523289333742-be1143f6b766?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxM3x8cHJvamVjdCUyMG1hbmFnZW1lbnR8ZW58MXx8fHwxNjg3MjYzMDU5fDA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Asana",
                "Crea prototipos de tus aplicaciones",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1506784365847-bbad939e9335?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwyfHxjYWxlbmRhcnxlbnwxfHx8fDE2ODcyNjMyMjN8MA&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Monday",
                "Crea prototipos de tus aplicaciones",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1568219557405-376e23e4f7cf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHwxNXx8cG9zdCUyMGl0fGVufDF8fHx8MTY4NzI2MzI1MXww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
            Herramientas(
                "Wrike",
                "Crea prototipos de tus aplicaciones",
                getString(R.string.botonHerramientas),
                "https://images.unsplash.com/photo-1520971081497-3aa1750677b8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wyMDUzMDJ8MHwxfHNlYXJjaHw2MXx8cG9zdCUyMGl0fGVufDF8fHx8MTY4NzI2MzI3NHww&ixlib=rb-4.0.3&q=80&w=1080&quot"
            ),
        )
    }
}
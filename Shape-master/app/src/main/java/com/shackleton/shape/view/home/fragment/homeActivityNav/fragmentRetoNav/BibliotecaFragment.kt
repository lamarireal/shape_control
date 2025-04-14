package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentRetoNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.BibliotecaAdapter
import com.shackleton.shape.databinding.FragmentBibliotecaBinding
import com.shackleton.shape.db.laravel.model.Biblioteca

class BibliotecaFragment : Fragment() , BibliotecaAdapter.OnItemClickListener {

    private lateinit var binding: FragmentBibliotecaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBibliotecaBinding.inflate(inflater, container, false)
        val cargar = cargarList()

        binding.recyclerBiblioteca.adapter = BibliotecaAdapter(cargar, listener = this)


        //Nota de Pedro:El onclickListener no funcionaba porque no estaba dentro del view.
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }



        return binding.root
    }

    override fun onItemClick(biblioteca: Biblioteca) {

        findNavController().navigate(BibliotecaFragmentDirections.actionBibliotecaFragment2ToLibrosFragment(resumen = arrayOf(biblioteca.title,biblioteca.resumen,biblioteca.url)))

    }


    private fun cargarList(): List<Biblioteca> {
        return listOf(
            Biblioteca(
                getString(R.string.leanTitle),
                getString(R.string.leanDescription),
                "https://images.unsplash.com/photo-1553484771-371a605b060b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw0fHxsZWFuJTIwc3RhcnR1cHxlbnwxfHx8fDE2Nzg3OTU2NTY&ixlib=rb-4.0.3&q=80&w=1080",
                "The Lean Startup\" de Eric Ries es un libro revolucionario que ofrece una metodología para el desarrollo de productos y la gestión de empresas de manera ágil y eficiente. Ries presenta el concepto de \"lean startup\", que se basa en principios de emprendimiento que priorizan la iteración rápida, la validación de ideas a través de experimentos y la maximización del aprendizaje validado. En lugar de seguir un plan de negocio tradicional, las startups deben adoptar un enfoque flexible y adaptable que les permita ajustarse rápidamente a las necesidades del mercado.\n" +
                        "\n" +
                        "El libro destaca la importancia de crear un producto mínimo viable (MVP), que es la versión más básica de un producto que permite recopilar retroalimentación y aprender de los usuarios. Ries enfatiza la necesidad de medir métricas clave, como el crecimiento del usuario, el tiempo de ciclo y el flujo de caja, para evaluar el progreso de la startup de manera objetiva.\n" +
                        "\n" +
                        "\"The Lean Startup\" también explora conceptos como la validación de hipótesis, el desarrollo continuo y la innovación a través de la experimentación. Ries argumenta que las empresas deben adoptar una mentalidad de aprendizaje constante y estar dispuestas a pivotar o cambiar de dirección si los datos indican que es necesario.\n" +
                        "\n" +
                        "En resumen, \"The Lean Startup\" proporciona un marco práctico y basado en evidencia para emprendedores y líderes empresariales que desean construir productos exitosos y empresas sostenibles en un entorno altamente competitivo y cambiante."
            ),
            Biblioteca(
                getString(R.string.habitosTitle),
                getString(R.string.habitosDescription),
                "https://images.unsplash.com/photo-1543002588-bfa74002ed7e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxfHxib29rfGVufDF8fHx8MTY3ODc5NjExMA&ixlib=rb-4.0.3&q=80&w=1080",
                "Los 7 hábitos de la gente altamente efectiva\" de Stephen R. Covey es un libro de desarrollo personal y liderazgo que ofrece un enfoque holístico para alcanzar el éxito y la efectividad en la vida personal y profesional. Covey presenta siete hábitos fundamentales que pueden transformar la forma en que las personas piensan, actúan y se relacionan con los demás.\n" +
                        "\n" +
                        "Los siete hábitos son:\n" +
                        "\n" +
                        "Ser proactivo: Este primer hábito se centra en asumir la responsabilidad de nuestras propias acciones y decisiones. Covey argumenta que las personas efectivas no se dejan llevar por las circunstancias externas, sino que eligen cómo responder ante ellas.\n" +
                        "\n" +
                        "Comenzar con un fin en mente: Covey enfatiza la importancia de tener una visión clara de nuestros objetivos y valores en la vida. Este hábito nos ayuda a establecer metas significativas y a alinear nuestras acciones con nuestros valores más profundos.\n" +
                        "\n" +
                        "Poner primero lo primero: El tercer hábito se refiere a la gestión del tiempo y la priorización de las actividades basadas en su importancia relativa. Covey introduce el concepto de administración del tiempo centrada en los principios, que implica enfocarse en actividades importantes en lugar de simplemente ocuparse de tareas urgentes.\n" +
                        "\n" +
                        "Pensar en ganar-ganar: Covey promueve una mentalidad de abundancia en la que buscamos soluciones que beneficien a todas las partes involucradas. Este hábito se basa en la creencia de que el éxito no debe lograrse a expensas de los demás, sino que puede ser compartido y multiplicado.\n" +
                        "\n" +
                        "Buscar primero entender, luego ser entendido: Covey enfatiza la importancia de la empatía y la escucha activa en las relaciones interpersonales. Este hábito nos anima a comprender profundamente a los demás antes de intentar hacernos entender.\n" +
                        "\n" +
                        "Sinergizar: El sexto hábito se refiere a la creación de relaciones basadas en la confianza y el respeto mutuo, donde las partes colaboran de manera creativa para alcanzar resultados que no podrían lograr por sí solas.\n" +
                        "\n" +
                        "Afilar la sierra: Covey presenta este último hábito como la necesidad de renovarnos física, mental, emocional y espiritualmente de manera regular. Este hábito nos permite mantenernos equilibrados y enfocados en nuestras metas a largo plazo.\n" +
                        "\n" +
                        "En resumen, \"Los 7 hábitos de la gente altamente efectiva\" ofrece un marco integral para el crecimiento personal y profesional, que puede ayudar a las personas a alcanzar su máximo potencial y vivir una vida más plena y satisfactoria."
            ),
            Biblioteca(
                getString(R.string.eMythTitle),
                getString(R.string.eMythDescription),
                "https://images.unsplash.com/photo-1532012197267-da84d127e765?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2fHxib29rfGVufDF8fHx8MTY3ODc5NjExMA&ixlib=rb-4.0.3&q=80&w=1080",
                "The E-Myth Revisited\" de Michael E. Gerber es un libro que aborda la realidad del emprendimiento y cómo crear un negocio exitoso. Gerber presenta la \"E-Myth\", o mito del emprendedor, que sostiene que la mayoría de las personas que inician un negocio lo hacen bajo la falsa premisa de que son buenos técnicos en su campo, pero no necesariamente buenos empresarios.\n" +
                        "\n" +
                        "El autor argumenta que muchos emprendedores caen en la trampa de trabajar en sus negocios en lugar de trabajar en sus negocios, lo que lleva a la falta de crecimiento, la sobrecarga de trabajo y la insatisfacción laboral. Propone un enfoque diferente: trabajar \"en\" el negocio como un empresario, no \"en\" el negocio como un técnico.\n" +
                        "\n" +
                        "Gerber presenta tres roles fundamentales en cualquier negocio:\n" +
                        "\n" +
                        "El técnico: aquel que realiza el trabajo principal del negocio.\n" +
                        "El gerente: responsable de la planificación, la organización y el control.\n" +
                        "El emprendedor: el visionario que ve el panorama general y busca oportunidades de crecimiento.\n" +
                        "El autor argumenta que los emprendedores exitosos deben adoptar estos tres roles y crear sistemas y procesos que permitan que el negocio funcione de manera eficiente y predecible sin depender exclusivamente de su presencia.\n" +
                        "\n" +
                        "Además, Gerber enfatiza la importancia de crear un negocio que funcione como un franquicia, es decir, documentando cada aspecto del negocio y creando sistemas replicables que permitan el crecimiento y la expansión.\n" +
                        "\n" +
                        "En resumen, \"The E-Myth Revisited\" ofrece una perspectiva fresca sobre el emprendimiento y proporciona consejos prácticos para crear un negocio exitoso que funcione de manera eficiente y pueda crecer sin depender únicamente del emprendedor.\n" +
                        "\n"
            ),
            Biblioteca(
                getString(R.string.zeroTitle),
                getString(R.string.zeroDescription),
                "https://images.unsplash.com/photo-1512820790803-83ca734da794?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxMnx8Ym9va3xlbnwxfHx8fDE2Nzg3OTYxMTA&ixlib=rb-4.0.3&q=80&w=1080",
                "Zero to One\" de Peter Thiel y Blake Masters es un libro que ofrece una visión única sobre el emprendimiento y la innovación. Thiel, cofundador de PayPal y uno de los inversores más influyentes del mundo, comparte sus ideas sobre cómo construir negocios que pasen de la nada a convertirse en monopolios exitosos.\n" +
                        "\n" +
                        "El libro se centra en la importancia de la innovación radical y la creación de productos y servicios que sean únicos en su tipo, pasando de \"cero a uno\" en lugar de simplemente mejorar lo que ya existe (de \"uno a n\"). Thiel argumenta que las empresas exitosas no compiten en un mercado existente, sino que crean su propio mercado y dominan en él.\n" +
                        "\n" +
                        "Una de las ideas centrales del libro es la importancia de la tecnología y la innovación en la creación de valor. Thiel sostiene que las empresas deben enfocarse en desarrollar tecnologías disruptivas que resuelvan problemas importantes y creen un cambio significativo en el mundo.\n" +
                        "\n" +
                        "Además, Thiel ofrece consejos prácticos para los emprendedores, incluida la importancia de tener una visión clara y audaz, la construcción de equipos talentosos y la creación de una cultura empresarial única.\n" +
                        "\n" +
                        "En resumen, \"Zero to One\" es un libro provocador que desafía las convenciones del pensamiento empresarial tradicional y ofrece ideas valiosas para aquellos que buscan crear empresas que cambien el juego y tengan un impacto duradero en el mundo."
            ),
            Biblioteca(
                getString(R.string.goodTitle),
                getString(R.string.goodDescription),
                "https://images.unsplash.com/photo-1495446815901-a7297e633e8d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzMHx8Ym9va3xlbnwxfHx8fDE2Nzg3OTYxMTA&ixlib=rb-4.0.3&q=80&w=1080",
                "Good to Great\" de Jim Collins es un libro que explora por qué algunas empresas logran hacer la transición de ser buenas a ser verdaderamente excelentes, mientras que otras se quedan estancadas en la mediocridad. Collins y su equipo de investigación estudiaron a empresas que lograron un rendimiento financiero excepcional durante un período de 15 años y compararon sus características con las de empresas similares que no lograron el mismo nivel de éxito.\n" +
                        "\n" +
                        "El libro identifica varios conceptos clave que distinguen a las empresas \"excelentes\" de las \"buenas\". Estos incluyen tener un liderazgo excepcional, una cultura organizacional sólida, un enfoque implacable en lo que la empresa puede ser la mejor del mundo en hacer (su \"punto de inflamación\"), una disciplina empresarial consistente y una capacidad para enfrentar la realidad de manera honesta y sin rodeos.\n" +
                        "\n" +
                        "Una de las ideas más importantes del libro es el concepto de \"niveles 5 de liderazgo\", que describe el tipo de líderes que están detrás de las empresas que pasan de ser buenas a ser excelentes. Estos líderes combinan humildad personal con una determinación feroz para que la empresa tenga éxito, y a menudo se centran más en el éxito de la empresa que en su propia gloria personal.\n" +
                        "\n" +
                        "En resumen, \"Good to Great\" ofrece una visión profunda y perspicaz sobre lo que se necesita para llevar una empresa de la mediocridad a la grandeza y proporciona ideas prácticas que los líderes pueden aplicar para mejorar el rendimiento de sus organizaciones."
            ),
            Biblioteca(
                getString(R.string.hourTitle),
                getString(R.string.hourDescription),
                "https://images.unsplash.com/photo-1481627834876-b7833e8f5570?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw4fHxib29rfGVufDF8fHx8MTY3ODc5NjExMA&ixlib=rb-4.0.3&q=80&w=1080",
                "The 4-Hour Workweek\" de Timothy Ferriss es un libro que desafía las convenciones tradicionales sobre el trabajo y propone un enfoque radicalmente diferente para vivir una vida plena y productiva. Ferriss comparte sus experiencias personales y estrategias para escapar de la rutina del trabajo convencional de 9 a 5 y crear un estilo de vida que permita trabajar menos y vivir más.\n" +
                        "\n" +
                        "El libro se centra en varios conceptos clave, como la externalización de tareas, la automatización de procesos, la eliminación del trabajo no esencial y la maximización de la eficiencia en el tiempo y los recursos. Ferriss argumenta que muchas personas caen en la trampa de vivir para trabajar en lugar de trabajar para vivir, y propone un enfoque de \"mini-retiro\" donde se disfruta de la vida ahora en lugar de esperar hasta la jubilación.\n" +
                        "\n" +
                        "Ferriss también aborda la importancia de la movilidad y la capacidad para trabajar desde cualquier lugar del mundo, aprovechando la tecnología y los recursos disponibles en la era digital. Además, ofrece consejos prácticos sobre cómo establecer y alcanzar objetivos, gestionar el tiempo de manera efectiva y liberarse de la mentalidad de \"trabajo duro\" para adoptar una mentalidad de eficiencia y efectividad.\n" +
                        "\n" +
                        "En resumen, \"The 4-Hour Workweek\" es una guía inspiradora para aquellos que desean escapar de la trampa del trabajo convencional y diseñar un estilo de vida que les permita trabajar menos, ganar más y disfrutar de la verdadera libertad y felicidad."
            ),
            Biblioteca(
                getString(R.string.thinkTitle),
                getString(R.string.thinkDescription),
                "https://images.unsplash.com/photo-1553484771-371a605b060b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw0fHxsZWFuJTIwc3RhcnR1cHxlbnwxfHx8fDE2Nzg3OTU2NTY&ixlib=rb-4.0.3&q=80&w=1080",
                "Think and Grow Rich\" de Napoleon Hill es un clásico de autoayuda que ha inspirado a millones de personas en todo el mundo a alcanzar el éxito y la riqueza. El libro se basa en los principios de la ley de atracción y la mentalidad positiva, argumentando que la verdadera riqueza comienza con la mente y la actitud correctas.\n" +
                        "\n" +
                        "Hill entrevistó a más de quinientas personas exitosas, incluidos empresarios, líderes políticos y figuras prominentes de su época, para identificar los principios comunes que los llevaron al éxito. Estos principios incluyen la fijación de metas claras y definidas, la persistencia, la fe en uno mismo, la autosugestión, el pensamiento creativo y la colaboración con otros.\n" +
                        "\n" +
                        "El libro presenta una serie de pasos prácticos y ejercicios que los lectores pueden seguir para desarrollar y aplicar estos principios en sus propias vidas. Hill enfatiza la importancia de tener un propósito claro y una visión clara de lo que se quiere lograr, así como la necesidad de mantener una actitud positiva y optimista incluso en tiempos difíciles.\n" +
                        "\n" +
                        "En resumen, \"Think and Grow Rich\" es una guía poderosa para el éxito que enseña a los lectores a cultivar una mentalidad de abundancia y a aplicar principios probados para alcanzar sus objetivos financieros y personales."
            )
        )
    }
}
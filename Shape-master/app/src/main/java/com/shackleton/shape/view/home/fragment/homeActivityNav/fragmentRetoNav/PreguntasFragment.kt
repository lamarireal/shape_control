package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentRetoNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.PreguntasAdapter
import com.shackleton.shape.databinding.FragmentPreguntasBinding
import com.squareup.picasso.Picasso

class PreguntasFragment : Fragment() {

    private val args: PreguntasFragmentArgs by navArgs()

    private var _binding: FragmentPreguntasBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titulo = args.title[0]
        val url = args.title[1]

        Picasso.get().load(url).into(binding.imagenReto)

        if (titulo == getString(R.string.leanTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(binding.root,theLeanStartup(), 1,context)
        } else if (titulo == getString(R.string.habitosTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                theSevenHabits(),
                2,
                context
            )
        } else if (titulo == getString(R.string.eMythTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                theEMythRevisited(),
                3,
                context
            )
        } else if (titulo == getString(R.string.zeroTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                zeroToOne(),
                4,
                context
            )
        } else if (titulo == getString(R.string.goodTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                goodToGreat(),
                5,
                context
            )
        } else if (titulo == getString(R.string.hourTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                fourHourWorkWeek(),
                6,
                context
            )
        } else if (titulo == getString(R.string.thinkTitle)) {
            binding.recyclerPreguntas.adapter = PreguntasAdapter(
                binding.root,
                thinkAndGrowRich(),
                7,
                context
            )
        }


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPreguntasBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    data class PreguntaClass(
        val pregunta: String,
        val respuesta1: String,
        val respuesta2: String,
        val respuesta3: String,
        var respuestaSeleccionada: String,
        var respuestaCorrecta:String,
        var mostrarResultado:Boolean=false
    )

    private fun theLeanStartup(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(

                "¿Qué es el enfoque Lean Startup y cuáles son sus principios fundamentales?",
                "El enfoque Lean Startup se centra en la iteración rápida, la validación del cliente y el aprendizaje validado. Sus principios fundamentales incluyen la construcción de un MVP, la medición del progreso con métricas relevantes y el aprendizaje continuo a través de experimentos.",
                "El enfoque Lean Startup busca minimizar el desperdicio de recursos al evitar la construcción de productos completos antes de validar su viabilidad en el mercado.",
                "Los principios del Lean Startup pueden aplicarse tanto a startups como a grandes empresas para mejorar la eficiencia y la efectividad en el desarrollo de productos y servicios.",
                "",
                "Los principios del Lean Startup pueden aplicarse tanto a startups como a grandes empresas para mejorar la eficiencia y la efectividad en el desarrollo de productos y servicios."
            ),
            PreguntaClass(
                "¿Cuál es el papel de los MVPs (Producto Mínimo Viable) en el proceso Lean Startup?",
                "Los MVPs son versiones simplificadas de un producto que permiten a las empresas obtener retroalimentación del mercado con el mínimo esfuerzo.",
                "Al construir y lanzar un MVP rápidamente, las empresas pueden validar hipótesis y aprender de la respuesta del cliente de manera rápida y económica.",
                "Los MVPs permiten a las empresas evitar la sobreinversión en productos que pueden no tener demanda o que necesiten ajustes significativos.",
                "",
                "Al construir y lanzar un MVP rápidamente, las empresas pueden validar hipótesis y aprender de la respuesta del cliente de manera rápida y económica."
            ),
            PreguntaClass(
                "¿Cómo fomenta el Lean Startup la experimentación y el aprendizaje continuo?",
                "El Lean Startup promueve un enfoque de experimentación constante, donde las empresas prueban ideas, recopilan datos y ajustan su enfoque en función de los resultados.",
                "Al aprender de cada iteración, las empresas pueden adaptarse rápidamente a los cambios en el mercado y mejorar la probabilidad de éxito de sus productos y servicios.",
                "La mentalidad de aprendizaje continuo es fundamental en el Lean Startup, ya que permite a las empresas innovar de manera efectiva y mantenerse ágiles en un entorno empresarial dinámico.",
                "",
                "Al aprender de cada iteración, las empresas pueden adaptarse rápidamente a los cambios en el mercado y mejorar la probabilidad de éxito de sus productos y servicios."
            ),
            PreguntaClass(
                "¿Cuáles son los desafíos más comunes que enfrentan las startups y cómo aborda el Lean Startup esos desafíos?",
                "Algunos desafíos comunes incluyen la falta de claridad sobre las necesidades del cliente, la incertidumbre sobre el mercado y la presión para escalar rápidamente.",
                "El Lean Startup aborda estos desafíos al fomentar la experimentación, la validación temprana y la adaptación continua en respuesta a la retroalimentación del cliente.",
                "Al adoptar un enfoque ágil y centrado en el cliente, las startups pueden minimizar el riesgo y maximizar las oportunidades de éxito en un mercado competitivo.",
                "",
                "El Lean Startup aborda estos desafíos al fomentar la experimentación, la validación temprana y la adaptación continua en respuesta a la retroalimentación del cliente."
            ),
            PreguntaClass(
                "¿Cuáles son los consejos clave de Eric Ries para implementar con éxito los principios del Lean Startup?",
                "Eric Ries enfatiza la importancia de la medición del progreso, la experimentación rápida y la capacidad de adaptación en su enfoque Lean Startup.",
                "Recomienda a las empresas que se enfoquen en aprender del mercado y ajustar su enfoque en función de los datos recopilados durante el proceso de desarrollo.",
                "También insta a las empresas a adoptar una mentalidad de 'pivote' cuando sea necesario y a mantener un enfoque constante en la creación de valor para el cliente.",
                "",
                "Eric Ries enfatiza la importancia de la medición del progreso, la experimentación rápida y la capacidad de adaptación en su enfoque Lean Startup."
            )
        )
    }


    private fun theSevenHabits(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuáles son los 7 hábitos de la gente altamente efectiva según Stephen R. Covey?",
                "Los 7 hábitos incluyen: ser proactivo, comenzar con un fin en mente, poner primero lo primero, pensar en ganar/ganar, buscar primero entender y luego ser entendido, sinergizar y afilar la sierra.",
                "Estos hábitos se basan en principios universales que promueven el crecimiento personal y la efectividad en todos los aspectos de la vida.",
                "Covey sostiene que al adoptar estos hábitos, las personas pueden alcanzar un mayor nivel de éxito y satisfacción en su vida personal y profesional.",
                "",
                "Estos hábitos se basan en principios universales que promueven el crecimiento personal y la efectividad en todos los aspectos de la vida."
            ),
            PreguntaClass(
                "¿Cuál es la importancia del hábito de ser proactivo?",
                "El hábito de ser proactivo se centra en asumir la responsabilidad de nuestras acciones y elecciones, en lugar de ser víctimas de las circunstancias.",
                "Al ser proactivos, podemos tomar el control de nuestras vidas y dirigirlas hacia nuestros objetivos y valores más importantes.",
                "Este hábito nos ayuda a desarrollar la autoconciencia, la autodisciplina y la capacidad de responder de manera efectiva a los desafíos y oportunidades que enfrentamos.",
                "",
                "Al ser proactivos, podemos tomar el control de nuestras vidas y dirigirlas hacia nuestros objetivos y valores más importantes."
            ),
            PreguntaClass(
                "¿Por qué es importante comenzar con un fin en mente?",
                "Comenzar con un fin en mente significa tener una visión clara de nuestros objetivos y valores fundamentales antes de tomar decisiones y tomar medidas.",
                "Este hábito nos ayuda a establecer metas significativas y a alinear nuestras acciones con nuestros valores más profundos.",
                "Al empezar con un fin en mente, podemos priorizar nuestras actividades y dirigir nuestra energía hacia lo que es verdaderamente importante para nosotros a largo plazo.",
                "",
                "Al empezar con un fin en mente, podemos priorizar nuestras actividades y dirigir nuestra energía hacia lo que es verdaderamente importante para nosotros a largo plazo."
            ),
            PreguntaClass(
                "¿Cuál es la diferencia entre los hábitos de la efectividad y los hábitos de la eficiencia?",
                "Los hábitos de la efectividad se centran en hacer las cosas correctas, mientras que los hábitos de la eficiencia se centran en hacer las cosas de la manera más rápida y económica posible.",
                "Covey argumenta que es más importante enfocarse en la efectividad, ya que hacer las cosas correctas es fundamental para lograr resultados significativos a largo plazo.",
                "Aunque la eficiencia puede ser importante, no debe sacrificarse la efectividad en su nombre, ya que hacer las cosas de manera eficiente pero incorrecta no produce resultados satisfactorios.",
                "",
                "Aunque la eficiencia puede ser importante, no debe sacrificarse la efectividad en su nombre, ya que hacer las cosas de manera eficiente pero incorrecta no produce resultados satisfactorios."
            ),
            PreguntaClass(
                "¿Cuál es el concepto de 'afilar la sierra' y por qué es importante?",
                "Afilar la sierra se refiere al hábito de renovar y mejorar constantemente nuestras habilidades, nuestra salud física y emocional, y nuestras relaciones personales.",
                "Este hábito es esencial para mantener un alto nivel de efectividad a largo plazo, ya que nos permite recargar nuestras energías y mejorar nuestras capacidades.",
                "Covey argumenta que dedicar tiempo a afilar la sierra nos ayuda a mantener un equilibrio saludable entre trabajo y vida personal, lo que a su vez nos hace más efectivos en todas las áreas de nuestra vida.",
                "",
                "Covey argumenta que dedicar tiempo a afilar la sierra nos ayuda a mantener un equilibrio saludable entre trabajo y vida personal, lo que a su vez nos hace más efectivos en todas las áreas de nuestra vida."
            )
        )
    }


    private fun theEMythRevisited(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuál es el concepto central del libro 'The E-Myth Revisited'?",
                "El concepto central es el 'Mito del Emprendedor', que sostiene que la mayoría de las personas que inician negocios no son emprendedores, sino técnicos que se ven obligados a trabajar en su negocio en lugar de trabajar en él.",
                "Gerber argumenta que los técnicos a menudo carecen de las habilidades empresariales necesarias para hacer crecer su negocio con éxito y se ven atrapados en una trampa de trabajar 'en' su negocio en lugar de 'en' él.",
                "El libro propone que los empresarios deben adoptar una mentalidad empresarial y trabajar 'en' su negocio desarrollando sistemas y procesos que permitan la libertad y el crecimiento.",
                "",
                "El libro propone que los empresarios deben adoptar una mentalidad empresarial y trabajar 'en' su negocio desarrollando sistemas y procesos que permitan la libertad y el crecimiento."
            ),
            PreguntaClass(
                "¿Por qué es importante para los empresarios trabajar 'en' su negocio en lugar de 'en' él?",
                "Trabajar 'en' el negocio implica trabajar en las tareas diarias y operativas, mientras que trabajar 'en' el negocio implica trabajar en la estrategia, los sistemas y los procesos que permiten el crecimiento y la eficiencia a largo plazo.",
                "Al trabajar 'en' el negocio, los empresarios pueden crear sistemas y procesos que les permitan delegar tareas y centrarse en actividades que generen valor y promuevan el crecimiento.",
                "Este enfoque también permite a los empresarios crear un negocio que funcione sin depender de su presencia constante, lo que les brinda libertad y flexibilidad para perseguir otros intereses y oportunidades.",
                "",
                "Al trabajar 'en' el negocio, los empresarios pueden crear sistemas y procesos que les permitan delegar tareas y centrarse en actividades que generen valor y promuevan el crecimiento."
            ),
            PreguntaClass(
                "¿Cuál es el papel de los sistemas y los procesos en el éxito empresarial?",
                "Los sistemas y los procesos son fundamentales para crear un negocio escalable y sostenible, ya que proporcionan consistencia, eficiencia y calidad en todas las áreas de la operación.",
                "Al desarrollar sistemas y procesos claros y documentados, los empresarios pueden mejorar la productividad, reducir los errores y garantizar una experiencia consistente para los clientes.",
                "Los sistemas y los procesos también permiten a los empresarios delegar tareas de manera efectiva, liberando tiempo y recursos para centrarse en actividades estratégicas y de crecimiento.",
                "",
                "Los sistemas y los procesos también permiten a los empresarios delegar tareas de manera efectiva, liberando tiempo y recursos para centrarse en actividades estratégicas y de crecimiento."
            ),
            PreguntaClass(
                "¿Cómo pueden los empresarios aplicar los principios del libro a sus propios negocios?",
                "Los empresarios pueden comenzar identificando las áreas de su negocio que dependen demasiado de ellos y creando sistemas y procesos para delegar esas responsabilidades.",
                "También pueden examinar sus roles y responsabilidades actuales para determinar si están trabajando 'en' su negocio o simplemente 'en' él, y ajustar su enfoque en consecuencia.",
                "Además, los empresarios pueden adoptar una mentalidad de aprendizaje continuo y estar abiertos a la implementación de nuevas ideas y prácticas empresariales que promuevan la eficiencia y el crecimiento.",
                "",
                "Además, los empresarios pueden adoptar una mentalidad de aprendizaje continuo y estar abiertos a la implementación de nuevas ideas y prácticas empresariales que promuevan la eficiencia y el crecimiento."
            ),
            PreguntaClass(
                "¿Cuál es el mensaje más importante que los empresarios deben llevarse del libro?",
                "El mensaje más importante es que los empresarios deben dejar de ser técnicos atrapados en su negocio y convertirse en empresarios que trabajan 'en' su negocio.",
                "Esto implica desarrollar sistemas y procesos que permitan la libertad, el crecimiento y la escalabilidad, y adoptar una mentalidad empresarial que promueva la innovación y el aprendizaje continuo.",
                "Al hacerlo, los empresarios pueden crear negocios que funcionen de manera más eficiente, efectiva y sostenible, lo que les permite alcanzar sus objetivos personales y empresariales a largo plazo.",
                "",
                "Al hacerlo, los empresarios pueden crear negocios que funcionen de manera más eficiente, efectiva y sostenible, lo que les permite alcanzar sus objetivos personales y empresariales a largo plazo."
            )
        )
    }


    private fun zeroToOne(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuál es el concepto principal de 'Zero to One'?",
                "El concepto principal es la idea de crear algo nuevo y único que no existía antes ('de cero a uno'), en lugar de simplemente mejorar o copiar lo que ya existe ('de uno a n').",
                "Thiel argumenta que las innovaciones verdaderamente importantes ocurren cuando las empresas desarrollan tecnologías o ideas completamente nuevas que cambian fundamentalmente el juego.",
                "El libro destaca la importancia de la innovación radical y la creación de monopolios naturales como clave para el éxito empresarial a largo plazo.",
                "",
                "El concepto principal es la idea de crear algo nuevo y único que no existía antes ('de cero a uno'), en lugar de simplemente mejorar o copiar lo que ya existe ('de uno a n')."
            ),
            PreguntaClass(
                "¿Cuál es la diferencia entre competencia perfecta y monopolio?",
                "En la competencia perfecta, muchas empresas compiten en un mercado con productos similares, lo que lleva a una competencia intensa y a márgenes de beneficio estrechos.",
                "En un monopolio, una empresa domina un mercado al poseer un producto único o una ventaja tecnológica significativa, lo que le permite establecer precios más altos y obtener mayores márgenes de beneficio.",
                "Thiel argumenta que los monopolios pueden ser beneficiosos si están basados en la innovación y la creación de valor, ya que permiten a las empresas capturar una parte significativa del mercado y reinvertir los beneficios en el crecimiento y la mejora continua.",
                "",
                "Thiel argumenta que los monopolios pueden ser beneficiosos si están basados en la innovación y la creación de valor, ya que permiten a las empresas capturar una parte significativa del mercado y reinvertir los beneficios en el crecimiento y la mejora continua."
            ),
            PreguntaClass(
                "¿Cuáles son algunos ejemplos de empresas que han pasado de 'cero a uno'?",
                "Ejemplos incluyen a Google, que creó un motor de búsqueda revolucionario que transformó la forma en que la gente accede a la información en línea, y Tesla, que desarrolló tecnología de vehículos eléctricos que cambió la industria automotriz.",
                "Otro ejemplo es Facebook, que creó una plataforma de redes sociales innovadora que conecta a miles de millones de personas en todo el mundo y transforma la forma en que se comunican y comparten información.",
                "Estas empresas no solo mejoraron los productos o servicios existentes, sino que crearon algo completamente nuevo y disruptivo que no existía antes.",
                "",
                "Estas empresas no solo mejoraron los productos o servicios existentes, sino que crearon algo completamente nuevo y disruptivo que no existía antes."
            ),
            PreguntaClass(
                "¿Cuál es la importancia de la 'tecnología de la información' según el libro?",
                "La tecnología de la información (TI) es fundamental para la innovación y el progreso, ya que permite a las empresas desarrollar nuevos productos, servicios y modelos de negocio que cambian la forma en que vivimos y trabajamos.",
                "Thiel argumenta que la TI es una de las áreas más prometedoras para la innovación porque tiene el potencial de impactar prácticamente todos los aspectos de la sociedad y la economía.",
                "El libro sugiere que las empresas que dominan la tecnología de la información pueden construir monopolios duraderos y crear un valor significativo para los accionistas y la sociedad en general.",
                "",
                "La tecnología de la información (TI) es fundamental para la innovación y el progreso, ya que permite a las empresas desarrollar nuevos productos, servicios y modelos de negocio que cambian la forma en que vivimos y trabajamos."
            ),
            PreguntaClass(
                "¿Cuáles son los principios clave para crear un monopolio según 'Zero to One'?",
                "Algunos principios clave incluyen enfocarse en la creación de un producto o servicio único y valioso, desarrollar una ventaja tecnológica significativa y establecer barreras de entrada que protejan el negocio de la competencia.",
                "El libro también destaca la importancia de la escalabilidad, la red efectiva y la capacidad de rechazo de las concesiones para construir un monopolio exitoso y sostenible.",
                "Thiel sugiere que los empresarios deben buscar oportunidades para crear monopolios naturales que capturen una parte significativa del mercado y generen rendimientos excepcionales para los inversores y los accionistas.",
                "",
                "Thiel sugiere que los empresarios deben buscar oportunidades para crear monopolios naturales que capturen una parte significativa del mercado y generen rendimientos excepcionales para los inversores y los accionistas."
            )
        )
    }

    private fun goodToGreat(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuál es el concepto principal de 'Good to Great'?",
                "El libro se centra en comprender qué distingue a las empresas 'excelentes' de las 'buenas', y ofrece ideas sobre cómo otras organizaciones pueden seguir su ejemplo para alcanzar la grandeza.",
                "El concepto principal es identificar las características comunes de las empresas que lograron pasar de ser buenas a ser excelentes y mantener ese rendimiento excepcional durante un período prolongado.",
                "Collins y su equipo de investigación identificaron empresas que lograron un rendimiento sobresaliente durante un período de al menos 15 años y analizaron los factores clave que contribuyeron a su éxito.",
                "",
                "El concepto principal es identificar las características comunes de las empresas que lograron pasar de ser buenas a ser excelentes y mantener ese rendimiento excepcional durante un período prolongado."
            ),
            PreguntaClass(
                "¿Qué significa 'de buena a grande' según el libro?",
                "El concepto 'de buena a grande' se refiere a la transformación de una empresa que, aunque sea buena, no está entre los líderes de su industria, en una empresa que logra un rendimiento excepcional y supera consistentemente a sus competidores.",
                "Collins argumenta que pasar de ser buena a ser grande implica un cambio fundamental en el enfoque, la estrategia y la cultura organizacional, así como un compromiso firme con la excelencia y la mejora continua.",
                "El libro sostiene que lograr la grandeza requiere un liderazgo visionario, una disciplina implacable y un enfoque persistente en los principios y prácticas que generan resultados superiores.",
                "",
                "El concepto 'de buena a grande' se refiere a la transformación de una empresa que, aunque sea buena, no está entre los líderes de su industria, en una empresa que logra un rendimiento excepcional y supera consistentemente a sus competidores."
            ),
            PreguntaClass(
                "¿Cuáles son algunas de las características clave de las empresas 'excelentes' identificadas en el libro?",
                "Algunas características clave incluyen un liderazgo visionario y carismático, una cultura empresarial sólida y un compromiso inquebrantable con la excelencia y la innovación.",
                "Collins también destaca la importancia de la disciplina, la adaptabilidad y la capacidad de enfrentar los desafíos con determinación y resiliencia.",
                "Las empresas 'excelentes' tienden a centrarse en lo que hacen mejor y a evitar la complacencia, la burocracia y la inercia organizacional que pueden obstaculizar el crecimiento y el éxito a largo plazo.",
                "",
                "Algunas características clave incluyen un liderazgo visionario y carismático, una cultura empresarial sólida y un compromiso inquebrantable con la excelencia y la innovación."
            ),
            PreguntaClass(
                "¿Cómo aborda 'Good to Great' el tema del liderazgo?",
                "Collins identifica líderes 'nível 5', aquellos que combinan humildad personal con una voluntad férrea de lograr resultados, como los más exitosos en llevar a sus empresas a la grandeza.",
                "El libro sugiere que los líderes efectivos construyen equipos sólidos, establecen metas ambiciosas y crean una cultura de disciplina, responsabilidad y excelencia que impulsa el éxito a largo plazo.",
                "El libro examina el papel crucial del liderazgo en el proceso de pasar de ser bueno a ser grande, y destaca la importancia de un liderazgo visionario, carismático y comprometido con la excelencia.",
                "",
                "El libro examina el papel crucial del liderazgo en el proceso de pasar de ser bueno a ser grande, y destaca la importancia de un liderazgo visionario, carismático y comprometido con la excelencia."
            ),
            PreguntaClass(
                "¿Cuál es la lección principal que los lectores pueden aprender de 'Good to Great'?",
                "La lección principal es que la grandeza empresarial no es el resultado de la suerte o las circunstancias externas, sino más bien el resultado de decisiones estratégicas, culturales y de liderazgo consistentes y deliberadas.",
                "Collins argumenta que cualquier empresa, independientemente de su tamaño o industria, puede aspirar a la grandeza si sigue los principios y prácticas identificados en el libro y se compromete con la mejora continua y la excelencia.",
                "El libro ofrece una hoja de ruta para alcanzar la grandeza organizacional, destacando la importancia de la visión, la disciplina, la humildad y la perseverancia en el viaje hacia el éxito empresarial duradero.",
                "",
                "La lección principal es que la grandeza empresarial no es el resultado de la suerte o las circunstancias externas, sino más bien el resultado de decisiones estratégicas, culturales y de liderazgo consistentes y deliberadas."
            )
        )
    }

    private fun fourHourWorkWeek(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuál es el concepto principal de 'The 4-Hour Work Week'?",
                "El concepto principal es cuestionar y redefinir la idea tradicional de trabajar largas horas durante toda la vida para luego retirarse y disfrutar de la vida.",
                "Ferriss propone un enfoque de estilo de vida centrado en el diseño, donde las personas puedan trabajar de manera más eficiente y productiva en menos tiempo, y dedicar el resto del tiempo a sus intereses personales y actividades placenteras.",
                "El libro se enfoca en cómo utilizar la automatización, la delegación y otras estrategias para minimizar el tiempo dedicado al trabajo y maximizar el tiempo dedicado a vivir la vida al máximo.",
                "",
                "El concepto principal es cuestionar y redefinir la idea tradicional de trabajar largas horas durante toda la vida para luego retirarse y disfrutar de la vida."
            ),
            PreguntaClass(
                "¿Cuál es el principio del 'menos es más' en 'The 4-Hour Work Week'?",
                "El principio del 'menos es más' se refiere a simplificar y optimizar la vida eliminando actividades y responsabilidades innecesarias para centrarse en lo que realmente importa.",
                "Ferriss argumenta que muchas personas llenan su tiempo con tareas improductivas o actividades que no les brindan satisfacción real, y propone eliminar o delegar estas actividades para liberar tiempo y energía para lo que realmente importa.",
                "El enfoque del 'menos es más' se basa en la idea de que la calidad de vida no está determinada por la cantidad de tiempo dedicado al trabajo, sino por la calidad de ese tiempo y cómo se utiliza para enriquecer otras áreas de la vida.",
                "",
                "El principio del 'menos es más' se refiere a simplificar y optimizar la vida eliminando actividades y responsabilidades innecesarias para centrarse en lo que realmente importa."
            ),
            PreguntaClass(
                "¿Cómo promueve 'The 4-Hour Work Week' la idea de la movilidad geográfica y la libertad de ubicación?",
                "Ferriss alienta a los lectores a explorar la posibilidad de trabajar de forma remota, establecer su propio horario y vivir en lugares que les brinden más satisfacción personal y calidad de vida.",
                "El enfoque de movilidad geográfica en 'The 4-Hour Work Week' ofrece a las personas la libertad de viajar, explorar diferentes culturas y estilos de vida, y disfrutar de una mayor flexibilidad en cómo y dónde trabajan.",
                "El libro sugiere que muchas personas pueden realizar su trabajo de forma remota o desde cualquier lugar del mundo gracias a la tecnología digital y las comunicaciones modernas.",
                "",
                "El libro sugiere que muchas personas pueden realizar su trabajo de forma remota o desde cualquier lugar del mundo gracias a la tecnología digital y las comunicaciones modernas."
            ),
            PreguntaClass(
                "¿Cuál es la estrategia de Ferriss para aumentar la eficiencia y la productividad en el trabajo?",
                "Además, sugiere el uso de la automatización y la delegación para eliminar tareas repetitivas o de bajo valor y centrarse en actividades de alto valor que generen un impacto significativo.",
                "El enfoque de Ferriss se basa en la optimización del tiempo y los recursos para lograr resultados óptimos con la menor cantidad de esfuerzo y estrés posible.",
                "Ferriss propone el uso de la 'Ley de Pareto' o el principio del 80/20 para identificar y enfocarse en las tareas que generan el 80% de los resultados con el 20% del esfuerzo.",
                "",
                "Ferriss propone el uso de la 'Ley de Pareto' o el principio del 80/20 para identificar y enfocarse en las tareas que generan el 80% de los resultados con el 20% del esfuerzo."
            ),
            PreguntaClass(
                "¿Cuál es el mensaje clave que los lectores pueden extraer de 'The 4-Hour Work Week'?",
                "El mensaje clave es que es posible diseñar un estilo de vida que permita trabajar menos horas y disfrutar más de la vida, aprovechando la tecnología, la automatización y la libertad de ubicación.",
                "Ferriss desafía la noción de que el éxito está ligado a trabajar largas horas y propone un enfoque más equilibrado y gratificante que prioriza la eficiencia, la libertad y la calidad de vida.",
                "El libro ofrece estrategias prácticas y consejos para quienes desean escapar de la trampa del trabajo tradicional y diseñar una vida que les permita perseguir sus pasiones y disfrutar de experiencias significativas.",
                "",
                "El mensaje clave es que es posible diseñar un estilo de vida que permita trabajar menos horas y disfrutar más de la vida, aprovechando la tecnología, la automatización y la libertad de ubicación."
            )
        )
    }


    private fun thinkAndGrowRich(): List<PreguntaClass> {
        return listOf(
            PreguntaClass(
                "¿Cuál es el concepto central de 'Think and Grow Rich'?",
                "Napoleon Hill argumenta que el pensamiento positivo y una fuerte determinación pueden superar cualquier obstáculo y llevar a la realización de los objetivos.",
                "El concepto central es que el pensamiento positivo y el deseo ardiente son fundamentales para lograr el éxito y la riqueza.",
                "El libro enseña que al enfocarse en metas claras y visualizar el éxito, se pueden generar las creencias y acciones necesarias para hacer realidad los sueños.",
                "",
                "El concepto central es que el pensamiento positivo y el deseo ardiente son fundamentales para lograr el éxito y la riqueza."
            ),
            PreguntaClass(
                "¿Cuál es la importancia de la 'mentalidad de riqueza' según 'Think and Grow Rich'?",
                "La 'mentalidad de riqueza' se refiere a adoptar una mentalidad positiva y proactiva hacia el dinero y el éxito.",
                "Hill sugiere que la mentalidad de riqueza incluye la creencia en la propia capacidad para lograr el éxito financiero y la disposición para asumir riesgos calculados en la búsqueda de la riqueza.",
                "El libro enseña que la mentalidad de riqueza es un factor clave para atraer oportunidades financieras y crear una vida abundante y próspera.",
                "",
                "La 'mentalidad de riqueza' se refiere a adoptar una mentalidad positiva y proactiva hacia el dinero y el éxito."
            ),
            PreguntaClass(
                "¿Cómo influye la 'autosugestión' en el logro de la riqueza según 'Think and Grow Rich'?",
                "La autosugestión implica repetir afirmaciones positivas y visualizar el éxito como una forma de programar la mente subconsciente para alcanzar los objetivos deseados.",
                "Hill argumenta que la autosugestión puede ayudar a superar las dudas y los miedos internos, permitiendo a las personas mantener una mentalidad positiva y enfocada en el éxito.",
                "El libro enfatiza la importancia de utilizar la autosugestión de manera consistente y persistente para reforzar las creencias positivas y fortalecer la determinación en la búsqueda de la riqueza.",
                "",
                "La autosugestión implica repetir afirmaciones positivas y visualizar el éxito como una forma de programar la mente subconsciente para alcanzar los objetivos deseados."
            ),
            PreguntaClass(
                "¿Cuál es el papel de la 'persistencia' en la filosofía de 'Think and Grow Rich'?",
                "Hill enseña que el camino hacia la riqueza está lleno de contratiempos y fracasos, y que la persistencia es necesaria para mantenerse firme en la búsqueda de los objetivos a pesar de los reveses.",
                "El libro destaca ejemplos de personas exitosas que lograron sus metas debido a su determinación inquebrantable y su capacidad para perseverar a pesar de las adversidades.",
                "La persistencia es fundamental para superar los desafíos y obstáculos en el camino hacia la riqueza y el éxito.",
                "",
                "La persistencia es fundamental para superar los desafíos y obstáculos en el camino hacia la riqueza y el éxito."
            ),
            PreguntaClass(
                "¿Qué consejos prácticos ofrece 'Think and Grow Rich' para aquellos que buscan riqueza?",
                "El libro sugiere la importancia de definir claramente los objetivos financieros y crear un plan detallado para alcanzarlos.",
                "Hill también recomienda rodearse de personas positivas y exitosas que puedan servir como mentores y modelos a seguir en el viaje hacia la riqueza.",
                "Además, el autor enfatiza la necesidad de tomar acción decisiva y persistente para convertir los deseos en realidad, y la importancia de mantener una actitud mental positiva y enfocada en el éxito.",
                "",
                "Hill también recomienda rodearse de personas positivas y exitosas que puedan servir como mentores y modelos a seguir en el viaje hacia la riqueza."
            )
        )
    }

}
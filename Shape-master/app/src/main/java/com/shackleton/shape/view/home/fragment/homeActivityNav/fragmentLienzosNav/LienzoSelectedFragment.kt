package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentLienzosNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shackleton.shape.custom.adapter.EnunciadosAdapter
import com.shackleton.shape.databinding.FragmentLienzoSelectedBinding
import com.shackleton.shape.db.laravel.model.Statement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LienzoSelectedFragment : Fragment() {

    private var _binding: FragmentLienzoSelectedBinding? = null
    private val binding get() = _binding!!

    private val args: LienzoSelectedFragmentArgs by navArgs()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private var isPdfVisible = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.parameters[0] != "NO") {
            with(binding) {
                nombreDelProyecto.text = args.parameters[0]
                nombreDelLienzo.text = args.parameters[1]
                buttonVerPDF.setOnClickListener {
                    if (!isPdfVisible) {
                        showPdf()
                    } else {
                        hidePdf()
                    }
                }
            }
        }
        statementCanvas()
    }

    private fun showPdf() {
        isPdfVisible = true
        binding.apply {
            //pdfView.visibility = View.VISIBLE
            indeterminateCircularIndicator.visibility = View.VISIBLE
            buttonVerPDF.isEnabled = false
        }

        coroutineScope.launch {
            val lienzoS = canvasSelected(args.parameters[2])
            //binding.pdfView.fromAsset(lienzoS).load()

            delay(2000)

            val btnText = "Ocultar PDF"
            val btnText2 = "Ver PDF"
            binding.buttonVerPDF.text = if (isPdfVisible) btnText else btnText2

            binding.indeterminateCircularIndicator.visibility = View.GONE
            binding.buttonVerPDF.isEnabled = true
        }
    }

    private fun hidePdf() {
        val s = "Ver PDF"
        isPdfVisible = false
        binding.apply {
            //pdfView.visibility = View.GONE
            indeterminateCircularIndicator.visibility = View.GONE
            buttonVerPDF.text = s
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun statementCanvas() {

        when (args.parameters[2].toInt()) {
            0 -> binding.enunciadosAdapter.adapter = EnunciadosAdapter(
                requireActivity(),
                loadStatementLienzoModelo(),
                binding.root,
                args.parameters[3].toInt(),
                0,args.parameters[0]
            )

            1 -> binding.enunciadosAdapter.adapter = EnunciadosAdapter(
                requireActivity(),
                loadStatementLienzoVision(),
                binding.root,
                args.parameters[3].toInt(),
                1,
                args.parameters[0]
            )

            2 -> binding.enunciadosAdapter.adapter = EnunciadosAdapter(
                requireActivity(),
                loadStatementLienzoValidacion(),
                binding.root,
                args.parameters[3].toInt(),
                2,
                args.parameters[0]
            )

            3 -> binding.enunciadosAdapter.adapter = EnunciadosAdapter(
                requireActivity(),
                loadStatementLienzoPropuesta(),
                binding.root,
                args.parameters[3].toInt(),
                3,
                args.parameters[0]
            )

            4 -> binding.enunciadosAdapter.adapter = EnunciadosAdapter(
                requireActivity(),
                loadStatementLienzoLeanProject(),
                binding.root,
                args.parameters[3].toInt(),
                4,
                args.parameters[0]
            )
        }

    }

    private fun loadStatementLienzoVision(): List<Statement> {
        return listOf(
            Statement(
                "Casos de éxitos anteriores",
                "",
                false
            ),
            Statement("Dónde estamos", "", false),
            Statement("Dónde queremos estar", "", false),
            Statement("Qué nos ayuda", "", false),
            Statement("Qué nos frena", "", false),
        )
    }
    private fun loadStatementLienzoModelo(): List<Statement> {
        return listOf(
            Statement("Socios clave", "", false),
            Statement("Actividades clave", "", false),
            Statement("Propuesta de valor", "", false),
            Statement("Relación con clientes", "", false),
            Statement("Segmentos de clientes", "", false),
            Statement("Recursos clave", "", false),
            Statement("Dolor", "", false),
            Statement("Canales", "", false),
            Statement("Financieros", "", false),
            Statement("Personas/Sociales", "", false),
            Statement("Medioambientales", "", false),
            Statement("Financieros", "", false),
            Statement("Personas/Sociales", "", false),
            Statement("Medioambientales", "", false),
        )
    }
    private fun loadStatementLienzoValidacion(): List<Statement> {
        return listOf(
        )
    }
    private fun loadStatementLienzoPropuesta(): List<Statement> {
        return listOf(
            Statement("Dolores (Costes)", "", false),
            Statement("Beneficios", "", false),
            Statement("Qué necesito resolver", "", false),
            Statement("Aliviadores de dolores", "", false),
            Statement("Creadores de beneficios", "", false),
            Statement(
                "Producto/Servicio/Proyecto",
                "",
                false
            ),
        )
    }

    private fun loadStatementLienzoLeanProject(): List<Statement> {
        return listOf(
            Statement("Dolor", "", false),
            Statement("Valor aportado (cliente)", "", false),
            Statement("Segmentos de clientes", "", false),
            Statement("Posibles soluciones", "", false),
            Statement(
                "Preparación y soporte de las soluciones",
                "",
                false
            ),
            Statement("Valor aportado (negocio)", "", false),
            Statement(
                "Canales de distribución y comunicación",
                "",
                false
            ),
            Statement("Métricas de éxito (KPIs)", "", false),
            Statement("Costes", "", false),
        )
    }

    private fun canvasSelected(pos: String): String {
        return when (pos) {
            "0" -> "lienzos_pdfs/modelo_de_negocio.pdf"
            "1" -> "lienzos_pdfs/lienzo_vision.pdf"
            "2" -> "lienzos_pdfs/lienzo_validacion_ligera.pdf"
            "3" -> "lienzos_pdfs/lienzo_propuesta_de_valor.pdf"
            "4" -> "lienzos_pdfs/lienzo_lean_project.pdf"
            else -> throw IllegalArgumentException("Posición de lienzo inválida: $pos")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLienzoSelectedBinding.inflate(inflater, container, false)

        return binding.root
    }

}
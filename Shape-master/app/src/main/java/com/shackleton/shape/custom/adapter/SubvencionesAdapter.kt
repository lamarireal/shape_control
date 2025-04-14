import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.SubvencionesAdapterBinding
import com.shackleton.shape.db.laravel.model.Subvenciones

class SubvencionesAdapter(var lista: List<Subvenciones>) : RecyclerView.Adapter<SubvencionesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.subvenciones_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SubvencionesAdapterBinding.bind(view)

        fun bind(subvencion: Subvenciones) {
            with(binding) {
                title.text = subvencion.title
                description.text = subvencion.description
                button.text = subvencion.button
                Glide.with(imagenReto).load(subvencion.url).into(imagenReto)

                button.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Pulsado: ${subvencion.title}",
                        Toast.LENGTH_SHORT
                    ).show()

                    val link = when (subvencion.title) {
                        "Premio Emprendedor Del Año" -> "https://www.ey.com/es_es/premio-emprendedor-del-ano"
                        "Premios Innovación Social" -> "https://es.weforum.org/stories/2024/09/estos-son-los-finalistas-de-los-premios-de-innovacion-social-2025-de-la-fundacion-schwab/"
                        "Premios Nuevas Tecnologías" -> "https://presidencia.gva.es/es/premis-rei-jaume-i/guardonats-premi-noves-tecnologies"
                        else -> null
                    }

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}

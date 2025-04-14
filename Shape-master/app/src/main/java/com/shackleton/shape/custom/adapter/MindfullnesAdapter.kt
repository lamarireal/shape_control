package com.shackleton.shape.custom.adapter

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.MindfullnesAdapterBinding
import com.shackleton.shape.db.laravel.model.Mindfullnes

class MindfullnesAdapter(var lista: List<Mindfullnes>) : RecyclerView.Adapter<MindfullnesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.mindfullnes_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = MindfullnesAdapterBinding.bind(view)

        fun bind(list: Mindfullnes) {
            with(binding) {
                title.text = list.title
                description.text = list.description
                button.text = list.button
                Glide.with(imagenReto).load(list.url).into(imagenReto)

                button.setOnClickListener {
                    // Si el título es "Date un respiro", intentamos abrir la app de reloj o un enlace
                    if (list.title == "Date un respiro") {
                        val intent = try {
                            // Intent para Google Clock (com.google.android.deskclock)
                            itemView.context.packageManager.getLaunchIntentForPackage("com.google.android.deskclock")
                        } catch (e: Exception) {
                            // Si no se encuentra la app de Google Clock, intenta con otra opción
                            itemView.context.packageManager.getLaunchIntentForPackage("com.sec.android.app.clockpackage")  // Samsung Clock
                        }

                        if (intent != null) {
                            // Si la app de reloj está instalada, la lanzamos
                            itemView.context.startActivity(intent)
                        } else {
                            // Si no se encuentra la app de reloj, abre el cronómetro en línea
                            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://reloj-alarma.es/temporizador/"))
                            itemView.context.startActivity(playStoreIntent)
                        }
                    }
                    // Si el título es "Silenciar mis notificaciones", activamos No Molestar
                    else if (list.title == "Desactiva tus notificaciones") {
                        val notificationManager = itemView.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                        if (notificationManager.isNotificationPolicyAccessGranted) {
                            // Si tenemos el permiso, activamos No Molestar
                            notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE)
                            Toast.makeText(itemView.context, "Modo No Molestar activado", Toast.LENGTH_SHORT).show()
                        } else {
                            // Si no tenemos el permiso, pedimos al usuario que lo habilite
                            Toast.makeText(itemView.context, "Por favor, habilita el acceso al modo No Molestar", Toast.LENGTH_LONG).show()
                            itemView.context.startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS))
                        }
                    } else {
                        // Si no es "Date un respiro" ni "Silenciar mis notificaciones", simplemente muestra un mensaje Toast
                        Toast.makeText(itemView.context, "Pulsado: ${list.title}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

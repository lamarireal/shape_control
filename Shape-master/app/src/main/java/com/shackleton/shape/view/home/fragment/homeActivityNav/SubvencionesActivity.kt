package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.SubvencionesAdapter
import com.shackleton.shape.databinding.ActivitySubvencionesBinding
import com.shackleton.shape.db.laravel.model.Subvenciones

class SubvencionesActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubvencionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubvencionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerSubvenciones.adapter = SubvencionesAdapter(cargarList())

    }

    private fun cargarList(): List<Subvenciones> {
        return listOf(
            Subvenciones(
                getString(R.string.emprendedorTitle),
                getString(R.string.emprendedorDescription),
                getString(R.string.botonSubvenciones),
                "https://images.unsplash.com/photo-1578574577315-3fbeb0cecdc2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwyfHxtZW50b3J8ZW58MXx8fHwxNjgyNDk1ODI2&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Subvenciones(
                getString(R.string.innovacionTitle),
                getString(R.string.innovacionDescription),
                getString(R.string.botonSubvenciones),
                "https://images.unsplash.com/photo-1527689368864-3a821dbccc34?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2fHxtZW50b3J8ZW58MXx8fHwxNjgyNDk1ODI2&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Subvenciones(
                getString(R.string.tecnologiasTitle),
                getString(R.string.tecnologiasDescription),
                getString(R.string.botonSubvenciones),
                "https://images.unsplash.com/photo-1511376979163-f804dff7ad7b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxMnx8bWVudG9yfGVufDF8fHx8MTY4MjQ5NTgyNg&ixlib=rb-4.0.3&q=80&w=1080"
            ),
        )
    }
}
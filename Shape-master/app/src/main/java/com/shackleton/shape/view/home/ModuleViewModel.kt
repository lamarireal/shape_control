package com.shackleton.shape.view.home

import androidx.lifecycle.ViewModel
import com.shackleton.shape.db.laravel.model.Module
import com.shackleton.shape.R

class ModuleViewModel : ViewModel() {

    private val modules: MutableList<Module> = mutableListOf()

    init {
        modules.addAll(
            listOf(
                Module(1, "Reto", "Descripción del reto", "Ir al reto", "https://images.unsplash.com/photo-1453475250267-163ff185e88e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzfHxtb2xlc2tpbmV8ZW58MXx8fHwxNjc2OTA2NDgy&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(2, "Evalúa", "Descripción de evaluación", "Comenzar evaluación", "https://images.unsplash.com/photo-1592312040834-bb0d621713e1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwyMXx8cGFwZXJzfGVufDF8fHx8MTY3NjkwNjM1Mg&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(3, "Inspírate", "Frases y más", "Ver frases", "https://images.unsplash.com/photo-1525972385596-02ad3049150b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2NHx8Y3JlYXRpdmUlMjB0b29sc3xlbnwxfHx8fDE2Nzc2NjE4OTg&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(4, "Herramientas", "Tus herramientas personales", "Abrir herramientas", "https://images.unsplash.com/photo-1516383740770-fbcc5ccbece0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzOHx8aW5zcGlyYXRpb258ZW58MXx8fHwxNjc2OTA2NDIw&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(5, "Networking", "Conecta con otros", "Ir a networking", "https://images.unsplash.com/photo-1542744173-8e7e53415bb0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxMnx8ZXZlbnQlMjBtYXJrZXRpbmd8ZW58MXx8fHwxNjc3NjYxOTc1&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(6, "Lienzos", "Herramienta para crear", "Ver lienzos", "https://images.unsplash.com/photo-1522542550221-31fd19575a2d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxN3x8ZGVzaWduJTIwdGhpbmtpbmd8ZW58MXx8fHwxNjc3NjYyMTk5&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(7, "Mindfullness", "Meditación y concentración", "Practicar", "https://images.unsplash.com/photo-1621090483697-29b32b735a73?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2fHxtaW5kZnVsbmVzc3xlbnwxfHx8fDE2Nzc3NTExMTg&ixlib=rb-4.0.3&q=80&w=1080", true),
                Module(8, "Subvenciones", "Información de ayudas", "Ver subvenciones", "https://images.unsplash.com/photo-1590283603385-17ffb3a7f29f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw3fHxmaW5hbmNlfGVufDF8fHx8MTY4MjQxNTE5Ng&ixlib=rb-4.0.3&q=80&w=1080", true)
            )
        )
    }

    fun getModules(): List<Module> = modules

    fun setModuleVisible(id: Int, visible: Boolean) {
        modules.find { it.id == id }?.visible = visible
    }

    fun getVisibleModules(): List<Module> = modules.filter { it.visible }

    fun getHiddenModules(): List<Module> = modules.filter { !it.visible }
}

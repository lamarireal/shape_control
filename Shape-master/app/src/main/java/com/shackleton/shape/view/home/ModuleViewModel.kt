package com.shackleton.shape.view.home

import androidx.lifecycle.ViewModel
import com.shackleton.shape.db.laravel.model.Module
import com.shackleton.shape.shared.SharedApp

class ModuleViewModel : ViewModel() {

    private val modules: MutableList<Module> = mutableListOf()

    init {
        val allModules = listOf(
            Module(1, "Reto", "Descripción del reto", "Ir al reto", "https://images.unsplash.com/photo-1453475250267-163ff185e88e", true),
            Module(2, "Evalúa", "Descripción de evaluación", "Comenzar evaluación", "https://images.unsplash.com/photo-1592312040834-bb0d621713e1", true),
            Module(3, "Inspírate", "Frases y más", "Ver frases", "https://images.unsplash.com/photo-1525972385596-02ad3049150b", true),
            Module(4, "Herramientas", "Tus herramientas personales", "Abrir herramientas", "https://images.unsplash.com/photo-1516383740770-fbcc5ccbece0", true),
            Module(5, "Networking", "Conecta con otros", "Ir a networking", "https://images.unsplash.com/photo-1542744173-8e7e53415bb0", true),
            Module(6, "Lienzos", "Herramienta para crear", "Ver lienzos", "https://images.unsplash.com/photo-1522542550221-31fd19575a2d", true),
            Module(7, "Concéntrate y logra tu objetivo", "Meditación y concentración", "Practicar", "https://images.unsplash.com/photo-1621090483697-29b32b735a73", true),
            Module(8, "Subvenciones", "Información de ayudas", "Ver subvenciones", "https://images.unsplash.com/photo-1590283603385-17ffb3a7f29f", true)
        )

        val savedIds = SharedApp.preferences.visibleModules

        modules.addAll(
            allModules.map { module ->
                module.visible = savedIds.isEmpty() || savedIds.contains(module.id)
                module
            }
        )

        // Si es la primera vez, guarda todos como visibles
        if (savedIds.isEmpty()) {
            SharedApp.preferences.visibleModules = modules.map { it.id }
        }
    }

    fun getModules(): List<Module> = modules

    fun setModuleVisible(id: Int, visible: Boolean) {
        modules.find { it.id == id }?.visible = visible
        // Guarda los visibles en SharedPreferences
        SharedApp.preferences.visibleModules = getVisibleModules().map { it.id }
    }

    fun getVisibleModules(): List<Module> = modules.filter { it.visible }

    fun getHiddenModules(): List<Module> = modules.filter { !it.visible }
}

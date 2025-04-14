package com.shackleton.shape.db.laravel.model

class Statement (
    var statement: String,
    var answer: String,
    private var expandable : Boolean,
    val hasSubStatements: Boolean = false, // Añadir un flag para saber si tiene sub-statements
    val subStatements: List<Statement>? = null // Lista de sub-statements


) {
    fun isExpandable(): Boolean {
        return expandable
    }

    fun setExpandable(expandable: Boolean) {
        this.expandable = expandable
    }
}
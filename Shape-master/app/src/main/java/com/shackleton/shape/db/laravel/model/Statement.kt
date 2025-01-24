package com.shackleton.shape.db.laravel.model

class Statement (
    var statement: String,
    var answer: String,
    private var expandable : Boolean
) {
    fun isExpandable(): Boolean {
        return expandable
    }

    fun setExpandable(expandable: Boolean) {
        this.expandable = expandable
    }
}
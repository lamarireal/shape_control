package com.shackleton.shape.db.laravel.request.response

data class CheckResponse(
    val isNickTaken: Boolean,
    val isEmailTaken: Boolean
)
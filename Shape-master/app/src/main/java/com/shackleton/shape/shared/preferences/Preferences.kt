package com.shackleton.shape.shared.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.shackleton.shape.db.laravel.model.User

/**
 * Preference class used to define values to be stored in SharedPreferences
 */
class Preferences(context: Context) {
    /**
     * Reference to SharedPreferences object used in this class
     */
    private val preferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, 0)

    companion object{
        const val SHARED_PREFERENCES = "org.shackleton.metodoshape.preferences"

        // USER
        const val PREFERENCES_USER_NAME            = "preferences_user"
        const val PREFERENCES_USER_DEFAULT: String = ""

        // SESSION
        const val PREFERENCES_SESSION_NAME            = "preferences_session"
        const val PREFERENCES_SESSION_DEFAULT: String = ""

        // SESSION
        const val PREFERENCES_USER_IMAGE_PROFILE            = "preferences_profile"
        const val PREFERENCES_USER_IMAGE_PROFILE_DEFAULT: String = ""

        // Libro
        const val PREFERENCES_USER_LIBRO_1            = "preferences_profile1"
        const val PREFERENCES_USER_LIBRO_2            = "preferences_profile2"
        const val PREFERENCES_USER_LIBRO_3            = "preferences_profile3"
        const val PREFERENCES_USER_LIBRO_4            = "preferences_profile4"
        const val PREFERENCES_USER_LIBRO_5            = "preferences_profile5"
        const val PREFERENCES_USER_LIBRO_6            = "preferences_profile6"
        const val PREFERENCES_USER_LIBRO_7           = "preferences_profile7"
        const val PREFERENCES_USER_LIBRO_DEFAULT: Boolean = false

    }
    /**
     * User instance stored in Shared preference as a JSON string.
     * Conversion in and out of JSON is performed by get and set method os this property.
     */
    var user: User
        get() {
            val json: String? = preferences.getString(PREFERENCES_USER_NAME, null)
            return if (json != null) {
                Gson().fromJson(json, User::class.java)
            } else {
                User(-1, "null", "null", "null","",0)
            }
        }
        set(value) {
            val json = Gson().toJson(value)
            preferences.edit().putString(PREFERENCES_USER_NAME, json).apply()
        }

    /**
     * Session instance stored in Shared preference as a JSON string.
     * Conversion in and out of JSON is performed by get and set method os this property.
     */
    var session: String
        get(){
            val json: String? = preferences.getString(PREFERENCES_SESSION_NAME, PREFERENCES_SESSION_DEFAULT)
            return if (json != null) {
                return Gson().fromJson(json, String::class.java)
            } else {
                ""
            }
        }
        set(value) {
            val json = Gson().toJson(value)
            preferences.edit().putString(PREFERENCES_SESSION_NAME, json).apply()
        }
    var imageURL: String
        get(){
            val json: String? = preferences.getString(PREFERENCES_USER_IMAGE_PROFILE, PREFERENCES_USER_IMAGE_PROFILE_DEFAULT)
            return if (json != null) {
                return Gson().fromJson(json, String::class.java) ?: ""
            } else {
                ""
            }
        }
        set(value) {
            val json = Gson().toJson(value)
            preferences.edit().putString(PREFERENCES_USER_IMAGE_PROFILE, json).apply()
        }

    var libro1: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_1, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_1, value).apply()
        }

    var libro2: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_2, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_2, value).apply()
        }

    var libro3: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_3, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_3, value).apply()
        }

    var libro4: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_4, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_4, value).apply()
        }

    var libro5: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_5, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_5, value).apply()
        }

    var libro6: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_6, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_6, value).apply()
        }

    var libro7: Boolean
        get() {
            return preferences.getBoolean(PREFERENCES_USER_LIBRO_7, PREFERENCES_USER_LIBRO_DEFAULT)
        }
        set(value) {
            preferences.edit().putBoolean(PREFERENCES_USER_LIBRO_7, value).apply()
        }



//guardar datos de las tarjetas
    var visibleModules: List<Int>
        get() {
            val json = preferences.getString("visible_modules", null)
            return if (json != null) Gson().fromJson(json, Array<Int>::class.java).toList()
            else emptyList()
        }
        set(value) {
            val json = Gson().toJson(value)
            preferences.edit().putString("visible_modules", json).apply()
        }

}
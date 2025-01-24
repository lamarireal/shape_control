package com.shackleton.shape.view.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ActivityForgotPasswordBinding
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.view.session.MainSession
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailSend.setOnClickListener {
            openConnection().create(UserApi::class.java).forgotPassword(binding.emailForgotPassword.text.toString())
                .enqueue(object : Callback<GeneralResponse>{
                    override fun onResponse(
                        call: Call<GeneralResponse>,
                        response: Response<GeneralResponse>
                    ) {
                        if (response.isSuccessful){
                            Toast.makeText(applicationContext,"Te hemos enviado un correo con la contraseña", Toast.LENGTH_LONG).show()
                            finish()
                            val intent = Intent(applicationContext, MainSession::class.java)
                            startActivity(intent)
                        }
                        else{
                            println(response.message())
                            println(response.code())
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                       println(t.message)
                    }

                })
        }

    }
}
package org.plank.uaademo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var api = HenHouseApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignIn.setOnClickListener {
            signIn(etEmail.text.toString(), etPassword.text.toString())
        }
    }

    fun signIn(email: String, password: String) {
        api.enterHenHouse(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { e ->
            }
            .subscribe {
                startActivity(Intent(this, HenHouseActivity::class.java))
            }
    }
}

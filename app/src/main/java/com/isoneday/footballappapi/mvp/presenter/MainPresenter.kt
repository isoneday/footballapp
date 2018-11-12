package com.isoneday.footballappapi.mvp.presenter


import com.isoneday.footballappapi.mvp.model.ResponseLeague
import com.isoneday.footballappapi.mvp.view.MainView
import com.isoneday.footballappapi.network.InitRetrofit
import com.isoneday.footballappapi.network.RestApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Response

class MainPresenter(private val view : MainView) {

    fun getLastMatch(ligaId: Int) {
        view.showloading()
        val serviceListLiga: RestApi = InitRetrofit.getInstance()
        serviceListLiga.getLastMatch(ligaId).enqueue(object : retrofit2.Callback<ResponseLeague> {
            override fun onResponse(call: Call<ResponseLeague>?, response: Response<ResponseLeague>?) {
                view.hideloading()
                async(UI){
                    val datalist = bg {
                        response?.body()?.events
                    }
                    view.showlistteam(datalist.await())
                }

            }

            override fun onFailure(call: Call<ResponseLeague>?, t: Throwable?) {
                view.hideloading()
                view.showmessage(t?.message)
            }


        })
    }
    }

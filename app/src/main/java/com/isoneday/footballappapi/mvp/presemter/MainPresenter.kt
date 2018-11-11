package com.isoneday.footballappapi.mvp.presemter

import com.isoneday.footballappapi.mvp.model.ResponseLeague
import com.isoneday.footballappapi.mvp.view.MainView
import com.isoneday.footballappapi.network.InitRetrofit
import com.isoneday.footballappapi.network.RestApi
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Response

class MainPresenter(private val view : MainView) {

    fun getLastMatch(idliga : Int){
        view.showloading()
        val api : RestApi = InitRetrofit.getInstance()
        api.getLastMatch(idliga).enqueue(object  : retrofit2.Callback<ResponseLeague>{

            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {
           view.hideloading()
                view.showmessage("Sukses")
              //  asyn
              //  async(Contacts.Intents.UI)
                val datalist = bg {
                    response?.body()?.events
                  }
                view.showlistteam(datalist.await())

            }

            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {
            view.hideloading()
                view.showmessage(t.message)
            }


        })
    }
}
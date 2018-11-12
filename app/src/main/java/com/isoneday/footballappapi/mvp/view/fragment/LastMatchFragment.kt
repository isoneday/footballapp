package com.isoneday.footballappapi.mvp.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isoneday.footballappapi.R
import com.isoneday.footballappapi.adapter.ListLeagueAdapter
import com.isoneday.footballappapi.mvp.model.EventsItem
import com.isoneday.footballappapi.mvp.presenter.MainPresenter
import com.isoneday.footballappapi.mvp.view.MainView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LastMatchFragment : Fragment(), MainView {

    var mainPresenter : MainPresenter? = null
    var liga: MutableList<EventsItem> = mutableListOf()
    var idliga : Int =4335
    var listLeagueAdapter : ListLeagueAdapter? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_match, container, false)
        val layoutliga : RecyclerView = v.findViewById(R.id.listfootball)
        layoutliga.layoutManager = LinearLayoutManager(activity)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainPresenter =MainPresenter(this)
        mainPresenter?.getLastMatch(idliga)
        listLeagueAdapter = ListLeagueAdapter(liga)
    }

    override fun showloading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideloading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showmessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showlistteam(listteam: List<EventsItem>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

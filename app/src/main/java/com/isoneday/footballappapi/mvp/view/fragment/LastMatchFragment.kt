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
import com.isoneday.footballappapi.mvp.view.activity.DetailActivity
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

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
        listLeagueAdapter = ListLeagueAdapter(liga){
            startActivity<DetailActivity>("idevent" to "${it.idEvent}")
        }
        //set adapter ke view (RecyclerView)
        listfootball.adapter = listLeagueAdapter
    }

    override fun showloading() {
    progress.visibility = View.VISIBLE
    }

    override fun hideloading() {
        progress.visibility = View.INVISIBLE
    }

    override fun showmessage(message: String?) {
        toast(message.toString())
    }

    override fun showlistteam(listteam: List<EventsItem>?) {
        liga.clear()
        if (listteam!=null){
            liga.addAll(listteam)

        }else{
            toast("tidak ada data")
        }
        listLeagueAdapter?.notifyDataSetChanged()
    }


}

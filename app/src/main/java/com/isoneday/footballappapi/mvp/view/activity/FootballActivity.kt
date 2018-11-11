package com.isoneday.footballappapi.mvp.view.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.isoneday.footballappapi.R
import com.isoneday.footballappapi.mvp.view.fragment.LastMatchFragment
import com.isoneday.footballappapi.mvp.view.fragment.NextMatchFragment
import kotlinx.android.synthetic.main.activity_football.*

class FootballActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)
        //todo 1.2 buat tab sesuai dengan nama
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.lastmatch)))
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.nextmatch)))
        //todo 1.3 buat adapter untuk menghubungkan view dengan data (nama tab)
        val adapter = CustomAdapter(supportFragmentManager)
        pager.adapter=adapter
        //todo 1.4 beberapa action dari tab
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }
        //ketika tab dipilih maka akan menampilkan data sesuai dengan jenis tab
            override fun onTabSelected(p0: TabLayout.Tab?) {
            pager.currentItem = p0!!.position
            }
        })
    }
}

//todo 1.5 konfigurasi adapter untuk viepager
class CustomAdapter(supportFragmentManager: FragmentManager?) :
    FragmentStatePagerAdapter(supportFragmentManager) {
    //tentukan jumlah fragment yang akan di tampilkan (sesuai jumlah tab)
    private val fragmentlist = listOf<Fragment>(LastMatchFragment(),NextMatchFragment())
    override fun getItem(p0: Int) = fragmentlist[p0]
    override fun getCount() = fragmentlist.size


}

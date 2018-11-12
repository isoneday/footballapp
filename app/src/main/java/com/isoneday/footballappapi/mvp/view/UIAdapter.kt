package com.isoneday.footballappapi.mvp.view

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.isoneday.footballappapi.R
import org.jetbrains.anko.*

class UIAdapter : AnkoComponent<ViewGroup> {

    companion object {
        val image1 = 1
        val name1 = 2
    }


    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(matchParent, matchParent)
            padding = dip(15)
            imageView {
                id = image1
                setImageResource(R.drawable.notification_bg_normal)
            }.lparams {
                gravity = Gravity.CENTER
                width = dip(50)
                height = dip(50)
                rightMargin = dip(10)
            }
            textView {
                id = name1
                layoutParams = LinearLayout.LayoutParams(matchParent, matchParent)
                text = context.getString(R.string.away_team)
                gravity = Gravity.CENTER
                textSize = 20f
            }

        }

    }

}
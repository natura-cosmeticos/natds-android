package com.natura.android.sample.components.colors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natura.android.sample.R

class NaturaFragment (private val darkMode: Boolean) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(darkMode) {
            context?.theme?.applyStyle(R.style.Theme_NaturaDark_NoActionBar, true)
        } else {
            context?.theme?.applyStyle(R.style.Theme_Natura_NoActionBar, true)
        }

        return inflater.inflate(R.layout.fragment_natura, container, false)
    }
}

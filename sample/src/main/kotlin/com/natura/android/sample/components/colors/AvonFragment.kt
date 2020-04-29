package com.natura.android.sample.components.colors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natura.android.sample.R

class AvonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        context?.theme?.applyStyle(R.style.Theme_Avon_NoActionBar, true)
        return inflater.inflate(R.layout.fragment_avon, container, false)
    }
}

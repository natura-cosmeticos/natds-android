package com.natura.android.sample.components.colors

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ColorsTabAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val tabTitles = listOf("Natura", "Avon", "TBS")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment {
        return (
        when (position) {
            0 -> NaturaFragment()
            1 -> AvonFragment()
            else -> TheBodyShopFragment()
        })
    }

    override fun getCount(): Int {
        return 3
    }
}

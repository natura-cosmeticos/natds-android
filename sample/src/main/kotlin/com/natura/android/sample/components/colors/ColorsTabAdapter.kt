package com.natura.android.sample.components.colors

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class ColorsTabAdapter(private val darkMode: Boolean, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val tabTitles = listOf("Natura", "Avon", "TBS")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getItem(position: Int): Fragment {
        return (
        when (position) {
            0 -> NaturaFragment(darkMode)
            1 -> AvonFragment(darkMode)
            else -> TheBodyShopFragment(darkMode)
        })
    }

    override fun getCount(): Int {
        return 3
    }
}

/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MenuAdapter(
    fragmentManager: FragmentManager,
    behavior: Int,
    private val menuList: List<Fragment>,
    private val titleList: List<String>
) : FragmentStatePagerAdapter(fragmentManager, behavior) {

    override fun getItem(position: Int): Fragment {
        return menuList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    override fun getCount(): Int {
        return menuList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}
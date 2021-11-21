package com.canonal.jetpacknavigation.util

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.canonal.jetpacknavigation.R

object AnimUtil {
    fun getDefaultSlideNavOption(): NavOptions = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right

        }
    }

}

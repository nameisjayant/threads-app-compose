package com.nameisjayant.threadsapp.bottom_bar

import com.nameisjayant.threadsapp.R


sealed class BottomBarItems(
    val route: String,
    val title: String,
    val icon: Int
) {

    object Home : BottomBarItems(
        "home",
        "Home",
        R.drawable.home
    )

    object Search : BottomBarItems(
        "search",
        "Search",
        R.drawable.search
    )

    object Post : BottomBarItems(
        "post",
        "Post",
        R.drawable.post
    )

    object Notification : BottomBarItems(
        "notification",
        "Notification",
        R.drawable.love
    )

    object Profile : BottomBarItems(
        "profile",
        "Profile",
        R.drawable.person
    )

}
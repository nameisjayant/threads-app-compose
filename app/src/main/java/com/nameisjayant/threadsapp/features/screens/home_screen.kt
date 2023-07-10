package com.nameisjayant.threadsapp.features.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.nameisjayant.threadsapp.R
import com.nameisjayant.threadsapp.ui.theme.Purple40
import com.nameisjayant.threadsapp.ui.theme.Purple80
import com.nameisjayant.threadsapp.utils.noRippleEffect

@Composable
fun HomeScreen() {

    ConstraintLayout(
        decoupledConstraints(),
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo), contentDescription = "",
            modifier = Modifier
                .layoutId(Home.LOGO)
                .size(50.dp),
            tint = Color.Unspecified,
        )
        UserPostEach(modifier = Modifier.layoutId(Home.PARENT_ROW))

    }


}

@Composable
fun UserPostEach(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        decoupledConstraints(),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp),
    ) {
        ProfileIcon(modifier = Modifier.layoutId(Home.ICON)) {}
        ConstraintLayout(
            decoupledConstraints(),
            modifier = Modifier
                .layoutId(Home.POST_LAYOUT)
                .fillMaxWidth()

        ) {
            Text(text = "nameisjayant", modifier = Modifier.layoutId(Home.USERNAME))
            ConstraintLayout(
                decoupledConstraints(),
                modifier = Modifier.layoutId(Home.TIME_LAYOUT)
            ) {
                Text(text = "2 h")
            }
        }
    }
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(Purple80, CircleShape)
            .size(45.dp)
            .noRippleEffect { onClick() },
        contentAlignment = Alignment.BottomEnd
    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "",
            modifier = Modifier.offset(x = 5.dp, y = 5.dp)
        )
    }
}

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val icon = createRefFor(Home.ICON)
        val logo = createRefFor(Home.LOGO)
        val parentRow = createRefFor(Home.PARENT_ROW)
        val postLayout = createRefFor(Home.POST_LAYOUT)
        val username = createRefFor(Home.USERNAME)
        val timeLayout = createRefFor(Home.TIME_LAYOUT)
        val time  = createRefFor(Home.TIME)

        constrain(icon) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }
        constrain(logo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, 20.dp)
        }
        constrain(parentRow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(logo.bottom)
        }
        constrain(postLayout) {
            start.linkTo(icon.end, 10.dp)
            top.linkTo(parent.top)
        }
        constrain(username) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }
        constrain(time){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }

        createHorizontalChain(username, timeLayout, chainStyle = ChainStyle.Spread)

    }
}

private enum class Home {
    ICON,
    PARENT_ROW,
    USERNAME,
    TIME,
    THREE_DOTS,
    TEXT,
    LIKE,
    COMMENT,
    SHARE,
    REPOST,
    REPLIES,
    LIKES,
    ICON_ONE,
    ICON_TWO,
    ICON_THREE,
    H_LINE,
    V_LINE,
    LOGO,
    POST_LAYOUT,
    TIME_LAYOUT,

}
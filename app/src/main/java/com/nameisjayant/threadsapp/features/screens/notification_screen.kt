package com.nameisjayant.threadsapp.features.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.nameisjayant.threadsapp.R

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val activityText = createRefFor(Notification.ACTIVITY_TEXT)
        val chipSelection = createRefFor(Notification.CHIP_SELECTION)

        constrain(activityText) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }
        constrain(chipSelection) {
            top.linkTo(activityText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

private enum class Notification {
    ACTIVITY_TEXT,
    CHIP_SELECTION
}

@Composable
fun NotificationScreen() {

    val chips = listOf("All", "Replies", "Mentions", "Verified")
    var selected by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(decoupledConstraints(), modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.activity),
                modifier = Modifier.layoutId(Notification.ACTIVITY_TEXT),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .horizontalScroll(scrollState)
                    .fillMaxWidth()
                    .layoutId(Notification.CHIP_SELECTION)
            ) {
                chips.forEachIndexed { index, title ->
                    NotificationFilterChip(
                        title = title,
                        selected = index == selected,
                        index = index,
                        onValueChange = {
                            selected = it
                        })
                }
            }
        }

    }
}


@Composable
fun NotificationFilterChip(
    title: String,
    selected: Boolean,
    index: Int,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit
) {

    Button(
        onClick = { onValueChange(index) },
        shape = RoundedCornerShape(10.dp),
        border = if (!selected) BorderStroke(1.dp, Color(0XFFF1F1F1)) else null,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.Black else Color.White,
            contentColor = if (selected) Color.White else Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        modifier = modifier
            .padding(end = 10.dp)
            .width(120.dp),
        contentPadding = PaddingValues(vertical = 0.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W600
            )
        )
    }

}

package com.nameisjayant.threadsapp.features.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nameisjayant.threadsapp.R
import com.nameisjayant.threadsapp.components.SearchViewComponent
import com.nameisjayant.threadsapp.ui.theme.Purple40
import com.nameisjayant.threadsapp.ui.theme.gray_color


@Composable
fun SearchScreen() {

    var search by remember { mutableStateOf("") }
    val state = rememberLazyListState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            val (searchText, searchView, profile) = createRefs()
            Text(
                text = stringResource(id = R.string.search), style = TextStyle(
                    color = Color.Black,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.constrainAs(searchText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(searchView.top)
                })
            SearchViewComponent(
                search = search,
                modifier = Modifier
                    .constrainAs(searchView) {
                        start.linkTo(parent.start)
                        top.linkTo(searchText.bottom, 12.dp)
                        end.linkTo(parent.end)
                    }) {
                search = it
            }
            LazyColumn(
                modifier = Modifier.constrainAs(profile) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(searchView.bottom)
                },
                state = state
            ) {
                items(10) {
                    SearchProfileLayout()
                }
            }
        }
    }
}

@Composable
fun SearchProfileLayout(
    modifier: Modifier = Modifier
) {

    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
    ) {
        val (icon, username, name, followers, followButton, line, userComponent) = createRefs()

        Box(
            modifier = Modifier
                .background(Purple40, CircleShape)
                .size(40.dp)
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

        ConstraintLayout(
            modifier = Modifier.constrainAs(userComponent) {
                start.linkTo(icon.end, 15.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Text(text = "nameisjayant", style = TextStyle(
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.W600
            ), modifier = Modifier.constrainAs(username) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(name.top)
            })
            Text(text = "Jayant", style = TextStyle(
                color = Color.Gray,
                fontSize = 19.sp,
                fontWeight = FontWeight.W400
            ), modifier = Modifier.constrainAs(name) {
                start.linkTo(parent.start)
                top.linkTo(username.bottom)
                bottom.linkTo(followers.top)
            })
            Text(
                text = "512 Followers",
                color = Color.Black,
                modifier = Modifier.constrainAs(followers) {
                    start.linkTo(parent.start)
                    top.linkTo(name.bottom, 10.dp)
                    bottom.linkTo(parent.top)
                })
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(line) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(followers.bottom, 16.dp)
                    }, thickness = 0.4.dp
            )
        }

        FollowButton(
            modifier = Modifier.constrainAs(followButton) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        )
    }

}


@Composable
fun FollowButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    TextButton(
        onClick = onClick,
        border = BorderStroke(1.dp, gray_color),
        modifier = modifier
            .width(120.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(vertical = 0.dp)
    ) {
        Text(
            text = stringResource(R.string.follow), style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W500

            )
        )
    }

}
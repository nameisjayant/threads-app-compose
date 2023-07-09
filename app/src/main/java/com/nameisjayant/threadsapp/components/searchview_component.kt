package com.nameisjayant.threadsapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.nameisjayant.threadsapp.R


@Composable
fun SearchViewComponent(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {

    BasicTextField(
        value = search,
        onValueChange = onValueChange,
        modifier = modifier.height(40.dp),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        decorationBox = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0XFFF1F1F1), RoundedCornerShape(8.dp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(CenterStart)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search), contentDescription = "",
                        modifier = Modifier
                            .size(20.dp),
                        tint = Color.Gray
                    )
                    Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                        if (search.isEmpty()) {
                            Text(
                                text = stringResource(R.string.search),
                            )
                        }
                        it.invoke()
                    }
                }
            }


        }
    )

}
package com.nameisjayant.threadsapp.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.constraintlayout.compose.ConstrainScope


@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.noRippleEffect(crossinline onClick: () -> Unit) = composed {
    clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        onClick()
    }
}

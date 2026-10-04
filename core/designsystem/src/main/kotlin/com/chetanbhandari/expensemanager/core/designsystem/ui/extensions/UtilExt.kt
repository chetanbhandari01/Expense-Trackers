package com.chetanbhandari.expensemanager.core.designsystem.ui.extensions

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

fun String.toColor(): Color = Color(this.toColorInt())

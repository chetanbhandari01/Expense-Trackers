package com.chetanbhandari.expensemanager.core.designsystem.ui.extensions

import android.annotation.SuppressLint
import android.content.Context
import com.chetanbhandari.expensemanager.core.designsystem.R

@SuppressLint("DiscouragedApi")
fun Context.getDrawable(iconName: String): Int = runCatching {
    val resources = this.resources.getIdentifier(
        iconName,
        "drawable",
        this.packageName,
    )

    if (resources > 0) resources else null
}.getOrNull() ?: R.drawable.account_balance

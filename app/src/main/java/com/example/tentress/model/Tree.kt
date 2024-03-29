package com.example.tentress.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tree(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
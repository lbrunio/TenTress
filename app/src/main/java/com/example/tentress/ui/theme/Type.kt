package com.example.tentress.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tentress.R


val PtSerif = FontFamily(
        Font(R.font.ptserif_regular)
)

val RobotoSlab = FontFamily(
        Font(R.font.robotoslab_regular)
)



object Type {
        val ptserif: TextStyle = TextStyle(
                fontFamily = RobotoSlab,
                fontSize = 16.sp
        )
        val roboto: TextStyle = TextStyle(
                fontFamily = RobotoSlab,
                fontSize = 14.sp
        )


}

package com.example.testcomposaapplication.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testcomposaapplication.ui.theme.fonts.*

@Immutable
class DesignSystemTypography(
    val promo: Promo,
    val h1: H1,
    val h2: H2,
    val h3: H3,
    val p1: P1,
    val p2: P2,
    val p3: P3,
) {
    constructor(
        defaultFontFamily: FontFamily = MTSRegular,
        promoSet: Promo = Promo(
            TextStyle(
                fontWeight = FontWeight(1000),
                fontSize = 44.sp,
                lineHeight = 44.sp,
                fontFamily = MTSPromo
            )
        ),
        h1Set: H1 = H1(
            black = TextStyle(
                fontWeight = FontWeight.Black,
                fontSize = 32.sp,
                lineHeight = 36.sp,
                fontFamily = MTSBlack
            ),
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 36.sp,
                fontFamily = MTSBold
            )
        ),
        h2Set: H2 = H2(
            black = TextStyle(
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontFamily = MTSBlack
            ),
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontFamily = MTSBold
            ),
            medium = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontFamily = MTSMedium
            )
        ),
        h3Set: H3 = H3(
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontFamily = MTSBold
            ),
            medium = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontFamily = MTSMedium
            ),
            regular = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontFamily = MTSRegular
            )
        ),
        p1Set: P1 = P1(
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                lineHeight = 24.sp,
                fontFamily = MTSBold
            ),
            medium = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                lineHeight = 24.sp,
                fontFamily = MTSMedium
            ),
            regular = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                lineHeight = 24.sp,
                fontFamily = MTSRegular
            )
        ),
        p2Set: P2 = P2(
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = MTSBold
            ),
            medium = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = MTSMedium
            ),
            regular = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = MTSRegular
            ),
            mediumUppercase = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = MTSMedium
            )
        ),
        p3Set: P3 = P3(
            bold = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = MTSBold
            ),
            medium = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = MTSMedium
            ),
            regular = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = MTSRegular
            ),
            mediumUppercase = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = MTSMedium
            )
        ),
    ) : this(
        promo = promoSet,
        h1 = h1Set,
        h2 = h2Set,
        h3 = h3Set,
        p1 = p1Set,
        p2 = p2Set,
        p3 = p3Set,
    )
}
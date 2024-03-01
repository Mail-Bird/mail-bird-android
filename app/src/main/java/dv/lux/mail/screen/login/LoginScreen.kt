package dv.lux.mail.screen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dv.lux.mail.R
import dv.lux.mail.ui.theme.AppTypography

@Composable
fun LoginScreen(
    onClickTermsOfUse: () -> Unit,
) {
    Box(modifier = with(Modifier) {
        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.colorful_mountain_1),
                contentScale = ContentScale.FillBounds
            )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.weight(2.0f))
                Button(onClick = {
                    // TODO: Login
                }) {
                    Text(text = "Login with Outlook")
                }
                Spacer(modifier = Modifier.weight(1.0f))
                TermOfUseSpannableText(onClickTermsOfUse = onClickTermsOfUse)
            }
        }
    }
}

@Composable
fun TermOfUseSpannableText(
    onClickTermsOfUse: () -> Unit,
) {
    val annotatedString = buildAnnotatedString {
        append("By signing in you agree to our ")

        pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")
        withStyle(
            style = AppTypography.bodySmall.toSpanStyle()
                .copy(
                    color = colorResource(id = R.color.purple_700),
                    fontWeight = FontWeight.Bold
                )
        ) {
            append("Terms of Use")
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        style = AppTypography.bodySmall.copy(color = colorResource(id = R.color.black)),
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset)
                .firstOrNull()?.let {
                    onClickTermsOfUse()
                }
        },
        modifier = Modifier.padding(vertical = 8.dp)
    )

}
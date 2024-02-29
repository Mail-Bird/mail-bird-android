package dv.lux.mail.screen.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import dv.lux.mail.R
import dv.lux.mail.ui.theme.AppTypography

@Composable
fun SettingScreen() {
    Column(horizontalAlignment = Alignment.Start) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Login",
                style = AppTypography.titleMedium
            )
        }
        Divider(
            color = colorResource(id = R.color.divider),
            thickness = 0.5.dp,
            modifier = Modifier.padding(horizontal = 20.dp),
        )
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                style = AppTypography.bodyMedium,
            )
        }
    }
}
package dv.lux.mail.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dv.lux.mail.component.TopNavigation
import dv.lux.mail.ui.theme.AppTypography

@Composable
fun HomeScreen(
    onOpenProfile: () -> Unit
) {
    Column(horizontalAlignment = Alignment.Start) {
        TopNavigation(onOpenProfile = onOpenProfile)
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                style = AppTypography.bodyMedium,
            )
        }
    }
}
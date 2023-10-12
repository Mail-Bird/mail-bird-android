package dv.lux.mail.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dv.lux.mail.R
import dv.lux.mail.ui.theme.AppTypography
import dv.lux.mail.ui.theme.MailTheme


@Composable
fun TopNavigation(modifier: Modifier = Modifier) {
    Column {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.cd_home_menu),
                    modifier = Modifier.padding(10.dp)
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.cd_search_menu),
                    modifier = Modifier.padding(10.dp)
                )
            }
            Text(
                text = "Inbox",
                modifier = modifier,
                style = AppTypography.titleMedium
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = "https://sm.ign.com/ign_nordic/cover/a/avatar-gen/avatar-generations_prsz.jpg",
                    contentDescription = stringResource(id = R.string.cd_avatar),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(size = 30.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.navigation_avatar_border),
                            shape = CircleShape
                        )
                )
            }
        }
        Divider(
            color = colorResource(id = R.color.divider),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopNavigationPreview() {
    MailTheme {
        TopNavigation()
    }
}
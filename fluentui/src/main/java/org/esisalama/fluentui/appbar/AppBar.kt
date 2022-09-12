package org.esisalama.fluentui.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.esisalama.fluentui.R
import org.esisalama.fluentui.avatar.Avatar
import org.esisalama.fluentui.avatar.AvatarBorderStyle
import org.esisalama.fluentui.avatar.AvatarSize
import org.esisalama.fluentui.theme.FluentUi

@Composable
fun AppBar(
    avatarSection: @Composable () -> Unit,
    titleSection: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    backgroundColor: Color = Color(0xFF0078D4)
) {

    Surface(color = backgroundColor) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                avatarSection()
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.wrapContentSize()) {
                    titleSection()
                }
            }

            Row(modifier = Modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically) {
                actions()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar(
        avatarSection = {
            Avatar(
                name = "Eliezer",
                email = "eliezer@esisalama.org",
                avatarImageResourceId = R.drawable.avatar,
                modifier = Modifier.padding(8.dp),
                avatarSize = AvatarSize.MEDIUM,
                avatarBorderStyle = AvatarBorderStyle.NO_BORDER
            )            
        },
        titleSection = {
            Text(text = "Titre", style = FluentUi.typography.title1.copy(color = Color.White))
            Text(text = "Sous titre", style = FluentUi.typography.subheading1.copy(color = Color.White))
        },
        actions = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.White)
        }
    )
}
package org.esisalama.fluentui.avatar

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import org.esisalama.fluentui.databinding.AvatarBinding
import com.microsoft.fluentui.persona.AvatarBorderStyle as MAvatarBorderStyle
import com.microsoft.fluentui.persona.AvatarSize as MAvatarSize
import com.microsoft.fluentui.persona.AvatarStyle as MAvatarStyle

enum class AvatarSize(private val id: Int) {
    XSMALL(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_xsmall),
    SMALL(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_small),
    MEDIUM(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_medium),
    LARGE(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_large),
    XLARGE(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_xlarge),
    XXLARGE(com.microsoft.fluentui.R.dimen.fluentui_avatar_size_xxlarge);

    /**
     * This method uses [context] to convert the [id] resource into an int that becomes
     * AvatarView's layout width and height
     */
    internal fun getDisplayValue(context: Context): Int {
        return context.resources.getDimension(id).toInt()
    }
}

enum class AvatarStyle {
    CIRCLE, SQUARE
}

enum class AvatarBorderStyle {
    NO_BORDER, RING
}

internal fun AvatarSize.toMicrosoftAvatarSize(): MAvatarSize {
    return when {
        this == AvatarSize.XSMALL -> MAvatarSize.XSMALL
        this == AvatarSize.SMALL -> MAvatarSize.SMALL
        this == AvatarSize.MEDIUM -> MAvatarSize.MEDIUM
        this == AvatarSize.LARGE -> MAvatarSize.LARGE
        this == AvatarSize.XLARGE -> MAvatarSize.XLARGE
        this == AvatarSize.XXLARGE -> MAvatarSize.XXLARGE
        else -> MAvatarSize.SMALL
    }
}

internal fun AvatarStyle.toMicrosoftAvatarStyle(): MAvatarStyle {
    return when {
        this == AvatarStyle.SQUARE -> MAvatarStyle.SQUARE
        this == AvatarStyle.CIRCLE -> MAvatarStyle.CIRCLE
        else -> MAvatarStyle.CIRCLE
    }
}

internal fun AvatarBorderStyle.toMicrosoftAvatarBorderStyle(): MAvatarBorderStyle {
    return when {
        this == AvatarBorderStyle.RING -> MAvatarBorderStyle.RING
        this == AvatarBorderStyle.NO_BORDER -> MAvatarBorderStyle.NO_BORDER
        else -> MAvatarBorderStyle.NO_BORDER
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    name: String,
    email: String,
    avatarImageBitmap: Bitmap? = null,
    avatarImageDrawable: Drawable? = null,
    avatarImageResourceId: Int? = null,
    avatarImageUri: Uri? = null,
    avatarSize: AvatarSize = AvatarSize.XXLARGE,
    avatarStyle: AvatarStyle = AvatarStyle.CIRCLE,
    avatarBorderStyle: AvatarBorderStyle = AvatarBorderStyle.RING,
    avatarBackgroundColor: Int? = null,
    avatarIsOverFlow: Boolean = false,
) {
    AndroidViewBinding(
        factory = AvatarBinding::inflate, modifier = modifier
    ) {
        view.apply {
            this.name = name
            this.email = email
            this.avatarImageBitmap = avatarImageBitmap
            this.avatarImageDrawable = avatarImageDrawable
            this.avatarImageResourceId = avatarImageResourceId
            this.avatarImageUri = avatarImageUri
            this.avatarBackgroundColor = avatarBackgroundColor
            this.avatarSize = avatarSize.toMicrosoftAvatarSize()
            this.avatarStyle = avatarStyle.toMicrosoftAvatarStyle()
            this.avatarBorderStyle = avatarBorderStyle.toMicrosoftAvatarBorderStyle()
            this.avatarIsOverFlow = avatarIsOverFlow
        }
    }
}
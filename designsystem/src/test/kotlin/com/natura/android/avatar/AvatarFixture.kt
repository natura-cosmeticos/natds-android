package com.natura.android.avatar

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class AvatarFixture private constructor(
    private var type: Int? = null,
    private var size: Int? = null,
    private var icon: Int? = null,
    private var fallbackIcon: Int? = null,
    private var image: Int? = null,
    private var label: String? = null,
    private var fallbackLabel: String? = null,
    private var url: String? = null,
    private var contentDescription: String? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val ICON_TYPE = 0
        private const val LABEL_TYPE = 1
        private const val IMAGE_TYPE = 2

        private const val STANDARD_SIZE = 0
        private const val SEMI_SIZE = 1
        private const val SEMIX_SIZE = 2
        private const val MEDIUM_SIZE = 3
        private const val LARGEXXX_SIZE = 4

        private const val defaultType = ICON_TYPE
        private const val defaultSize = MEDIUM_SIZE
        private const val defaultLabel = "Design System"
        private const val defaultFallbackLabel = "Default Fallback"
        private const val defaultUrl = "Default Url"
        private const val defaultContentDescription = "Default Description"
        private const val defaultIcon = 1
        private const val defaultFallbackIcon = 1
        private const val defaultImage = 1

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aAvatar(): AvatarFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return AvatarFixture(
                defaultType, defaultSize, defaultIcon, defaultFallbackIcon, defaultImage,
                defaultLabel, defaultFallbackLabel, defaultUrl, defaultContentDescription, context
            )
        }
    }

    fun withStandardSize(): AvatarFixture {
        this.size = STANDARD_SIZE
        return this
    }

    fun withSemiSize(): AvatarFixture {
        this.size = SEMI_SIZE
        return this
    }

    fun withSemixSize(): AvatarFixture {
        this.size = SEMIX_SIZE
        return this
    }

    fun withMediumSize(): AvatarFixture {
        this.size = MEDIUM_SIZE
        return this
    }

    fun withLargexxxSize(): AvatarFixture {
        this.size = LARGEXXX_SIZE
        return this
    }

    fun build(): GaYaAvatar {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.avt_type, type.toString())
            .addAttribute(R.attr.avt_icon, icon.toString())
            .addAttribute(R.attr.avt_image, image.toString())
            .addAttribute(R.attr.avt_fallback_icon, fallbackIcon.toString())
            .addAttribute(R.attr.avt_label, label.toString())
            .addAttribute(R.attr.avt_fallback_label, fallbackLabel.toString())
            .addAttribute(R.attr.avt_size, size.toString())
            .addAttribute(R.attr.avt_image_url, url.toString())
            .addAttribute(R.attr.avt_content_description, contentDescription.toString())
            .build()

        return GaYaAvatar(context, attributes)
    }
}

package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.natura.android.avatar.GaYaAvatar
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityAvatarBinding
import com.natura.android.sample.setChosenDefaultTheme

class AvatarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAvatarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityAvatarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Avatar"

        val iconContainer: LinearLayout = findViewById(R.id.icon_avatar_container)
        val labelContainer: LinearLayout = findViewById(R.id.label_avatar_container)
        val imageContainer: LinearLayout = findViewById(R.id.image_avatar_container)

        GaYaAvatar.AvatarSize.values().forEach { size ->
            val iconAvatar = GaYaAvatar(this, avatarSize = size, avatarType = GaYaAvatar.AvatarType.ICON)
            iconAvatar.icon("outlined-default-mockup")
            iconContainer.addView(iconAvatar)
        }

        GaYaAvatar.AvatarSize.values().forEach { size ->
            val textAvatar = GaYaAvatar(this, avatarSize = size, avatarType = GaYaAvatar.AvatarType.LABEL)
            textAvatar.setText("Gaya DS")
            labelContainer.addView(textAvatar)
        }

        GaYaAvatar.AvatarSize.values().forEach { size ->
            val imageAvatar = GaYaAvatar(this, avatarSize = size, avatarType = GaYaAvatar.AvatarType.IMAGE)
            imageAvatar.setImage(ContextCompat.getDrawable(this, R.mipmap.nat_avatar)!!)
            imageContainer.addView(imageAvatar)
        }

    }

}

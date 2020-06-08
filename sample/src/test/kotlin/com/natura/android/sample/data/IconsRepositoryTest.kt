package com.natura.android.sample.data

import android.R.drawable
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.tokens.icons.DrawableActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.reflect.Field


@RunWith(AndroidJUnit4::class)
class IconsRepositoryTest {

    lateinit var iconsRepository: IconsRepository
    lateinit var iconsDrawableActivityActivityScenario: ActivityScenario<DrawableActivity>

    @Before
    fun setUp() {
        iconsRepository = IconsRepository(ApplicationProvider.getApplicationContext())
        iconsDrawableActivityActivityScenario = ActivityScenario.launch(DrawableActivity::class.java)
    }

    @Test
    fun checksIfIconsListHasTheRightSize() {
        iconsDrawableActivityActivityScenario.onActivity {
            val drawables: Array<Field> = drawable::class.java.fields

            val drawableResources: ArrayList<Drawable> = ArrayList()

            for (field in drawables) {
                drawableResources.add(it.resources.getDrawable(field.getInt(null), null))
            }

            val qteDrawables = drawableResources.size
        }


    }
}
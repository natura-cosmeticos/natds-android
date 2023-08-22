package com.natura.android.sample

import androidx.cardview.widget.CardView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.BrandSelectorActivity.Companion.AESOP
import com.natura.android.sample.BrandSelectorActivity.Companion.AVON
import com.natura.android.sample.BrandSelectorActivity.Companion.NATURA
import com.natura.android.sample.BrandSelectorActivity.Companion.TBS
import com.natura.android.sample.data.ThemeRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BrandSelectorActivityTest {

    @MockK
    private lateinit var themeRepository: ThemeRepository
    private lateinit var brandSelectorActivityScenario: ActivityScenario<BrandSelectorActivity>

    @Before
    fun setUp() {
        MockKAnnotations.init(this, true)
        every { themeRepository.saveChosenTheme(any()) } returns Unit

        Intents.init()

        brandSelectorActivityScenario = ActivityScenario.launch(BrandSelectorActivity::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checksIfMainActivityIsOpenedWhenClickAtAesopButton() {
        brandSelectorActivityScenario.onActivity { brandSelectorActivity ->
            brandSelectorActivity.findViewById<CardView>(R.id.aesopThemeButton).performClick()

            intended(hasComponent(MainActivity::class.java.name))
        }
    }
}

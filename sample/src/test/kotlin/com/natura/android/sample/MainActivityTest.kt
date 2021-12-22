package com.natura.android.sample

import android.widget.Button
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.components.BadgeActivity
import com.natura.android.sample.components.ButtonActivity
import com.natura.android.sample.components.CheckBoxActivity
import com.natura.android.sample.components.DialogActivity
import com.natura.android.sample.components.ExpandableNavigationViewActivity
import com.natura.android.sample.components.MenuActivity
import com.natura.android.sample.patterns.ErrorActivity
import com.natura.android.sample.components.ProgressIndicatorActivity
import com.natura.android.sample.components.ShortcutActivity
import com.natura.android.sample.components.SubmenuActivity
import com.natura.android.sample.components.TagActivity
import com.natura.android.sample.components.TextFieldActivity
import com.natura.android.sample.components.ValueTextHighlightActivity
import com.natura.android.sample.patterns.LogoActivity
import com.natura.android.sample.tokens.BorderRadiusActivity
import com.natura.android.sample.tokens.ColorsActivity
import com.natura.android.sample.tokens.ElevationActivity
import com.natura.android.sample.tokens.OpacityActivity
import com.natura.android.sample.tokens.SizeActivity
import com.natura.android.sample.tokens.SpacingActivity
import com.natura.android.sample.tokens.TypographyActivity
import com.natura.android.sample.tokens.icons.DrawableActivity
import com.natura.android.sample.tokens.icons.IconActivity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowActivity

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity
    private lateinit var shadowActivity: ShadowActivity

    @Before
    fun setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        shadowActivity = shadowOf(mainActivity)
    }

    @Test
    fun checksIconDrawableButtonClickStartsIconsDrawableScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnIconsDrawables)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(DrawableActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksOpacityButtonClickStartsOpacityScreen() {
        val button = mainActivity.findViewById<Button>(R.id.opacityTokensButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(OpacityActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksAppBarButtonClickStartsAppBarScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnAppBarTop)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(AppBarTopAttributesActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksTextFieldButtonClickStartsTextFieldScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnTextfield)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(TextFieldActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksInputTextFieldHightLightButtonClickStartsInputTextFieldHighlightScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnValueTextHighlight)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ValueTextHighlightActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksSelectionButtonClickStartsSelectionScreen() {
        val button = mainActivity.findViewById<Button>(R.id.checkboxButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(CheckBoxActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksStyleButtonsButtonClickStartsSelectionScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnStyleButtons)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ButtonActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksSubMenuButtonClickStartsSelectionScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnSubmenu)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(SubmenuActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksNavigationDrawerButtonClickStartsNavigationDrawerScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnNavigationDrawer)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ExpandableNavigationViewActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksMenuDrawerButtonClickStartsMenuScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnMenu)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(MenuActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksProgressIndicatorButtonClickStartsProgressIndicatorScreen() {
        val button = mainActivity.findViewById<Button>(R.id.progressIndicatorButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ProgressIndicatorActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksErrorButtonClickStartsErrorScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnErrorDefault)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ErrorActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksColorButtonClickStartsColorScreen() {
        val button = mainActivity.findViewById<Button>(R.id.colorTokensButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ColorsActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksSizeButtonClickStartsSizerScreen() {
        val button = mainActivity.findViewById<Button>(R.id.sizeButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(SizeActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksSpacingButtonClickStartsSpacingScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnSpacing)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(SpacingActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksBorderRadiusButtonClickStartsBorderRadiusScreen() {
        val button = mainActivity.findViewById<Button>(R.id.borderRadiusButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(BorderRadiusActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksElevationButtonClickStartsElevationScreen() {
        val button = mainActivity.findViewById<Button>(R.id.elevationTokensButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ElevationActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksTypographyButtonClickStartsTypographyScreen() {
        val button = mainActivity.findViewById<Button>(R.id.typographyButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(TypographyActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksShortcutyButtonClickStartsShortcutScreen() {
        val button = mainActivity.findViewById<Button>(R.id.shortcutButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(ShortcutActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksTagButtonClickStartsTagScreen() {
        val button = mainActivity.findViewById<Button>(R.id.tagButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(TagActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksDialogButtonClickStartsDialogScreen() {
        val button = mainActivity.findViewById<Button>(R.id.dialogButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(DialogActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksLogoPatternButtonClickStartsLogoPatternScreen() {
        val button = mainActivity.findViewById<Button>(R.id.logoButton)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(LogoActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksBadgeButtonClickStartsBadgeScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnBadge)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(BadgeActivity::class.java, shadowIntent.intentClass)
    }
}

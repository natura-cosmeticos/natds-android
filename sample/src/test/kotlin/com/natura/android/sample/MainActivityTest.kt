package com.natura.android.sample

import android.widget.Button
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.components.AppBarActivity
import com.natura.android.sample.tokens.DrawableActivity
import com.natura.android.sample.components.ErrorActivity
import com.natura.android.sample.components.ExpandableNavigationViewActivity
import com.natura.android.sample.tokens.IconActivity
import com.natura.android.sample.components.LoadingActivity
import com.natura.android.sample.components.MenuActivity
import com.natura.android.sample.components.SelectionControlActivity
import com.natura.android.sample.components.StyleButtonActivity
import com.natura.android.sample.components.SubmenuActivity
import com.natura.android.sample.components.TextFieldActivity
import com.natura.android.sample.components.ValueTextHighlightActivity
import com.natura.android.sample.tokens.SpacingActivity
import com.natura.android.sample.tokens.ColorsActivity
import com.natura.android.sample.tokens.SizeActivity
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
    fun checksIconFontsButtonClickStartsIconsFontsScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnIconsFont)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(IconActivity::class.java, shadowIntent.intentClass)
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
    fun checksAppBarButtonClickStartsAppBarScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnAppbar)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(AppBarActivity::class.java, shadowIntent.intentClass)
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
        val button = mainActivity.findViewById<Button>(R.id.btnSelection)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(SelectionControlActivity::class.java, shadowIntent.intentClass)
    }

    @Test
    fun checksStyleButtonsButtonClickStartsSelectionScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnStyleButtons)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(StyleButtonActivity::class.java, shadowIntent.intentClass)
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
    fun checksLoadingButtonClickStartsLoadingScreen() {
        val button = mainActivity.findViewById<Button>(R.id.btnLoader)

        button.performClick()
        val startedIntent = shadowActivity.peekNextStartedActivity()
        val shadowIntent = shadowOf(startedIntent)

        assertEquals(LoadingActivity::class.java, shadowIntent.intentClass)
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
}

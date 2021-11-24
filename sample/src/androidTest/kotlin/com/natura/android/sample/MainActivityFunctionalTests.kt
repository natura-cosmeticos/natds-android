package com.natura.android.sample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityFunctionalTests {
    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun shouldOpenBorderRadiusScreenWhenTapOnItButton() {
        onView(withId(R.id.borderRadiusButton)).perform(scrollTo())
        onView(withId(R.id.borderRadiusButton)).perform(click())

        onView(withText("Border Radius")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenColorScreenWhenTapOnItButton() {
        onView(withId(R.id.colorTokensButton)).perform(click())

        onView(withText(containsString("Colors"))).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenElevationScreenWhenTapOnItButton() {
        onView(withId(R.id.elevationTokensButton)).perform(scrollTo())
        onView(withId(R.id.elevationTokensButton)).perform(click())

        onView(withText("Elevation")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenIconDrawableScreenWhenTapOnItButton() {
        onView(withId(R.id.btnIconsDrawables)).perform(scrollTo())
        onView(withId(R.id.btnIconsDrawables)).perform(click())

        onView(withText("Icons (drawables)")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenIconFontsScreenWhenTapOnItButton() {
        onView(withId(R.id.btnIconsFont)).perform(scrollTo())
        onView(withId(R.id.btnIconsFont)).perform(click())

        onView(withText("Icons (fonts)")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenOpacityScreenWhenTapOnItButton() {
        onView(withId(R.id.opacityTokensButton)).perform(scrollTo())
        onView(withId(R.id.opacityTokensButton)).perform(click())

        onView(withText("Opacity")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenSizeScreenWhenTapOnItButton() {
        onView(withId(R.id.sizeButton)).perform(scrollTo())
        onView(withId(R.id.sizeButton)).perform(click())

        onView(withText("Size")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenSpacingScreenWhenTapOnItButton() {
        onView(withId(R.id.btnSpacing)).perform(scrollTo())
        onView(withId(R.id.btnSpacing)).perform(click())

        onView(withText("Spacing")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenTypographyScreenWhenTapOnItButton() {
        onView(withId(R.id.typographyButton)).perform(scrollTo())
        onView(withId(R.id.typographyButton)).perform(click())

        onView(withText("Typography")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenAppBarTopScreenWhenTapOnItButton() {
        onView(withId(R.id.btnAppBarTop)).perform(scrollTo())
        onView(withId(R.id.btnAppBarTop)).perform(click())

        onView(withId(R.id.btnActionButton)).check(matches(isDisplayed()))

        onView(withId(R.id.btnActionButton)).perform(click())

        onView(withId(R.id.buttonActionViewIconButtonActionRight)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenButtonScreenWhenTapOnItButton() {
        onView(withId(R.id.btnStyleButtons)).perform(scrollTo())
        onView(withId(R.id.btnStyleButtons)).perform(click())

        onView(withText("Button")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenDialogScreenWhenTapOnItButton() {
        onView(withId(R.id.dialogButton)).perform(scrollTo())
        onView(withId(R.id.dialogButton)).perform(click())

        onView(ViewMatchers.withText("Dialog")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenExpansionPanelScreenWhenTapOnItButton() {
        onView(withId(R.id.btnExpansionPanel)).perform(scrollTo())
        onView(withId(R.id.btnExpansionPanel)).perform(click())

        onView(allOf(ViewMatchers.withText("Expansion Panel"), withParent(withResourceName("action_bar"))))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenCheckBoxScreenWhenTapOnItButton() {
        onView(withId(R.id.checkboxButton)).perform(scrollTo())
        onView(withId(R.id.checkboxButton)).perform(click())

        onView(withText("Checkbox")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenRadioButtonScreenWhenTapOnItButton() {
        onView(withId(R.id.radioButtonButton)).perform(scrollTo())
        onView(withId(R.id.radioButtonButton)).perform(click())

        onView(withText("RadioButton")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenShortcutScreenWhenTapOnItButton() {
        onView(withId(R.id.shortcutButton)).perform(scrollTo())
        onView(withId(R.id.shortcutButton)).perform(closeSoftKeyboard())
        onView(withId(R.id.shortcutButton)).perform(click())

        onView(withText("Shortcut")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenTagScreenWhenTapOnItButton() {
        onView(withId(R.id.tagButton)).perform(scrollTo())
        onView(withId(R.id.tagButton)).perform(click())

        onView(withText("Tag")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenTextFieldScreenWhenTapOnItButton() {
        onView(withId(R.id.btnTextfield)).perform(scrollTo())
        onView(withId(R.id.btnTextfield)).perform(click())

        onView(withText("Text Field")).check(matches(isDisplayed()))
    }

    @Test @Ignore
    fun shouldOpenValueTextHighlightScreenWhenTapOnItButton() {
        onView(withId(R.id.btnValueTextHighlight)).perform(scrollTo())
        onView(withId(R.id.btnValueTextHighlight)).perform(click())

        onView(withText("Value Text Highlight")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenMenuScreenWhenTapOnItButton() {
        onView(withId(R.id.btnMenu)).perform(scrollTo())
        onView(withId(R.id.btnMenu)).perform(click())

        onView(withText("Menu Pattern")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenSubmenuScreenWhenTapOnItButton() {
        onView(withId(R.id.btnSubmenu)).perform(scrollTo())
        onView(withId(R.id.btnSubmenu)).perform(click())

        onView(withText("Submenu Pattern")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenNavigationDrawerScreenWhenTapOnItButton() {
        onView(withId(R.id.btnNavigationDrawer)).perform(scrollTo())
        onView(withId(R.id.btnNavigationDrawer)).perform(click())

        onView(withText("Navigation Drawer")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenProgressIndicatorScreenWhenTapOnItButton() {
        onView(withId(R.id.progressIndicatorButton)).perform(scrollTo())
        onView(withId(R.id.progressIndicatorButton)).perform(click())

        onView(withText("Progress Indicator")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenErrorScreenWhenTapOnItButton() {
        onView(withId(R.id.btnErrorDefault)).perform(scrollTo())
        onView(withId(R.id.btnErrorDefault)).perform(click())

        onView(withText("Error Pattern")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenLogoScreenWhenTapOnItButton() {
        onView(withId(R.id.logoButton)).perform(scrollTo())
        onView(withId(R.id.logoButton)).perform(click())

        onView(withText("Logo")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenBadgeScreenWhenTapOnItButton() {
        onView(withId(R.id.btnBadge)).perform(scrollTo())
        onView(withId(R.id.btnBadge)).perform(click())

        onView(withText("Badge")).check(matches(isDisplayed()))
    }
}

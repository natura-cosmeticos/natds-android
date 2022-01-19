package com.natura.android.sample.tokens

import androidx.cardview.widget.CardView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OpacityActivityTest {

    private lateinit var opacityActivityScenario: ActivityScenario<OpacityActivity>

    @Before
    fun setUp() {
        opacityActivityScenario = ActivityScenario.launch(OpacityActivity::class.java)
    }

    @Test
    fun checksOpacity0Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacityTransparentCardView).alpha

            assertEquals(0.0F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity1Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity1CardView).alpha

            assertEquals(0.04F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity2Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity2CardView).alpha

            assertEquals(0.08F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity3Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity3CardView).alpha

            assertEquals(0.12F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity4Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity4CardView).alpha

            assertEquals(0.16F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity5Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity5CardView).alpha

            assertEquals(0.24F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity6Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity6CardView).alpha

            assertEquals(0.32F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity7Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity7CardView).alpha

            assertEquals(0.48F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity8Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity8CardView).alpha

            assertEquals(0.56F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity9Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity9CardView).alpha

            assertEquals(0.64F, cardOpacity)
        }
    }

    @Test
    fun checksOpacity10Value() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacity10CardView).alpha

            assertEquals(0.8F, cardOpacity)
        }
    }

    @Test
    fun checksOpacityFullValue() {
        opacityActivityScenario.onActivity {
            val cardOpacity = it.findViewById<CardView>(R.id.opacityFullCardView).alpha

            assertEquals(1.0F, cardOpacity)
        }
    }
}

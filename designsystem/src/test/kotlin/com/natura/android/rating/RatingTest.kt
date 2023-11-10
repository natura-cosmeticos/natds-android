package com.natura.android.rating

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.rating.RatingDSL.align
import com.natura.android.rating.RatingDSL.hint
import com.natura.android.rating.RatingDSL.isEnabled
import com.natura.android.rating.RatingDSL.rate
import com.natura.android.rating.RatingDSL.rating
import com.natura.android.rating.RatingDSL.ratingAttributes
import com.natura.android.rating.RatingDSL.size
import com.natura.android.rating.RatingDSL.variant
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RatingTest {

    private lateinit var rating: Rating

    @Test
    fun checkIfRatingVariantWasSet() {
        val expected = Rating.Variant.READ_ONLY
        rating = rating(
            ratingAttributes {
                variant(expected)
            }
        )

        assertEquals(expected, rating.variant)
    }

    @Test
    fun checkIfRatingRateWasSet() {
        val expected = 3
        rating = rating(
            ratingAttributes {
                rate(expected)
            }
        )

        assertEquals(expected, rating.rate)
    }

    @Test
    fun checkIfRatingHintWasSet() {
        val expected = "hint"
        rating = rating(
            ratingAttributes {
                hint(expected)
            }
        )

        assertEquals(expected, rating.hint)
    }

    @Test
    fun checkIfRatingSizeWasSet() {
        val expected = Rating.Size.SMALL
        rating = rating(
            ratingAttributes {
                // Rating.Size.SMALL is not supported on default variant (Rating.Variant.Input)
                variant(Rating.Variant.READ_ONLY)
                size(expected)
            }
        )

        assertEquals(expected, rating.size)
    }

    @Test
    fun checkIfRatingAlignWasSet() {
        val expected = Rating.Align.RIGHT
        rating = rating(
            ratingAttributes {
                align(expected)
            }
        )

        assertEquals(expected, rating.align)
    }

    @Test
    fun checkIfRatingIsEnabledWasSet() {
        val expected = false
        rating = rating(
            ratingAttributes {
                isEnabled(expected)
            }
        )

        assertEquals(expected, rating.isEnabled)
    }
}
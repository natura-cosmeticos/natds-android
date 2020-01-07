package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.natura.android.sample.R

class IconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)

        val iconGrid = findViewById<RecyclerView>(R.id.icon_grid)
        iconGrid.layoutManager = GridLayoutManager(this, 3)

        iconGrid.adapter = IconAdapter(this, recoverListIcons())
    }

    private fun recoverListIcons() = listOf(
        R.string.icon_filled_action_add,
        R.string.icon_filled_action_cancel,
        R.string.icon_filled_action_check,
        R.string.icon_filled_action_rating,
        R.string.icon_filled_action_subtract,
        R.string.icon_filled_brand_naturarosacea,
        R.string.icon_filled_media_pause,
        R.string.icon_filled_media_play,
        R.string.icon_filled_navigation_directionleft,
        R.string.icon_filled_navigation_directionright,
        R.string.icon_filled_navigation_directiontbottom,
        R.string.icon_filled_navigation_directiontop,
        R.string.icon_filled_navigation_menu,
        R.string.icon_filled_navigation_more,
        R.string.icon_outlined_communication_occurrence,
        R.string.icon_outlined_content_adddocument,
        R.string.icon_outlined_content_agility,
        R.string.icon_outlined_content_book,
        R.string.icon_outlined_content_brightness,
        R.string.icon_outlined_content_changeview,
        R.string.icon_outlined_content_channel,
        R.string.icon_outlined_content_christmascard,
        R.string.icon_outlined_content_consistency,
        R.string.icon_outlined_content_divulgation,
        R.string.icon_outlined_content_education,
        R.string.icon_outlined_content_gift,
        R.string.icon_outlined_content_global,
        R.string.icon_outlined_content_health,
        R.string.icon_outlined_content_lock,
        R.string.icon_outlined_content_magic,
        R.string.icon_outlined_content_medal,
        R.string.icon_outlined_content_menu,
        R.string.icon_outlined_content_mirror,
        R.string.icon_outlined_content_produtivity,
        R.string.icon_outlined_content_store,
        R.string.icon_outlined_content_wifi,
        R.string.icon_outlined_finance_bag,
        R.string.icon_outlined_finance_cards,
        R.string.icon_outlined_finance_charging,
        R.string.icon_outlined_finance_creditcard,
        R.string.icon_outlined_finance_debit,
        R.string.icon_outlined_finance_discount,
        R.string.icon_outlined_finance_littlemachine,
        R.string.icon_outlined_finance_money,
        R.string.icon_outlined_finance_moneypaper,
        R.string.icon_outlined_finance_promotion,
        R.string.icon_outlined_finance_shoppingcart,
        R.string.icon_outlined_finance_shoppingcartproduct,
        R.string.icon_outlined_finance_tagdiscount,
        R.string.icon_outlined_finance_transfermoney,
        R.string.icon_outlined_media_app,
        R.string.icon_outlined_media_camera,
        R.string.icon_outlined_media_monitor,
        R.string.icon_outlined_media_play,
        R.string.icon_outlined_navigation_arrowbottom,
        R.string.icon_outlined_navigation_arrowleft,
        R.string.icon_outlined_navigation_arrowright,
        R.string.icon_outlined_navigation_arrowtop,
        R.string.icon_outlined_navigation_close,
        R.string.icon_outlined_navigation_directionbottom,
        R.string.icon_outlined_navigation_directionleft,
        R.string.icon_outlined_navigation_directionright,
        R.string.icon_outlined_navigation_directiontop,
        R.string.icon_outlined_navigation_exit,
        R.string.icon_outlined_navigation_goback,
        R.string.icon_outlined_navigation_gofront,
        R.string.icon_outlined_navigation_home,
        R.string.icon_outlined_navigation_menu,
        R.string.icon_outlined_place_bus,
        R.string.icon_outlined_place_forklift,
        R.string.icon_outlined_place_local,
        R.string.icon_outlined_place_truck,
        R.string.icon_outlined_place_waze,
        R.string.icon_outlined_product_bagproduct,
        R.string.icon_outlined_product_beard,
        R.string.icon_outlined_product_brandsproduct,
        R.string.icon_outlined_product_childish,
        R.string.icon_outlined_product_dailycare,
        R.string.icon_outlined_product_hair,
        R.string.icon_outlined_product_makeup,
        R.string.icon_outlined_product_outlet,
        R.string.icon_outlined_product_perfumery,
        R.string.icon_outlined_product_vegan,
        R.string.icon_outlined_produtct_promotionproduct,
        R.string.icon_outlined_social_addcontact,
        R.string.icon_outlined_social_birthday,
        R.string.icon_outlined_social_collaborate,
        R.string.icon_outlined_social_contact,
        R.string.icon_outlined_social_digitalconsultant,
        R.string.icon_outlined_social_groupofpeople,
        R.string.icon_outlined_social_myprofile,
        R.string.icon_outlined_social_network,
        R.string.icon_outlined_social_person
    )
}
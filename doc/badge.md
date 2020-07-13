# Badge Component - Default variant

### What is it?
Badge represents dynamic information such as number of notifications unread with some styles to match Nat DS appearance.

### Why should I use it?
This component can help you to show some simple information on the top of chosen image.

### When should I use it?
Every time you want to display an image with a badge

### How to use it?
##### If you want to display an icon with a Badge with number
 - Create a drawable layer-list with two items inside. The first item should be your base icon and the second should be the placeholder for your badge.

 ```android
 icon_base_badge.xml
 
   <layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/outlined_default_mockup"
        android:gravity="center" />

    <item
        android:id="@+id/ic_badge_placeholder"
        android:drawable="@android:color/transparent" />
</layer-list>
```

- Use base-badge.xml inside a imageview in your layout

- Create a new instance of BadgeDrawable passing the context, the number that you want to be displayed and the image will be inflated with Badge.

```android
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)
        BadgeDrawable(this, 100, imageViewBadged.drawable)
    }
   ```


##### If you want display an AppBar with a badge 

If you need to show badge over a menu item, you can use the SetupAppBar helper class.

- Create a menu with icon_base_badge like an item
```android
my_menu.xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto" >

    <item
        android:id="@+id/ic_schedule"
        android:icon="@drawable/ic_schedule"
        app:showAsAction="always" />

    <item
        android:id="@+id/ic_notification"
        android:icon="@drawable/icon_base_badge"
        android:title="notification"
        app:showAsAction="always" />
</menu>
   ```
   
- Instantiate the SetupAppBar in your Activity and call 'displayMenuWithBadge' method with the requested parameters inside onCreateOptionsMenu().

```android
    private var setupAppBar = SetupAppBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)
        setSupportActionBar(toolBarTop)
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            setupAppBar.displayMenuWithBadge(this, menu, R.menu.my_menu, count, R.id.ic_notification)
            return true
     }
   ```

If you need update the number inside a Badge, you just call the method 'updateNotificationBadge' passing the menu as parameter and the number to be updated

```android
    setupAppBar.updateNotificationBadge(menu, count, R.id.ic_notification)
```

# App Bar Top Component - Default variant

### What is it?
App Bar Top is the Android native Action bar with some customizations to match Nat DS appearance and integrate with other components, such as badge and logo.

### Why should I use it?
This component can help you to show some infos and/or actions on the top of the screen

### When should I use it?
Every time you want to configure an quick acess to some basic infos or actions

### How to use it?
Add the app bar component in your xml layout file
Important! Do not use the default theme, use the NoActionBar variant. You can check more infos [here](getting-started.md).
```android
      <com.natura.android.appbar.AppBar
          android:id="@+id/appBar"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:theme="?toolbarDefaultTheme"/>
```
After that, the App Bar will be displayed at the top of the screen and in the root view code, you can add some basic actions:
```android
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "App Bar Top"
    }
   ```
To configure the back button action:
```android
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
```
#### AppBar with centralized brand logo
To use the app bar with logo component just add the attribute showLogo in the xml file like below:
```android
      <com.natura.android.appbar.AppBar
          android:id="@+id/appBar"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:theme="?toolbarDefaultTheme"
          app:showLogo="true"/>
```
If you prefer you can do it programmatically using the methods below in the root view code:
```android
      appBar.showLogo()
      appBar.hideLogo()
```
#### AppBar with badge in action button
The AppBar component abstract the logic to configure the badge component to work in the action button. 
Example:
```android
      notificationMenuItem = menu?.findItem(R.id.ic_notification)
      notificationMenuItem?.let {
          appBar.addMenuIconBadge(it.icon, mCount)
      }
```
To update badge value:
```android
      appBar.updateBadgeValue(mCount)
```

### How create a customized App Bar
If you need an more customize App Bar Top, you can use Android Toolbar component with the DS theme applied.
Important! If you are adding the toolbar component at you xml layou file, DO NOT use the default theme, use the NoActionBar variant. You can check more infos [here](getting-started.md).

```android
    <com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
        
        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolBarTop"
            android:layout_width="match_parent"
            android:layout_height="?toolbarHeight"
            android:theme="?toolbarDefaultTheme"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
            
    </com.google.android.material.appbar.AppBarLayout>
 ```

After that, the App Bar will be displayed at the top of the screen and in the root view code, you can add some basic actions:
```android
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          setContentView(R.layout.activity_appbar)
          setSupportActionBar(toolBarTop)
          supportActionBar?.setDisplayHomeAsUpEnabled(true)
          supportActionBar?.title = "App Bar Top"
      }
 ```



# App Bar Top Component - Default variant

### What is it?
App Bar Top is the Android native Action bar with some styles to match Nat DS appereance.

### Why should I use it?
This component can help you to show some infos and/or actions on the top of the screen

### When should I use it?
Every time you want to configure an quick acess to some basic infos or actions

### How to use it?
If you need to configure just a basic App Bar, with title and some simple actions, just configure at your view the base theme. You can check how to do it [here](getting-started.md).
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


However if you need an more complex App Bar Top, you can use Android Toolbar component with the DS theme applied.
Important! If you are adding the toolbar component at you xml layou file, DO NOT use the default theme, use the NoActionBar variant. You can check more infos [here](getting-started.md).

```android
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolBarTop"
        android:layout_width="match_parent"
        android:layout_height="?toolbarHeight"
        android:theme="?toolbarDefaultTheme"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
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



# Dialog - WIP

### What is it?
Dialogs inform users about a task and can contain critical information, require decisions, or involve multiple tasks.

### Why should I use it?
A dialog can be an easy and interactive way to infor users

### When should I use it?
You should use dialog according to its variantions: check dialog variantions [![here](https://zeroheight.com/08f80f4e1/p/94868f-dialog/b/993274)

### How to use it?

#### Standard Dialog


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



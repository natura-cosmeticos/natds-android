# Progress Indicator

> Progress indicators express an unspecified wait time or display the length of a process.
Extends from [ProgressBar](https://developer.android.com/reference/android/widget/ProgressBar).


## Properties

| Property           | Values                         | Status            |
| --------------     | -------------------------      | ----------------- |
| Type             | Indeterminated                          | ✅  Available     |
| Size          | Standard, Semi, Medium, Large   | ✅  Available     |
| Layer         | True or False        | ✅  Available     |


## Technical Usages Examples

![](./images/progressindicator_lightMode.png.png)


##### Progress Indicator with standard size and layer

![Progress Indicator](./images/progressindicator_standard.png)

```android
    <com.natura.android.progressindicator.ProgressIndicator
        android:id="@+id/progressIndicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:pgid_layer="true"
        app:pgid_size="standard" />
```

<br><br>

##### Progress Indicator with large size without layer

![Progress Indicator](./images/progressindicator_large.png)

```android
    <com.natura.android.progressindicator.ProgressIndicator
        android:id="@+id/progressIndicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:pgid_layer="false"
        app:pgid_size="large"/>
```
<br>


## More code
You can check out more examples from SampleApp by clicking [here](https://github.com/natura-cosmeticos/natds-android/tree/master/sample/src/main/res/layout/activity_progress_indicator.xml).


## Attention points
   
1. Nat DS Android supports for now only Circular variant of Progress Indicator

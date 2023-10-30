# Divider
> A divider is a thin line that groups content in lists and layouts.


## Properties

| Property           | Values                         | Status            |
| --------------     | -------------------------      | ----------------- |
| Variants         | Full-bleed, Inset, Middle        | ✅  Available     |


## Technical Usages Examples

![](./images/divider_lightMode.png)

<br>

##### Divider with fullBleed type

![Divider](./images/divider_fullBleed.png)

```android
    <com.natura.android.divider.Divider
       android:id="@+id/divider"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       app:dividerType="fullBleed" />
```

<br><br>

##### Divider with inset type

![Divider](./images/divider_inset.png)

```android
    <com.natura.android.divider.Divider
       android:id="@+id/divider"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       app:dividerType="inset" />
```

<br><br>

##### Divider with middle type

![Divider](./images/divider_middle.png)

```android
    <com.natura.android.divider.Divider
       android:id="@+id/divider"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       app:dividerType="middle" />
```

<br><br>

## More code
You can check out more examples from SampleApp by clicking [here](https://github.com/natura-cosmeticos/natds-android/tree/master/sample/src/main/res/layout/activity_divider.xml).


## Attention points
   
1. Margin spacing is fixed and not customizable.

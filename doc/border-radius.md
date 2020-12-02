# Border Radius token

## What is it?
Border Radius supported by DS.

## Why should I use it?
It helps you to develop interfaces with an consistent border radius appearance

## When should I use it?
Every time it is necessary to define an rounded border to an visual component

### Using border radius token at components
To access size tokens, you should set a DS [theme](getting-started.md) at the view or its parents.
Nat DS Android provides two ways to use border radius:

#### Border radius by background drawable
Sometimes to set a border radius it necessary to change the background drawable of the component. To do that with Nat DS Android, its possible to use the following shapes:
- `ds_border_radius_none.xml`
- `ds_border_radius_small.xml`
- `ds_border_radius_medium.xml`
- `ds_border_radius_large.xml`

#### Border radius by component attribute
However, some components can have it border radius set by an attribute. For example CardView has `app:cardCornerRadius` attribute

```android
            <android.support.v7.widget.CardView
                android:id="@+id/myCardView"
                android:layout_width="?sizeSmall"
                android:layout_height="?sizeSmall"
                android:elevation="?elevationMicro"
                app:cardCornerRadius="?borderRadiusLarge" />
```

Nat DS Android supports the following border radius tokens:

- `borderRadiusNone` = 0dp
- `borderRadiusSmall` = 2dp
- `borderRadiusMedium` = 4dp
- `borderRadiusLarge` = 8dp

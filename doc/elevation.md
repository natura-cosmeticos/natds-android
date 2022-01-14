# Elevation token

## What is it?
Elevations supported by DS.

## Why should I use it?
It helps you to develop interfaces with an consistent elevation scale

## When should I use it?
Every time it is necessary to define an elevation to a component

### Using elevation token at components
To access elevation tokens, you should set a DS [theme](../README.md) at the view or its parents.
Set at a component that supports elevation. For example, at a CardView it can be set like following:

```android
           <androidx.cardview.widget.CardView
                       android:id="@+id/cardElevationNone"
                       android:backgroundTint="?attr/colorPrimary"
                       android:layout_width="?attr/sizeLargeXXX"
                       android:layout_height="?attr/sizeLargeXXX"
                       android:layout_gravity="center"
                       app:cardElevation="?elevationTiny"/>
```

Nat DS Android supports the following elevation tokens:

- `elevationNone`	= 0dp
- `elevationMicro`	= 1dp
- `elevationTiny`	= 2dp
- `elevationSmall`	= 3dp
- `elevationMedium`	= 4dp
- `elevationLarge`	= 6dp
- `elevationLargeX`	= 8dp
- `elevationLargeXX`= 9dp
- `elevationHuge`	= 12dp
- `elevationHugeX`	= 16dp
- `elevationHugeXX`	= 24dp
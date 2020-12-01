# Size token

## What is it?
Sizes supported by DS.

## Why should I use it?
It helps you to develop interfaces with an consistent size scale

## When should I use it?
Every time it is necessary to define width and/or height to an visual component

### Using size token at components
To access size tokens, you should set a DS [theme](getting-started.md) at the view or its parents.

```android
            android:layout_width="?sizeNone"
            android:layout_height="?sizeNone"
```

Nat DS Android supports the following size tokens:

   - `?sizeNone` = 0dp
   - `?sizemicro` = 4dp
   - `?sizetiny` = 8dp
   - `sizesmall` = 16dp
   - `sizestandard` = 24dp
   - `sizesemi` = 32dp
   - `sizesemi_x` = 40dp
   - `sizemedium` = 48dp
   - `sizemedium_x` = 56dp
   - `sizelarge` = 64dp
   - `sizelarge_x` = 72dp
   - `sizelarge_xx` = 80dp
   - `sizelarge_xxx` = 88dp
   - `sizehuge` = 6dp
   - `sizehuge_x` = 128dp
   - `sizehuge_xx` = 144dp
   - `sizehuge_xxx` = 192dp
   - `sizevery_huge`= 256dp
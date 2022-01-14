# Size token

## What is it?
Spacing supported by DS.

## Why should I use it?
It helps you to develop interfaces with an consistent spacing scale

## When should I use it?
Every time it is necessary to define an margin, padding or define some type os spacing between visual elements.

### Using spacing token at components
To access spacing tokens, you should set a DS [theme](../README.md) at the view or its parents.

```android
            android:layout_marginStart="?spacingSmall"
            android:padding="?spacingStandard"

```

Nat DS Android supports the following spacing tokens:

   - `spacingNone` = 0dp
   - `spacingmicro` = 4dp
   - `spacingtiny` = 8dp
   - `spacingsmall` = 16dp
   - `spacingstandard` = 24dp
   - `spacingsemi` = 32dp
   - `spacinglarge` = 48dp
   - `spacingx_large` = 64dp
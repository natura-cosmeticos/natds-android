# Divider Component

## What is it?

Divider is a thin line view with the purpose of separating content within a layout. 

Divider is available at version 5.4.0 of NatDS Android.

### Why should I use it?

The component can help you separate content and elements.

### When should I use it?

Every time you want to organize your layout so that different content is isolated.

### How to use it?

Add the Divider component in your xml layout file
        
```android
<com.natura.android.divider.Divider
        android:id="@+id/dividerFullbleed"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:dividerType="fullBleed" />
```
#### Divider component has the following attribute that can be set:

- `type`:  differs depending on the distance from the ends.
           Remember that the margins are fixed and not customizable.
           
![Divider](divider.png)


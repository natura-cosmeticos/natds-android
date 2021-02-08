# Card Component - Default variant

## What is it?

The card is a container component with rounded corners and shadow based on its elevation, used to group static and dynamic content.

### Why should I use it?

The component can help you group elements in a visually attractive container.

### When should I use it?

Every time you want to bring a card layout to the content grouping container.

### How to use it?

Add the Card component in your xml layout file
        
```android
<com.natura.android.card.Card
        android:id="@+id/card"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:enabledRadius="true"
        app:enabledElevation="true">

</com.natura.android.card.Card>
```
#### Card component has the following attributes that can be set:
- `android:enabledRadius` : when true, the radius effect is visible, when false the radius is hidden
- `android:enabledElevation` : when true, the elevation effect is visible, when false the elevation is hidden

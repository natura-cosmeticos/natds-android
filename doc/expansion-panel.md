# Expansion Panel - How to Use

### What is it?
Expansion Panel is a component to display a subtitle when collapsed and
can have any other component inside it. This other component can be
displayed when Expansion Panel is opened.

### How to use it?
Expansion Panel receives a subtitle (string type) attribute. It can have
any type of child that will be rendered inside collapsed area.

Following there's an example of an Expansion Panel with an LinearLayout
and TextField children:

```android
<com.natura.android.expansionPanel.ExpansionPanel
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:subtitle="Expansion Panel">

    <LinearLayout
        android:id="@+id/circle_example"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:background="@drawable/ds_border_circle"
        android:orientation="vertical"
        android:layout_gravity="center"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"/>

    <TextView
        android:id="@+id/text_example"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Details\n\nThis expanded area is a Constraint Layout.\nAny group of components can be used here."
        android:layout_marginTop="0dp"
        android:layout_marginLeft="?spacingSmall"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toRightOf="@id/circle_example"/>

</com.natura.android.expansionPanel.ExpansionPanel>
```
### How it looks like

#### Collapsed:
[![Collapsed](expansion_panel_collapsed.png)](https://postimg.cc/gX4JPZfR)

#### Opened:
[![Expanded](expansion_panel_opened.png)](https://postimg.cc/kR45M5mH)

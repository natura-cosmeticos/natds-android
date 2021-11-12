# Progress Indicator

### What is it?
The progress indicator is a component that informs users about the status of ongoing processes, such as loading an application, submitting a form, or saving updates.

### How to use it?
Nat DS Android Progress Indicator is based on a android [ProgressBar](https://developer.android.com/reference/android/widget/ProgressBar) with styles provided by Nat DS Theme.
To use it, a Nat DS Theme must be provided to the view or its parents. After that, its possible to add a ProgressIndicator component on xml layout:

 ```
<com.natura.android.progressindicator.ProgressIndicator
    android:id="@+id/ds_loading"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:pgid_size="large"
    app:pgid_layer="true"/>
 ```

#### Progress Indicator component has the following attributes that can be set:

- `pgid_size`:  standard, semi, medium or large.
- `pgid_layer`:  true or false

⚠️⚠️⚠️ Nat DS Android supports for now only Circular variant of Progress Indicator ⚠️⚠️⚠️
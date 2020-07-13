# Dialog

### What is it?
Dialogs inform users about a task and can contain critical information, require decisions, or involve multiple tasks.

### Why should I use it?
A dialog can be an easy and interactive way to informe users

### When should I use it?
You should use dialog according to its variantions: check dialog variantions [here](https://zeroheight.com/08f80f4e1/p/94868f-dialog/b/993274)

### How to use it?

## Standard Dialog
A dialog standard is a Nat DS component created over the native android AlertDialog, form AndroidX App Compat. The DS component MUST have:
- Title
- Content (can be anything you need, a text, an image et)
- A main action button
- A secondary action button

The usage of Dialog Standard is really simple. First you create the dialog, than you show it.

### Creating the dialog:
You can create this dialog provinding some attributes to DialogStandard constructor:

##### Context
*Android Context*

##### Dialog Title
*String that will be show as a dialog title*

##### Dialog Main Button Title
*String with main button's label, this button will be show as a *contained* button*

##### Dialog Main Action
*DialogInterface.OnClickListener that will be call when user perform a click at main button*

##### Dialog Secondary Button Title
*String with secondary button's label, this button will be show as a *text* button*

##### Dialog Secondary Action
*DialogInterface.OnClickListener that will be call when user perform a click at secondary button*

##### Content View or Content Layout
*Content that will be show inside dialog. You can provide an View or a Layout reference to fill it.*

##### Cancelable
*Flag that set if dialog can be closed by clicking out of it or not. You can omite this parameter and it will be assumed as true*

##### Dialog Theme
*If the view where dialog is in has not a DS theme applyed, you can pass the DS theme reference at the constructor. The theme will be used only inside the dialog. <p>⚠️ **If you omit this, the parent theme will be used to set the dialog. If the parent theme is not an Nat DS Theme, the dialog will not be set as expected**</P>



Check bellow an code exemple of how you can create an Dialog Standard:

```android
private fun createDialog() {
    val mainClickListener = DialogInterface.OnClickListener { _, _ -> Toast.makeText(this, "Dialog Main Action", Toast.LENGTH_LONG).show() }
    val secondaryClickListener = DialogInterface.OnClickListener { _, _ -> Toast.makeText(this, "Dialog Secondary Action", Toast.LENGTH_LONG).show() }

    dialogStandard = DialogStandard(
        this,
        "Title",
        "Confirm Button",
        mainClickListener,
        "Close",
        secondaryClickListener,
        R.layout.standard_dialog_content).create()
}
```
### Showing the dialog

With the dialog created, you can show it whenever you want, calling *show()* method :)

```android
button.setOnClickListener {
    dialogStandard.show()
}
```






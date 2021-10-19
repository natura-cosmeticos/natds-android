# Dialog

#### Note:

This component is available in the following variants:

* ✅ Alert
* ✅ Standard

With the following attribute status:

* Divider(Standard):
    * ✅ `False` (default)
    * ✅ `True`
    
* ✅ firstHeaderIconButton(Standard)

* ✅ firstHeaderIconButtonAction(Standard)

* ✅ secondHeaderIconButton(Standard

* ✅ secondHeaderIconButtonAction(Standard)

* ✅ thirdHeaderIconButton(Standard)

* ✅ thirdHeaderIconButtonAction(Standard)

* ❌ Size / Height

* ❌ Scroll



### What is it?
Dialogs inform users about a task and can contain critical information, require decisions, or involve multiple tasks.

### Why should I use it?
A dialog can be an easy and interactive way to informe users

### When should I use it?
You should use dialog according to its variantions: check dialog variantions [here](https://ds.natura.design/28db352be/p/1122a8-dialog/b/51a722)

### How to use it?

## Standard Dialog
A dialog standard is a Nat DS component created over the native android AlertDialog, form AndroidX App Compat. The DS component MUST have:
- Title
- Content (can be anything you need, a text, an image, etc)
- A main action button
- A secondary action button

The usage of Dialog Standard is really simple. First you create the dialog, than you show it.

### Creating the dialog:
You can create this dialog providing some attributes to DialogStandard constructor:

##### Context
*Android Context*

##### Dialog Title
*String that will be show as a dialog title*

##### Dialog Main Button Title (Optional)
*String with main button's label, this button will be show as a *contained* button*

##### Dialog Main Action (Optional)
*DialogInterface.OnClickListener that will be call when user perform a click at main button*

##### Dialog Secondary Button Title (Optional)
*String with secondary button's label, this button will be show as a *text* button*

##### Dialog Secondary Action (Optional)
*DialogInterface.OnClickListener that will be call when user perform a click at secondary button*

##### Content View, Content Layout or Text Message
*Content that will be show inside dialog. You can provide an View, a Layout reference to fill it, or simply insert the main text of your dialog.*

##### Cancelable
*Flag that set if dialog can be closed by clicking out of it or not. You can omite this parameter and it will be assumed as true*

##### Dialog Theme (Optional)
*If the view where dialog is in has not a DS theme applyed, you can pass the DS theme reference at the constructor. The theme will be used only inside the dialog. <p>⚠️ **If you omit this, the parent theme will be used to set the dialog. If the parent theme is not an Nat DS Theme, the dialog will not be set as expected**</P>

##### Divider (Optional) 
*Flag that defines whether two division lines will separate the content (top and bottom)*

##### StyleButtons (Optional) 
*Constant that indicates whether the buttons will have default style (Main and Secondary), primary or text.*

##### firstHeaderIconButton (Optional) 
*String used to define the icon of the first iconbutton of the dialog header*

##### firstHeaderIconButtonAction (Optional) 
*View.OnClickListener that will be call when user perform a click at first iconbutton in header*

##### secondHeaderIconButton (Optional) 
*String used to define the icon of the second iconbutton of the dialog header*

##### secondHeaderIconButtonAction (Optional) 
*View.OnClickListener that will be call when user perform a click at second iconbutton in header*

##### thirdHeaderIconButton (Optional) 
*String used to define the icon of the third iconbutton of the dialog header*

##### thirdHeaderIconButtonAction (Optional) 
*View.OnClickListener that will be call when user perform a click at third iconbutton in header*


Check bellow an code exemple of how you can create an Dialog Standard with Content Layout, dividers and Icon Buttons in header:

```android
private fun createStandardDialogWithHeaderIconButtons() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        val firstHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val secondHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val thirdHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }

        standardDialogHeaderIconButtons = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            false,
            0,
            "outlined-action-mic",
            firstHeaderAction,
            "outlined-action-add",
            secondHeaderAction,
            "outlined-action-cancel",
            thirdHeaderAction
        ).create()
    }
```


Check bellow an code exemple of how you can create an Dialog Standard with Text Message:

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
        "Dialog Text Message").create()
}
```

### Showing the dialog

With the dialog created, you can show it whenever you want, calling *show()* method :)

```android
button.setOnClickListener {
    dialogStandard.show()
}
```






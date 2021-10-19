# Logo

#### Note:

This component is available in the following variants:

* ✅ Aesop
* ✅ Avon
* ✅ Natura
* ✅ The Body Shop

With the following attribute status:
    
* Color:
    * ✅ `Neutral`  (default)
    * ✅ `Primary`
    * ✅ `Secondary`
    * ✅ `Highlight`
    * ✅ `Surface`
    
* Model:
    * ✅ `A` (default)
    * ✅ `B`
    
* Size:
    * ✅ `Medium` 
    * ✅ `MediumX`
    * ✅ `Large`
    * ✅ `LargeX`
    * ✅ `LargeXX`
    * ✅ `LargeXXX`
    * ✅ `Huge`
    * ✅ `HugeX`
    * ✅ `HugeXX`
    * ✅ `HugeXXX`
    * ✅ `VeryHuge` (default)
    
    
### What is it?
The official logo application for brands that Design System support.

### Why should I use it?
It's easier use the logo component, because it support diferent brands.

### When should I use it?
Every time you need to put brand logo to your product.

### How to use it?
Logo component is available according to the selected theme. It means fist of all you MUST set to your view theme (or to a parent of this view) one of your themes.
Check more info about it [here](getting-started.md)

After that, just insert component in XML file like below:

```android
          <com.natura.android.logo.Logo
              android:id="@+id/logoModelA"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              app:customColor="neutral"
              app:customSize="hugexx"
              app:layout_constraintStart_toStartOf="parent"
              app:layout_constraintTop_toTopOf="parent"
              app:model="a" />
   ```

#### Logo component has the following attributes that can be set:
- `app:model` : receives two values, `A`,`B`
- `app:customColor` : receives eleven values, `neutral`, `primary`, `secondary`, `highlight`, `surface`,
- `app:customSize` : receives eleven values, `medium`, `mediumx`, `large`, `largex`, `largexx`, `largexxx`, `huge`, `hugex`, `hugexx`, `hugexxx` or `veryhuge` 



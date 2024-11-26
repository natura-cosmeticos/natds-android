# Guia de Uso - GaYaCheckbox

> 📢 O GaYaCheckbox faz parte da evolução contínua de componentes do GaYa Design System. Ele foi lançado como um novo componente mas o antigo CheckBox permanecerá disponível para uso mas não receberá mais atualizações ou suporte ativo. Encorajamos a migração para o GaYaCheckbox o quanto antes para aproveitar as melhorias e garantir compatibilidade futura.


## Visão Geral

O componente `GaYaCheckbox` permite que os usuários escolham uma ou várias opções em um grupo de `GaYaCheckbox`


| Prop Figma       | Prop XML       | Prop Kotlin       |  Valores                    | Status            |
| -------------- | -------------- | ------------------------- | ------------------------- | ----------------- |
| State          | android:enabled          | isEnabled          | True ou False | ✅  Disponível       |
| Disabled          | android:checked           | isChecked           | True ou False      | ✅  Disponível       |


### Versão disponível

9.30.2

### Changelog

Para acompanhar a evolução deste e de outros componentes acesse: [https://github.com/natura-cosmeticos/natds-android/blob/main/CHANGELOG.md](https://github.com/natura-cosmeticos/natds-android/blob/main/CHANGELOG.md)

### Como Usar

Para começar a usar o `GaYaCheckbox`, siga as instruções abaixo para configurar as diferentes funcionalidades.

<p align="center">
  <img alt="1" src="./images/gayacheckbox.png" width="40%"> 
</p>

```xml
    <com.natura.android.checkbox.GaYaCheckbox
        android:id="@+id/checkboxPrimaryChecked"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="?spacingSmall"
        android:checked="true"
        android:text="GaYaCheckbox" />
```

```kotlin
    val gaYaCheckbox = GaYaCheckbox(this).apply {
        text = "Adicionado programaticamente"
        isChecked = true
        isEnabled = true
    }
```

## Cores

A cor padrão está atrelada ao tema utilizado e não está disponível para alterações por parte do usuário.

### Mudança de temas: mesmo usando um tema padrão, é possível utilizar outro tema em determinado componente

```kotlin
    val gaYaCheckboxAvon = GaYaCheckbox(this, R.style.Theme_Avon_Light_SSOT).apply {
        text = "GaYaCheckbox Avon"
        isChecked = true
        isEnabled = true
    }
```

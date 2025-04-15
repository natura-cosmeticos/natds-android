# GaYaGrowthPlan

Estes tokens organizam e disponibilizam visualmente os grupos de cores do Plano de Crescimento, em conjunto com a iconografia também disponibilizada, pode ser usada para representar diferentes estágios do consultor no Plano de Crescimento.

Cada grupo de cores - Seed, Bronze, Silver, Gold, Diamond e Sapphire - possui variações que seguem uma escala de luminosidade, além das cores de contraste `onColor` recomendadas para garantir legibilidade.

### 🌱 Grupos de tokens disponíveis:

| Grupo     | Descrição                                    |
|-----------|----------------------------------------------|
| Seed      | Crescimento inicial / primeiros passos      |
| Bronze    | Evolução e conquistas básicas               |
| Silver    | Experiência e amadurecimento                |
| Gold      | Excelência e reconhecimento                 |
| Diamond   | Elite / alto desempenho                     |
| Sapphire  | Referência / estágio máximo                 |
 

### 🔧 Como usar no Android

Importe o objeto `GaYaGrowthPlan` diretamente do módulo do GaYa.

```kotlin
import com.natura.android.gayaGrowthPlan.GaYaGrowthPlan

val seedColor = GaYaGrowthPlan.seed
val bronzeDarkest = GaYaGrowthPlan.bronzeDarkest
val onGold = GaYaGrowthPlan.onGold
```

Cada propriedade expõe um código hexadecimal String que pode ser facilmente convertido para Color ou utilizado direto em componentes visuais.


### 🎨 Visualização das cores

Cada grupo possui:

- 5 variações principais: Lightest → Darkest  
- 5 variações `onColor` para uso sobre essas cores.

Exemplo:

```kotlin
GaYaGrowthPlan.seedLightest
GaYaGrowthPlan.seedLight
GaYaGrowthPlan.seed
GaYaGrowthPlan.seedDark
GaYaGrowthPlan.seedDarkest

GaYaGrowthPlan.onSeedLightest
GaYaGrowthPlan.onSeedLight
GaYaGrowthPlan.onSeed
GaYaGrowthPlan.onSeedDark
GaYaGrowthPlan.onSeedDarkest
```

<br/> 

### 📎 Resumo das propriedades disponíveis

| Grupo    | Variações Disponíveis                         |
|----------|-----------------------------------------------|
| seed     | Lightest, Light, Default, Dark, Darkest, OnColors |
| bronze   | Lightest, Light, Default, Dark, Darkest, OnColors |
| silver   | Lightest, Light, Default, Dark, Darkest, OnColors |
| gold     | Lightest, Light, Default, Dark, Darkest, OnColors |
| diamond  | Lightest, Light, Default, Dark, Darkest, OnColors |
| sapphire | Lightest, Light, Default, Dark, Darkest, OnColors |


<br/> 

> Estes tokens fazem parte do Design System GaYa e tem como objetivo padronizar a aplicação das cores estratégicas do Plano de Crescimento dentro dos apps Android.

<br/> <br/> 

##### Made with 🧡 by Design System GaYa Team

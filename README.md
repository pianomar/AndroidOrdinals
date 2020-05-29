# Android Ordinals
An Android library to retrieve the ordinal of an integer in the specified language

## Getting Started

This library returns the whole String of the ordinal of the integer passed, for example, passing 1 would return 1st for English, 42 -> 42nd etc...
You can either integrate the whole library to support all lanugages, or choose the classes to use.

Using it is simple:
1. Create an Ordinal object with the required language
2. Call the `ordinal()` function with the required parameters (minimum an ISO3 language code, you can get a list of languages by calling `Locale.getISOLanguages()` )

```
val ordinalObj = Ordinal("eng")
val ordinal = ordinalObj.ordinal(5)
print(ordinal)

// output: 5th
```

### Note!

The library is far from complete, the idea is to have an open source library for everyone to add in their language's ordinals and help allow Android developers to include UX requesites to have such strings in the application

### Current supported languages (29/May/2020):
1. English
2. Spanish
3. French
4. Arabic (Until 99 since in arabic the whole word changes)

### Installing

#### Step 1:
Add this to your build.gradle file:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

#### Step 2:
Add the dependency:

```
dependencies {
  implementation 'com.github.pianomar:AndroidOrdinals:Tag'
}
```

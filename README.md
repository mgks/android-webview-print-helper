# Android WebView Print Helper

[![](https://jitpack.io/v/mgks/android-webview-print-helper.svg)](https://jitpack.io/#mgks/android-webview-print-helper)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

A lightweight utility to print Android WebView content to PDF or physical printers with a single line of code. It handles the `PrintManager`, `PrintDocumentAdapter`, and `PrintAttributes` boilerplate automatically.

Extracted from the core of **[Android Smart WebView](https://github.com/mgks/Android-SmartWebView)**.

<img src="https://github.com/mgks/android-webview-print-helper/blob/main/preview.gif?raw=true" width="200">

## Features
*     **One-Line Print:** Trigger the native Android print dialog instantly.
*     **PDF & Hardware:** Supports "Save to PDF" and physical printers out of the box.
*     **Optimized Defaults:** Automatically configures media size to ISO A4.
*     **Kotlin & Java:** Written in Kotlin but 100% Java-friendly.

## Installation

**Step 1. Add the JitPack repository to your build file**

**Gradle (Kotlin DSL):**
```kotlin
repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```
**Gradle (Groovy):**
```groovy
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

**Step 2. Add the dependency**

```groovy
dependencies {
    implementation 'com.github.mgks:android-webview-print-helper:1.0.0'
}
```

*(Note: Replace `1.0.0` with the latest release tag)*

## Usage

### Kotlin

```kotlin
class MainActivity : AppCompatActivity() {
    private lateinit var printHelper: SwvPrintHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ... setup webview ...

        // 1. Initialize
        printHelper = SwvPrintHelper(this)

        // 2. Print (e.g., on button click)
        myButton.setOnClickListener {
            // Arguments: WebView instance, Document Name (appears in spooler)
            printHelper.print(myWebView, "My-Document-Name")
        }
    }
}
```

### Java

```java
public class MainActivity extends AppCompatActivity {
    private SwvPrintHelper printHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ... setup webview ...

        // 1. Initialize
        printHelper = new SwvPrintHelper(this);

        // 2. Print
        myButton.setOnClickListener(v -> {
            printHelper.print(myWebView, "My-Document-Name");
        });
    }
}
```

## Requirements
*   **Min SDK:** API 24 (Android 7.0)
*   **WebView:** Requires a standard Android WebView instance.

## License
MIT

> **{ github.com/mgks }**
> 
> ![Website Badge](https://img.shields.io/badge/Visit-mgks.dev-blue?style=flat&link=https%3A%2F%2Fmgks.dev) ![Sponsor Badge](https://img.shields.io/badge/%20%20Become%20a%20Sponsor%20%20-red?style=flat&logo=github&link=https%3A%2F%2Fgithub.com%2Fsponsors%2Fmgks)

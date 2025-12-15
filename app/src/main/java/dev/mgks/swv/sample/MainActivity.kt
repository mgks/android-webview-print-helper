package dev.mgks.swv.sample

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dev.mgks.swv.printhelper.SwvPrintHelper

class MainActivity : AppCompatActivity() {

    private lateinit var printHelper: SwvPrintHelper
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)

        // 1. Initialize Library
        printHelper = SwvPrintHelper(this)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Load a page with text (Wikipedia is good for printing tests)
        webView.loadUrl("https://en.m.wikipedia.org/wiki/Printing")

        // 2. Button to Trigger Print
        val btnPrint = findViewById<Button>(R.id.btn_print)
        btnPrint.setOnClickListener {
            printHelper.print(webView, "Test-Print-Job")
        }
    }
}
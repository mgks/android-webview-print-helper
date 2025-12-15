package dev.mgks.swv.printhelper

import android.app.Activity
import android.content.Context
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView
import android.util.Log

/**
 * Smart WebView Print Helper.
 * Simplifies printing WebView content to PDF or printers.
 */
class SwvPrintHelper(private val activity: Activity) {

    /**
     * Print the current content of the WebView.
     *
     * @param webView The WebView to print.
     * @param jobName The name of the document (appears in the print spooler).
     */
    fun print(webView: WebView, jobName: String = "Document") {
        val printManager = activity.getSystemService(Context.PRINT_SERVICE) as? PrintManager

        if (printManager != null) {
            val printAdapter = webView.createPrintDocumentAdapter(jobName)

            // Create default print attributes (Standard A4/Letter sizing)
            val builder = PrintAttributes.Builder()
            builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4)

            try {
                printManager.print(
                    jobName,
                    printAdapter,
                    builder.build()
                )
                Log.d("SwvPrintHelper", "Print job started: $jobName")
            } catch (e: Exception) {
                Log.e("SwvPrintHelper", "Failed to start print job", e)
            }
        } else {
            Log.e("SwvPrintHelper", "PrintManager not available on this device")
        }
    }
}
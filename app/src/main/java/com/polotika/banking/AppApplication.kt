package com.polotika.banking

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.ThreatListener
import com.polotika.auth.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import kotlin.system.exitProcess

@HiltAndroidApp
open class AppApplication : Application(), ThreatListener.ThreatDetected,
    ThreatListener.DeviceState {
    companion object {
        private const val EXPECTED_PACKAGE_NAME =
            "com.polotika.banking" // Don't use Context.getPackageName!
        private val expectedSigningCertificateHashBase64 = arrayOf(
            "xAFbUJmpucEvvSnHHE17l8G+E4j1kgIehJOMSZVGohk="
        ) // Replace with your release (!) signing certificate hashes
        private const val WATCHER_MAIL = "Ahmed.mostfa.ghorab@gmail.com" // for Alerts and Reports
        private val supportedAlternativeStores = emptyArray<String>()
        private val isProd = BuildConfig.BUILD_TYPE.contains("Release", true)
    }

    override fun onCreate() {
        super.onCreate()

        // Log.e("SigningCertificateHash", Utils.computeSigningCertificateHash(this))
        val config = TalsecConfig(
            EXPECTED_PACKAGE_NAME,
            expectedSigningCertificateHashBase64,
            WATCHER_MAIL,
            supportedAlternativeStores,
            isProd
        )
        ThreatListener(this).registerListener(this)
        Talsec.start(this, config)

    }

    override fun onRootDetected() {
        showAlertDialog(this, "Root Detected", "This Device is Rooted") {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onDebuggerDetected() {
        showAlertDialog(this, "Debug Detected", "This Device is being debugged") {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onEmulatorDetected() {
        showAlertDialog(this, "Emulator Detected", "This Device is Emulator") {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onTamperDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onUntrustedInstallationSourceDetected() {
        showAlertDialog(
            this,
            "Untrusted Installation Source Detected",
            "This Device is NOT allowed to start the application"
        ) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onHookDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onDeviceBindingDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onObfuscationIssuesDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onUnlockedDeviceDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onHardwareBackedKeystoreNotAvailableDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onDeveloperModeDetected() {
        showAlertDialog(this, "Developer Mode Detected", "This Device is in Developer Mode") {
            Talsec.stop()
            exitProcess(1)
        }
    }

    override fun onSystemVPNDetected() {
        showAlertDialog(this) {
            Talsec.stop()
            exitProcess(1)
        }
    }

    private fun showAlertDialog(
        context: Context,
        title: String = "Up normal Behavior Detected",
        message: String = "This Device is NOT allowed to start the application",
        onDismiss: () -> Unit
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                onDismiss()
                dialog.dismiss()
            }
            .setOnDismissListener { onDismiss() } // Called when the dialog is dismissed for any reason
            .show()
    }
}
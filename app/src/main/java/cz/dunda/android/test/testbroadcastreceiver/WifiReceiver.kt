package cz.dunda.android.test.testbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cz.dunda.android.fc.testy.fctest.ext.TAG
import cz.dunda.android.fc.testy.fctest.log.L

class WifiReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        L.d(TAG(),"Action->${intent.action}, URI->${intent.toUri(Intent.URI_INTENT_SCHEME).toString()}")
    }
}

package cz.dunda.android.test.testbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.method.ScrollingMovementMethod



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_logs.movementMethod = ScrollingMovementMethod()


        // Receiver bud registruju v manifestu (tento pripad) nebo lze registrovat rucne
        // (viz. zakomentovano)

        // Pro Android O je doporuceno jiz registrovat mimo manifest

        val wr = WifiReceiver()
        val filter = IntentFilter()
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(wr, filter)
    }
}

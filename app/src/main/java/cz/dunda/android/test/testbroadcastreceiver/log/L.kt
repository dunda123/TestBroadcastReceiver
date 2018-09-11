package cz.dunda.android.fc.testy.fctest.log

import android.util.Log
import android.widget.TextView

/**
 * Zapouzdrovaci trida
 */

object L {

    fun d(tag: String, msg: String) {
        log(tag, msg, 1, null, null)
    }

    fun d(tag: String, msg: String, tv: TextView) {
        log(tag, msg, 1, null, tv)
    }

    fun df(tag: String, msg: String, vararg args: Any) {
        log(tag, String.format(msg, *args), 1, null, null)
    }

    fun i(tag: String, msg: String) {
        log(tag, msg, 2, null, null)
    }

    fun w(tag: String, msg: String) {
        log(tag, msg, 3, null, null)
    }

    fun e(tag: String, msg: String, e: Throwable) {
        log(tag, msg, 4, e, null)
    }


    private fun log(tag: String, msg: String, logType: Int, e: Throwable?, tv: TextView?) {
        val stackTrace = Exception().stackTrace[2]

        var fileName: String? = stackTrace.fileName
        if (fileName == null) fileName = ""  // It is necessary if you want to use proguard obfuscation.

        val info = (stackTrace.methodName + " (" + fileName + ":"
                + stackTrace.lineNumber + ")")

        when (logType) {
            1 -> Log.d(tag, info + ": " + msg)
            2 -> Log.i(tag, info + ": " + msg)
            3 -> Log.w(tag, info + ": " + msg)
            4 -> Log.e(tag, info + ": " + msg, e)
            else -> Log.e(tag, info + "!!!Uroven logovani nerozpoznana!!!: " + msg)
        }

        if (tv != null) {
            tv.append("\n" + info + ": " + msg)
        }

    }
}


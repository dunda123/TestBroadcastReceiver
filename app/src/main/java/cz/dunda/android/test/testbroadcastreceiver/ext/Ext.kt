package cz.dunda.android.fc.testy.fctest.ext

fun Any.TAG(): String {
    return "XXX_" + this::class.java.name
}
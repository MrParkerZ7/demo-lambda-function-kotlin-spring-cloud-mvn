package puck.multi.module.mainmultimodulekts

import puck.multi.module.subamultimodulekts.subAPrint

fun mainPrint(str: String): String {
    val result = "MainPrint: $str | ${subAPrint(str)}"
    println(result)
    return result
}

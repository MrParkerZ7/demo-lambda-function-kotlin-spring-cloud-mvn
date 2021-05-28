package puck.multi.module.mainmultimodulekts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainServiceTest {

    @Test
    fun mainPrint() {
        assertEquals("MainPrint: Test", mainPrint("Test"))
    }
}
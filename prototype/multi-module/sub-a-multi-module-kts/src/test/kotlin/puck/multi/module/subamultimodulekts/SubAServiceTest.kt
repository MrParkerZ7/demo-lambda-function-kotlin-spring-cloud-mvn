package puck.multi.module.subamultimodulekts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SubAServiceTest {

    @Test
    fun subAPrint() {
        assertEquals("SubAPrint: Test", subAPrint("Test"))
    }
}
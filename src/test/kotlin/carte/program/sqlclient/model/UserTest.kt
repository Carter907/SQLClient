package carte.program.sqlclient.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun userInstanceTest(){
        var user: User = User("carte", "password")
        assertTrue(user.username == "carte")
        assertTrue(user.password == "password")
    }
}
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addShouldAssignNonZeroId() {
        val post = Post(
            ownerId = 1,
            fromId = 1,
            date = 1234567890,
            text = "Test post"
        )
        val addedPost = WallService.add(post)
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun updateExistingPostShouldReturnTrue() {
        val post = Post(
            ownerId = 1,
            fromId = 1,
            date = 1234567890,
            text = "Original post"
        )
        val addedPost = WallService.add(post)

        val updatedPost = addedPost.copy(text = "Updated text")
        val result = WallService.update(updatedPost)

        assertTrue(result)
    }

    @Test
    fun updateNonExistingPostShouldReturnFalse() {
        val post = Post(
            id = 999,
            ownerId = 1,
            fromId = 1,
            date = 1234567890,
            text = "Non-existing post"
        )
        val result = WallService.update(post)
        assertFalse(result)
    }
}
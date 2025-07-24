data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val canLike: Boolean = true
)

data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean = false,
    val postType: String = "post",
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val isPinned: Boolean = false,
    val comments: List<Comment> = emptyList()
)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }
}


fun main() {
    val post = WallService
    post.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
        true, true, true, 1 ))

}
data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Any,
    val copyright: Any,
    val likes: Any,
    val reposts: Any,
    val views: Any,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAdds: Boolean,
    val isFavorite: Boolean,
    val donut: Any,
    val postponedId: Int)


object WallService {
    private var posts = emptyArray<Post>()
    var id = 0

    fun add (post: Post): Post {
        posts += post
        id += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        return if (post.id == id) {
            val post = post.copy(ownerId = post.ownerId + 1, fromId = post.fromId + 1, createdBy = post.createdBy + 1,
                replyOwnerId = post.replyOwnerId + 1,replyPostId = post.replyPostId + 1, signerId = post.signerId + 1,
                postponedId = post.postponedId + 1)
            true
        } else {
            false
        }
    }
}







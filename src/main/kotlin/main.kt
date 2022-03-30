

fun main() {
    val posts = WallService
    var arrayOfAttachments = emptyArray<Attachment>()
    val video = AttachmentVideo( "Ржака! Смотреть до конца!")
    val text = AttachmentText("Чтобы похудеть надо всего лишь...")
    val photo = AttachmentPhoto("НА море")
    val link = AttachmentLink("самый быстрый VPN")

    arrayOfAttachments += video
    arrayOfAttachments += text
    arrayOfAttachments += photo
    arrayOfAttachments += link

    val post1 = posts.add(Post(0, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
        true, true, true, 1, 1, 1, null, arrayOfAttachments)
    )

    val post2 = posts.add(Post(0, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
        true, true, true, 1, 1, 1, null, arrayOfAttachments)
    )

    println(post1.id)
    println(post2.id)
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
    val postponedId: Int,
    val post_source: Any,
    val geo: Any,
    val copy_history: Array<Post>?,
    val attachment: Array<Attachment>
    )



object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1

    fun add(post: Post): Post {
        post.id = postId
        postId++
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post1) in posts.withIndex()) {
            return if (post.id == post1.id) {
                posts[index] = post.copy(
                    ownerId = post.ownerId + 1,
                    fromId = post.fromId + 1,
                    createdBy = post.createdBy + 1,
                    replyOwnerId = post.replyOwnerId + 1,
                    replyPostId = post.replyPostId + 1,
                    signerId = post.signerId + 1,
                    postponedId = post.postponedId + 1
                )
                true
            } else {
                false
            }
        }
        return false
    }
}







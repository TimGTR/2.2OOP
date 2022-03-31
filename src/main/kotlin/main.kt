fun main() {
    val posts = WallService
    var arrayOfAttachments = emptyArray<Attachment>()
    val video = AttachmentVideo("Ржака! Смотреть до конца!")
    val text = AttachmentText("Чтобы похудеть надо всего лишь...")
    val photo = AttachmentPhoto("НА море")
    val link = AttachmentLink("самый быстрый VPN")

    arrayOfAttachments += video
    arrayOfAttachments += text
    arrayOfAttachments += photo
    arrayOfAttachments += link

    val post1 = posts.add(
        Post(
            0,
            1,
            1,
            1,
            1,
            "1",
            1,
            1,
            true,
            1,
            1,
            1,
            1,
            1,
            "1",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            1,
            1,
            1,
            null,
            arrayOfAttachments
        )
    )

    val post2 = posts.add(
        Post(
            0,
            1,
            1,
            1,
            1,
            "1",
            1,
            1,
            true,
            1,
            1,
            1,
            1,
            1,
            "1",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            1,
            1,
            1,
            null,
            arrayOfAttachments
        )
    )

    val comment = Comment(
        1, 1, 1, "1", 1, 1, 1, video, arrayOfAttachments, 1
    )
    val comment1 = Comment(
        2, 1, 1, "1", 1, 1, 1, video, arrayOfAttachments, 1
    )
    val comment2 = Comment(
        500, 1, 1, "1", 1, 1, 1, video, arrayOfAttachments, 1
    )
    WallService.createComment(comment)
    WallService.createComment(comment1)
    WallService.createComment(comment2)
    println(WallService.comments.size)
    println(WallService.comments[1].id)
    println(WallService.comments[0].id)
}


object WallService {
    private var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
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

    fun createComment(comment: Comment) {
        for (post in posts) {
            try {
                if (comment.id == post.id) {
                    comments += comment
                }
            } catch (e: PostNotFoundException) {
                e.message
            }
        }
    }
}







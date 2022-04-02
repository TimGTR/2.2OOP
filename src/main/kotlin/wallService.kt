object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
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
        var count = comments.size
            for (post in posts) {
                if (comment.postId == post.id) {
                    comments += comment
                }
            }
        if (comments.size == count) {
            throw PostNotFoundException()
        }
    }


//    fun findPostId() {
//        for (post in posts) {
//            println("Post ID ${post.id}")
//        }
//    }
//
//    fun findpostIdComment() {
//        for (comment in comments) {
//            println("Comment ID ${comment.id}")
//        }
//    }

//    fun commentsSize(): Int {
//        return comments.size
//    }

}
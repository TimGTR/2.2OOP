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
    println(post1.id)
    println(post2.id)
    println()
//    WallService.createComment(comment)
//    WallService.createComment(comment1)
//    WallService.createComment(comment2)
//    println(WallService.comments.size)
//    println(WallService.comments[1].id)
//    println(WallService.comments[0].id)
}








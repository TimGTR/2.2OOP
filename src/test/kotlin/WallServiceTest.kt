

import org.junit.Test

import org.junit.Assert.*


class WallServiceTest {

    @Test
    fun addTest() {
        val service = WallService
        val video = AttachmentVideo("Ржака! Смотреть до конца!")
        val text = AttachmentText("Чтобы похудеть надо всего лишь...")
        val photo = AttachmentPhoto("НА море")
        val link = AttachmentLink( "самый быстрый VPN")
        val arrayOfAttachments = arrayOf(video, text, photo, link)
        service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null, arrayOfAttachments))

        var result = service.id

        assertNotEquals(0, result)
    }

    @Test
    fun updateTestTrue() {
        val service = WallService
        val video = AttachmentVideo( "Ржака! Смотреть до конца!")
        val text = AttachmentText("Чтобы похудеть надо всего лишь...")
        val photo = AttachmentPhoto("НА море")
        val link = AttachmentLink("самый быстрый VPN")
        val arrayOfAttachments = arrayOf(video, text, photo, link)
        service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null, arrayOfAttachments))
        service.add(Post(2, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null, arrayOfAttachments))
        val update = Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null,arrayOfAttachments)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateTestFalse() {
        val service = WallService
        val video = AttachmentVideo("Ржака! Смотреть до конца!")
        val text = AttachmentText("Чтобы похудеть надо всего лишь...")
        val photo = AttachmentPhoto("НА море")
        val link = AttachmentLink("самый быстрый VPN")
        val arrayOfAttachments = arrayOf(video, text, photo, link)
        service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null, arrayOfAttachments))
        service.add(Post(2, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null, arrayOfAttachments))
        val update = Post(3, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1, 1, 1, null,arrayOfAttachments)
        val result = service.update(update)
        assertFalse(result)
    }
}
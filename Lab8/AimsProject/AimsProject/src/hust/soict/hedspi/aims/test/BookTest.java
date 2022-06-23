package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {

        Book book4 = new Book(8, "The Pillow Book", "biography", 12, "Sei Shonagon");

        book4.setContent(
                "The work is a collection of essays, anecdotes, poems, and descriptive passages that have little connection to one another except for the fact that they are ideas and whims of Shonagon's spurred by moments in her daily life. In it she included lists of all kinds, personal thoughts, interesting events in court, poetry, and some opinions on her contemporaries.While it is mostly a personal work, Shonagon's writing and poetic skill makes it interesting as a work of literature, and it is valuable as a historical document. Shonagon meant her writing in The Pillow Book for her eyes only, but part of it was accidentally revealed to the Court during her life: she inadvertently left it [her writing] on a cushion she put out for a visiting guest, who eagerly carried it off despite her pleas.");
        book4.processContent();
        System.out.println(book4.toString());
    }

}

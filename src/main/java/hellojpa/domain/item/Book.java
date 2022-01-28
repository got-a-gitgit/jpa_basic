package hellojpa.domain.item;

import hellojpa.domain.item.Item;

import javax.persistence.Entity;

//Entity annotation 필요없나.
@Entity
public class Book extends Item {

    private String author;
    private String isbn;
}

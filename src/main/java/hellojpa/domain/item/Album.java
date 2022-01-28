package hellojpa.domain.item;

import hellojpa.domain.item.Item;

import javax.persistence.Entity;

//Entity annotation 필요없나.
@Entity
public class Album extends Item {

    private String artist;
}

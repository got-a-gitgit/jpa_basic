package hellojpa.domain.item;

import hellojpa.domain.item.Item;

import javax.persistence.Entity;

//Entity annotation 필요없나.
@Entity
public class Movie extends Item {

    private String director;
    private String actor;
}

package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//JPA가 로딩될 때 JPA를 사용하는 객체임을 알게되어서 관리해준다.
@Entity
public class Member {

    //primary key를 표시
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

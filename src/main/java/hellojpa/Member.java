package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//JPA가 로딩될 때 JPA를 사용하는 객체임을 알게되어서 관리해준다.
@Entity
//만약 db의 테이블명과 엔티티 명이 다를 경우 annotation을 이용해서 mapping 해줄 수 있다.
//@Table(name="USER")
public class Member {

    //primary key를 표시
    @Id
    private Long id;

    //db 테이블의 컬럼명과 변수명이 다를 경우 @Column annotation을 이용해서 mapping 해줄 수 있다.
    //@Column(name = "username")
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

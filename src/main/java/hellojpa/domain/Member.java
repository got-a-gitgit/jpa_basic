package hellojpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//JPA가 로딩될 때 JPA를 사용하는 객체임을 알게되어서 관리해준다.

//만약 db의 테이블명과 엔티티 명이 다를 경우 annotation을 이용해서 mapping 해줄 수 있다.
//@Table(name="USER")
@Entity
public class Member {

    public Member() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String userName;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @OneToOne
    @JoinColumn(name="locker_id")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //Entity Manager Factory를 생성
        //persistence.xml에서 설정한 persistenceUnitName을 요구한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA에서 데이터를 변경하는 모든 작업은 Transaction안에서 일어나야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");

        em.persist(member);

        tx.commit();

        em.close();
        emf.close();
    }
}

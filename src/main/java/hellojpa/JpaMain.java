package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //Entity Manager Factory를 생성
        //persistence.xml에서 설정한 persistenceUnitName을 요구한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA에서 데이터를 변경하는 모든 작업은 Transaction안에서 일어나야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //예외 처리를 Spring이 다 해주기 때문에 try-catch 문을 사용할 필요가 없다.
        try {
            /**
             * 등록
             */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

            /**
             * 조회
             */
//            Member findMember  = em.find(Member.class, 1L);
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getId() = " + findMember.getId());

            /**
             * 수정
             JPA를 통해 객체를 가져오게되면 그 객체는 JPA가 관리하게된다.
             tansaction을 commit하는 시점에 변경사항이있는지 체크하고
             변경사항이 있는 경우 commit전에 update 쿼리를 날린다.
             */
//            findMember.setName("HelloJPA");


            /**
             * JPQL
             */

            //전체 회원검색
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            //정상적일 땐 commit을 해주고
            tx.commit();
        } catch (Exception e) {
            //예외가 발생하면 transaction을 rollback
            tx.rollback();
        } finally {
            //내부적으로 Entity Manager가 DB connection을 물고 동작하기 때문에
            //사용후에는 꼭 닫아줘야한다.
            em.close();
        }
        emf.close();
    }
}

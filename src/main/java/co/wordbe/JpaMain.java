package co.wordbe;

import co.wordbe.shop.domain.Member;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);
            
            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1.getClass() = " + m1.getClass());

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            System.out.println(m1 == reference);

            System.out.println("--------- commit ---------");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static Member saveMember(EntityManager em) {
        Member member = new Member();
        member.setName("Tod");

        em.persist(member);
        return member;
    }
}

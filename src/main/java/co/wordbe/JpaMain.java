package co.wordbe;

import co.wordbe.shop.domain.cascade.Child;
import co.wordbe.shop.domain.cascade.Parent;
import co.wordbe.shop.domain.loading.Address;
import co.wordbe.shop.domain.loading.Member;
import co.wordbe.shop.domain.loading.Period;
import co.wordbe.shop.domain.loading.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("jack");
            member.setHomeAddress(new Address("city1", "street1", "10234"));
            member.setWorkPeriod(new Period());

            em.persist(member);

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

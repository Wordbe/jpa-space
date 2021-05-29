package co.wordbe;

import co.wordbe.shop.domain.jpql.Member;
import co.wordbe.shop.domain.jpql.MemberDTO;
import co.wordbe.shop.domain.jpql.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("Square");
            em.persist(team);

            Member member = new Member();
            member.setName("Jack");
            member.setAge(20);
            member.changeTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            List<Member> resultList = em.createQuery("select m from Member m join m.team t", Member.class)
                    .getResultList();
            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

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

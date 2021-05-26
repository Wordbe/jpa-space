package co.wordbe;

import co.wordbe.shop.domain.cascade.Child;
import co.wordbe.shop.domain.cascade.Parent;
import co.wordbe.shop.domain.loading.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

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

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity(new Address("city2", "street2", "20234")));
            member.getAddressHistory().add(new AddressEntity(new Address("city3", "street3", "30234")));

            em.persist(member);

            Member member1 = em.find(Member.class, member.getId());
            Set<String> favoriteFoods = member1.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
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

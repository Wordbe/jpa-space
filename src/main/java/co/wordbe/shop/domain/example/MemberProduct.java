package co.wordbe.shop.domain.example;

import co.wordbe.shop.domain.Member;

import javax.persistence.*;

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product product;
}

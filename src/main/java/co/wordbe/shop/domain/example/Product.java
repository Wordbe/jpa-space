package co.wordbe.shop.domain.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Product {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "product")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
}

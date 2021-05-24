package co.wordbe.shop.domain;

import co.wordbe.shop.domain.example.Delivery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "ORDERS") // order by 예약어와 겹칠 시 오류 발생 차단
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    @OneToOne
//    @JoinColumn(name = "DELIVERY_ID")
//    private Delivery delivery;



//    @Column(name = "MEMBER_ID")
//    private  Long memberId;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;
}

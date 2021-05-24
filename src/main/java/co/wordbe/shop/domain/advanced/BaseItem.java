package co.wordbe.shop.domain.advanced;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class BaseItem extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

package co.wordbe.shop.domain.advanced;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("M")
public class Movie extends BaseItem {

    private String director;
    private String actor;
}

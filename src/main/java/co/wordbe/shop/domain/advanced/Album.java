package co.wordbe.shop.domain.advanced;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter
@Entity
@DiscriminatorValue("A")
public class Album extends BaseItem {

    private String artist;
    private String etc;
}

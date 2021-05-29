package co.wordbe.shop.domain.jpql;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {

    private Long id;
    private String name;

    public MemberDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

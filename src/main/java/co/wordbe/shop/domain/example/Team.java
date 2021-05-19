package co.wordbe.shop.domain.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

//    // 양방향 매핑
//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>();

    // 단방향 1:N
//    @OneToMany
//    @JoinColumn(name = "TEAM_ID")
//    private List<Member> members = new ArrayList<>();
}

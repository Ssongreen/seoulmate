package seoulmate.project.domain;


import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Member {
	@Id
    private Long id;
    private String email;
    private String password;
    private String name;

    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}

package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostThread {

    @Size(min = 1, max = 30, message = "Name size must be between {min} and {max}")
    private String nickname;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 6, message = "Verification Code size must be between {min} and {max}")
    private String captcha;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20, message = "Password size must be between {min} and {max}")
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 5000, message = "Content size must be between {min} and {max}")
    private String content;

}

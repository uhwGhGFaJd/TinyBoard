package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Getter
@Setter
public class PostReply {

    @Min(value = 1, message = "Thread Id must be greater than or equal to {value}")
    private int thread_id;

    @Size(min = 1, max = 30, message = "Name size must be between {min} and {max}")
    private String nickname;

    @NotNull(message = "Password must not be null")
    @NotBlank(message = "Password must not be blank")
    @Size(min = 1, max = 20, message = "Password size must be between {min} and {max}")
    private String password;

    @NotNull(message = "Content must not be null")
    @NotBlank(message = "Content must not be blank")
    @Size(min = 1, max = 5000, message = "Content size must be between {min} and {max}")
    private String content;

    @NotNull(message = "Verification Code must not be null")
    @NotBlank(message = "Verification Code must not be blank")
    @Size(min = 1, max = 6, message = "Verification Code size must be between {min} and {max}")
    private String captcha;

}

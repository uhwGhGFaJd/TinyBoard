package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ManageCheck {

    @NotNull(message = "Authentication Code must not be null")
    @NotBlank(message = "Authentication Code must not be blank")
    private String authPassword;

    @NotNull(message = "Verification Code must not be null")
    @NotBlank(message = "Verification Code must not be blank")
    @Size(min = 1, max = 6, message = "Verification Code size must be between {min} and {max}")
    private String captcha;
}

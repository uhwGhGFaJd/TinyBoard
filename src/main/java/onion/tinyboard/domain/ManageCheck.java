package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ManageCheck {

    @NotNull
    @NotBlank
    private String authPassword;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 6)
    private String captcha;
}

package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/18
 * Github       : https://github.com/uhwGhGFaJd
 */
@Getter
@Setter
public class ChangePassword {

    @NotNull(message = "New Password must not be null")
    @NotBlank(message = "New Password must not be blank")
    @Size(min = 1, max = 20, message = "New Password size must be between {min} and {max}")
    private String newPassword;

    @NotNull(message = "Confirm Password must not be null")
    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 1, max = 20, message = "Confirm Password size must be between {min} and {max}")
    private String confirmPassword;
}

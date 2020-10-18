package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DeleteThread {

    @Min(value = 0, message = "Post Id must be greater than or equal to {value}")
    private int thread_id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20, message = "Post Password size must be between {min} and {max}")
    private String thread_password;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 6, message = "Verification Code size must be between {min} and {max}")
    private String thread_captcha;
}

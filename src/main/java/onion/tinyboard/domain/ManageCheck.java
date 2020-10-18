package onion.tinyboard.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ManageCheck {

    @NotNull
    @NotBlank
    private String authpassword;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 6)
    private String captcha;

    public String getAuthpassword() {
        return authpassword;
    }

    public void setAuthpassword(String authpassword) {
        this.authpassword = authpassword;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}

package onion.tinyboard.captcha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CaptchaController {

    @GetMapping("captcha")
    public void captchaImg(HttpServletRequest request, HttpServletResponse response) {
        new CaptchaUtil().captchaImg(request, response);
    }

}

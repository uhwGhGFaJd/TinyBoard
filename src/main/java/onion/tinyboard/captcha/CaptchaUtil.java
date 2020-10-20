package onion.tinyboard.captcha;


import jj.play.ns.nl.captcha.Captcha;
import jj.play.ns.nl.captcha.backgrounds.GradiatedBackgroundProducer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaUtil {
    public void captchaImg(HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = new Captcha.Builder(200, 50)
                .addText()
                .addBackground(new GradiatedBackgroundProducer())
                .addNoise()
                .build();

        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Max-Age", 0);
        response.setContentType("image/png");

        request.getSession().setAttribute("captcha", captcha.getAnswer());
        CaptchaServletUtil.writeImage(response, captcha.getImage());
    }
}

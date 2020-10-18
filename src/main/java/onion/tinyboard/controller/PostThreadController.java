package onion.tinyboard.controller;


import onion.tinyboard.domain.PostThread;
import onion.tinyboard.service.PostThreadService;
import onion.tinyboard.utils.AlertUtil;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Controller
public class PostThreadController {

    private final AlertUtil alertUtil;

    private final PostThreadService postThreadService;

    public PostThreadController(AlertUtil alertUtil, PostThreadService postThreadService) {

        this.alertUtil = alertUtil;
        this.postThreadService = postThreadService;
    }

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping("post")
    public String WritePost(@Valid PostThread postThread, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        String getCaptchaCode = (String) req.getSession().getAttribute("captcha");

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()));
            return "redirect:/";
        } else if (!postThread.getCaptcha().equals(getCaptchaCode)) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Verification Code does not matched"));
            return "redirect:/";
        }

        postThreadService.insertNewThread(postThread);
        return "redirect:/";
    }

}

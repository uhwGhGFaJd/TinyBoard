package onion.tinyboard.controller;

import onion.tinyboard.domain.PostReply;
import onion.tinyboard.service.ThreadReplyService;
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
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Controller
public class ThreadReplyPostController {

    private final AlertUtil alertUtil;
    private final ThreadReplyService threadReplyService;


    public ThreadReplyPostController(AlertUtil alertUtil, ThreadReplyService threadReplyService) {
        this.alertUtil = alertUtil;
        this.threadReplyService = threadReplyService;
    }

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @PostMapping("reply/post")
    public String PostThreadReply(@Valid PostReply postReply, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()));
            return "redirect:/thread/" + postReply.getThread_id();
        } else if (!postReply.getCaptcha().equals(req.getSession().getAttribute("captcha").toString())) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Verification Code does not matched"));
            return "redirect:/thread/" + postReply.getThread_id();
        }

        threadReplyService.insertThreadReply(postReply);
        return "redirect:/thread/" + postReply.getThread_id();
    }


}

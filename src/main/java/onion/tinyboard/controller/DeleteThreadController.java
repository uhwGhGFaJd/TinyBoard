package onion.tinyboard.controller;

import onion.tinyboard.domain.DeleteThread;
import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.service.DeleteThreadService;
import onion.tinyboard.utils.AlertUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
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
public class DeleteThreadController {

    private final AlertUtil alertUtil;

    private final DeleteThreadService deleteThreadService;

    public DeleteThreadController(AlertUtil alertUtil, DeleteThreadService deleteThreadService) {
        this.alertUtil = alertUtil;
        this.deleteThreadService = deleteThreadService;
    }

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("delete")
    public String deletePost() {

        return "page/deletepost/deletepost";
    }

    @PostMapping("delete/post")
    public String deletePostSubmit(@Valid DeleteThread deleteThread, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        String getCaptchaCode = (String) req.getSession().getAttribute("captcha");

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("deletePost", deleteThread);
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()));
            return "redirect:/delete";
        } else if (!deleteThread.getThread_captcha().equals(getCaptchaCode)) {
            redirectAttributes.addFlashAttribute("deletePost", deleteThread);
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Verification Code does not matched"));
            return "redirect:/delete";
        }

        GetDeleteThreadInfo getDeleteThreadInfo = deleteThreadService.getDeleteThreadInfo(deleteThread.getThread_id());
        if (getDeleteThreadInfo == null) {
            redirectAttributes.addFlashAttribute("deletePost", deleteThread);
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Post Id Not Found"));
            return "redirect:/delete";
        } else if (!BCrypt.checkpw(deleteThread.getThread_password(), getDeleteThreadInfo.getThread_password())) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Password does not matched"));
            return "redirect:/delete";
        }

        deleteThreadService.deleteThread(deleteThread.getThread_id());
        redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("success", "Deleted"));
        return "redirect:/delete";

    }
}

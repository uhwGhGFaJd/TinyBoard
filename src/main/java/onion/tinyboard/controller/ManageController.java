package onion.tinyboard.controller;


import onion.tinyboard.domain.ManageCheck;
import onion.tinyboard.domain.ServerConfig;
import onion.tinyboard.service.ListOfThreadService;
import onion.tinyboard.service.ManageService;
import onion.tinyboard.utils.AlertUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Controller
public class ManageController {

    private final AlertUtil alertUtil;
    private final ManageService manageService;
    private final ListOfThreadService listOfThreadService;

    public ManageController(AlertUtil alertUtil, ManageService manageService, ListOfThreadService listOfThreadService) {
        this.alertUtil = alertUtil;
        this.manageService = manageService;
        this.listOfThreadService = listOfThreadService;
    }

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @GetMapping("manage")
    public String manageAuth() {
        return "page/manage/authpage";
    }

    @PostMapping("manage/check")
    public String manageAuthCheck(@Valid ManageCheck manageCheck, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session,
                                  HttpServletRequest req) {

        if (manageSessionsCheck(session)) {
            return "redirect:/manage/index";
        }

        String getCaptchaCode = (String) req.getSession().getAttribute("captcha");

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()));
            return "redirect:/manage";
        } else if (!manageCheck.getCaptcha().equals(getCaptchaCode)) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Verification Code does not matched"));
            return "redirect:/manage";
        }

        if (!BCrypt.checkpw(manageCheck.getAuthPassword(), manageService.getServerConfigValue(3))) {
            redirectAttributes.addFlashAttribute("msg", alertUtil.makeAlert("danger", "Access denied"));
            return "redirect:/manage";
        } else {
            req.getSession().setAttribute("AdminState", true);
            return "redirect:/manage/index";
        }
    }

    @GetMapping("manage/index")
    public String adminPage(Model model) {

        List<ServerConfig> serverConfigList = manageService.getServerConfig();
        for (ServerConfig serverConfig : serverConfigList) {
            model.addAttribute(serverConfig.getConfig_name(), serverConfig.getConfig_value());
        }
        model.addAttribute("thread_count", listOfThreadService.totalThreadCount());

        return "page/manage/index";
    }


    @GetMapping("manage/function/{mode}")
    public String adminFunction(@PathVariable String mode, Model model) {

        String title = null;

        switch (mode) {
            case "enabledserver":
                title = "Enabled server";
                break;
            case "disableserver":
                title = "Disable server";
                break;
            case "enabledposting":
                title = "Enabled Posting";
                break;
            case "disableposting":
                title = "Disable Posting";
                break;
            case "deleteallarticle":
                title = "Delete All Threads";
                break;
        }
        model.addAttribute("mode", mode);
        model.addAttribute("title", title);
        return "page/manage/adminfunction";
    }

    @PostMapping("manage/function/{mode}/confirm")
    public String adminFunctionConfirm(@PathVariable String mode) {


        switch (mode) {
            case "enabledserver":
                manageService.changeServerState("enabled");
                break;
            case "disableserver":
                manageService.changeServerState("disabled");
                break;
            case "enabledposting":
                manageService.changePostingState("enabled");
                break;
            case "disableposting":
                manageService.changePostingState("disabled");
                break;
            case "deleteallarticle":
                manageService.deleteAllArticle();
                break;
        }


        return "redirect:/manage/index";
    }


    private boolean manageSessionsCheck(HttpSession session) {
        return session.getAttribute("AdminState") != null;
    }

}

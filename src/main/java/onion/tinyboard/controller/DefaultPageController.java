package onion.tinyboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Controller
public class DefaultPageController {

    @RequestMapping("/403")
    public String page403() {

        return "page/httppage/403";
    }

    @RequestMapping("/maintenance")
    public String pageMaintenance() {

        return "page/httppage/maintenance";
    }

    @RequestMapping("/disabledposting")
    public String pageDisabledPosting() {

        return "page/httppage/disabledposting";
    }
}

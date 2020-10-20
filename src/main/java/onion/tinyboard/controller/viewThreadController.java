package onion.tinyboard.controller;

import onion.tinyboard.service.ViewThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Controller
public class viewThreadController {

    private final ViewThreadService viewThreadService;

    public viewThreadController(ViewThreadService viewThreadService) {
        this.viewThreadService = viewThreadService;
    }

    @GetMapping("thread/{thread_id}")
    public String viewThread(@PathVariable int thread_id, Model model){
        Map<String, Object> data = viewThreadService.getThreadInfo(thread_id);


        model.addAttribute("threadInfo", data.get("threadInfo"));
        return "page/viewThread/index";
    }


}

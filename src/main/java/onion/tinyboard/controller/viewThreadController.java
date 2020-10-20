package onion.tinyboard.controller;

import onion.tinyboard.service.ThreadService;
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

    private final ThreadService threadService;

    public viewThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }


    @GetMapping("thread/{thread_id}")
    public String viewThread(@PathVariable int thread_id, Model model) {
        Map<String, Object> data = threadService.getThreadInfo(thread_id);


        model.addAttribute("threadInfo", data.get("threadInfo"));
        return "page/viewThread/index";
    }


}

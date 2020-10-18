package onion.tinyboard.controller;


import onion.tinyboard.domain.ListThread;
import onion.tinyboard.service.ListOfThreadService;
import onion.tinyboard.utils.PagingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;


/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Controller
public class ThreadIndexController {

    private final ListOfThreadService listOfThreadService;

    private final PagingUtil pagingUtil;

    public ThreadIndexController(ListOfThreadService listOfThreadService, PagingUtil pagingUtil) {
        this.listOfThreadService = listOfThreadService;
        this.pagingUtil = pagingUtil;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1") int page) {
        Map<String, Object> data = new WeakHashMap<>();

        int rowNum = 10, totalPage = 0, startPage = (page - 1) * rowNum;

        data.put("startPage", startPage);
        data.put("rowNum", rowNum);

        int totalCount = listOfThreadService.totalThreadCount();
        if (totalCount != 0) {
            totalPage = pagingUtil.pageCount(rowNum, totalCount);
        }
        if (totalPage < page) {
            totalPage = page;
        }

        List<ListThread> threadList = listOfThreadService.ListThread(data);

        model.addAttribute("pagination", pagingUtil.getPaging(page, totalPage, ""));
        model.addAttribute("threadList", threadList);

        return "page/index";
    }
}

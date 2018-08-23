package pl.sda.co_na_obiad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String getIndex() {
        return "index";
    }
}

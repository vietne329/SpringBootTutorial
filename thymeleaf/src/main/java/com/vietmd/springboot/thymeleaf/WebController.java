package com.vietmd.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about") // Nếu người dùng request tới địa chỉ "/about"
    public String about() {
        return "about"; // Trả về file about.html
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name",required = false, defaultValue = "default user") String name,Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Mai Dac Viet"));
        profile.add(new Info("nickname", "vietmd"));
        profile.add(new Info("gmail", "vietmd329@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/vietne329"));
        profile.add(new Info("website", "https://loda.me"));

        model.addAttribute("vietProfile",profile);
        return "profile";
    }
}

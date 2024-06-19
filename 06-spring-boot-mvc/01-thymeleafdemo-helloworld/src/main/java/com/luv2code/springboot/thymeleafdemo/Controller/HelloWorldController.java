package com.luv2code.springboot.thymeleafdemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld" ;
    }

//    @RequestMapping("/processFormVersionTwo")
//    public String letsShout(HttpServletRequest request, Model model){
//
//        String name=request.getParameter("studentName");
//        name=name.toUpperCase();
//        String res="Yo! "+name;
//        model.addAttribute("message",res);
//
//        return "helloworld";
//    }


    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){


        name=name.toUpperCase();
        String res="hey there! "+name;
        model.addAttribute("message",res);

        return "helloworld";
    }
}

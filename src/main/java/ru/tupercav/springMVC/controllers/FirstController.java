package ru.tupercav.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastname");
        model.addAttribute("message", "hello pidoras" + name + " " + lastName);
        model.addAttribute("lastname", lastName);
         return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "lastname", required = false) String lastName) {
        System.out.println("Poshel nahui " + lastName + " " + name);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorMethod (@RequestParam(value = "firstdigit", required = false) int x,
                                    @RequestParam(value = "seconddigit",required = false) int y,
                                    @RequestParam(value = "action", required = false) String action,
                                    Model model) {
        if (action.equals("multiplication")) {
            model.addAttribute("result", (x*y));
            System.out.println(x*y);
        } else if (action.equals("addition")) {
            model.addAttribute("result", (x+y));
            System.out.println(x+y);
        } else if (action.equals("subtraction")) {
            model.addAttribute("result", (x - y));
            System.out.println(x-y);
        } else if (action.equals("division")) {
            model.addAttribute("result", (x / y));
            System.out.println(x / y);
        }
        return "first/calculator";
    }
}
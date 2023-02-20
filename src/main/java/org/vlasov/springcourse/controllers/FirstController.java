package org.vlasov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a") int a,
                       @RequestParam(value = "b") int b,
                       @RequestParam(value = "action") String action,
                       Model model) {
        double result;

        if("multiplication".equals(action)) {
            result = (double) a * b;
            model.addAttribute("result", result);
        } else if ("addition".equals(action)) {
            result = (double) a + b;
            model.addAttribute("result", result);
        } else if ("subtraction".equals(action)) {
            result = (double) a - b;
            model.addAttribute("result", result);
        } else if ("division".equals(action)) {
            result = (double) a / b;
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", 0);
        }

        return "first/calc";
    }
}

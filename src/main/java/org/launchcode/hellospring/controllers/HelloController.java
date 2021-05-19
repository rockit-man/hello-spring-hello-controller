package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() { return "Hello, Spring!"; }

    // Handles request at path /goodbye
    // Lives at /hello/goodbye

    @GetMapping("goodbye")
    public String goodbye() { return "Goodbye, Spring!"; }

    // Handles request of the form /hello?name=LaunchCode
    // Lives at /hello/hello

//    @GetMapping("hello")
//    @PostMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " + name + "!"; }

    // Handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) { return "Hello, " + name + "!"; }

    // Handles request of the form submission
    // Lives at /hello/form

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
            "<body>" +
            "<form action='/hello' method='post'>" + // submit a request to /hello
            "<input type='text' name='name'>" +
            "<input type='submit' value='Greet me!'>" +
            "</form>" +
            "</body>" +
            "</html>";
    }
}

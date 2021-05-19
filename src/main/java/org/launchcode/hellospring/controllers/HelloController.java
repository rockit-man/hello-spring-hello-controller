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

//    @GetMapping("goodbye")
//    public String goodbye() { return "Goodbye, Spring!"; }

    // Handles request of the form /hello?name=LaunchCode
    // Lives at /hello/hello

//    @GetMapping("hello")
//    @PostMapping("hello")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " + name + "!"; }

    // Handles requests of the form /hello/LaunchCode

//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) { return "Hello, " + name + "!"; }

    // Handles request of the form submission
    // Lives at /hello/form

//    @GetMapping("form")
//    @RequestMapping(method = RequestMethod.GET)
//    public String helloForm() {
//        return "<html>" +
//            "<body>" +
//            "<form action='/hello' method='post'>" + // submit a request to /hello
//            "<input type='text' name='name'>" +
//            "<input type='submit' value='Greet me!'>" +
//            "</form>" +
//            "</body>" +
//            "</html>";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloForm() {
        return "<form method='post'>" +
                "<input type='text' name='name'>" +
                "<select name = 'language'>" +
                "<option value = 'english'> English </options>" +
                "<option value = 'french'> French </options>" +
                "<option value = 'italian'> Italian </options>" +
                "<option value = 'spanish'> Spanish </options>" +
                "<option value = 'german'> German </options>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!'/>" +
                "</form>";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createMessage(@RequestParam String name, @RequestParam String language) {

        if (name == null) {
            name = "World";
        }

        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello, ";
        } else if (language.equals("french")) {
            greeting = "Boujour, ";
        } else if (language.equals("italian")) {
            greeting = "Ciao, ";
        } else if (language.equals("spanish")) {
            greeting = "¡Hola, ";
        } else if (language.equals("german")) {
            greeting = "Hallo, ";
        }

        return greeting + name + "!";
    }
}

package net.claztec.grboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by Derek Choi on 15. 4. 11.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "welcome");

        return "index";
    }
}

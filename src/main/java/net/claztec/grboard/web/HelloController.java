package net.claztec.grboard.web;

import net.claztec.grboard.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Derek Choi on 15. 4. 11.
 */

@Controller
public class HelloController {

    @Autowired
    private ArticleDao articleDao;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String helloToText() {
        return "hello";
    }

    @RequestMapping(value = "/hello.json")
    @ResponseBody
    public Object helloToJson() {
        Map<String, Object> model = new HashMap<>();
        model.put("time", new Date());
        model.put("message", "welcome");
        String title = articleDao.getTest();
        model.put("title", title);
        return model;
    }

    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "welcome");
        String title = articleDao.getTest();
        model.put("title", title);
        return "index";
    }

    @RequestMapping(value = "/index.do")
    public ModelAndView index2() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("time", new Date());
        mav.addObject("message", "welcom~~~~");
        mav.addObject("title", "title");
        mav.setViewName("index");
        return mav;
    }

}

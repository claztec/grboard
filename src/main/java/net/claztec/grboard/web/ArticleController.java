package net.claztec.grboard.web;

import net.claztec.grboard.model.Article;
import net.claztec.grboard.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Derek Choi on 15. 4. 26.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles", method = {RequestMethod.GET})
    public String getArticles(Model model) {
        List<Article> articleList = articleService.getArticleListAll();
        model.addAttribute("articles", articleList);
        return "index";
    }

    @RequestMapping(value = "/articles", method = {RequestMethod.POST})
    public String addArticle(@ModelAttribute @Valid Article article, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            Map<String, String> errorMap = new HashMap<String, String>();

            for (ObjectError error : errors) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError)error;
                    String field = fieldError.getField();
                    String message = fieldError.getDefaultMessage();
                    errorMap.put(field, message);
                }
            }

            model.addAttribute("error", errorMap);
            model.addAttribute("article", article);

            List<Article> articleList = articleService.getArticleListAll();
            model.addAttribute("articles", articleList);
            return "index";
        } else {
            articleService.addArticle(article);
            return "redirect:/articles";
        }
    }


}

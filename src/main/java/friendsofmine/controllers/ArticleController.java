package friendsofmine.controllers;

import friendsofmine.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("articles", articleService.findAllArticles());
        return "articles";
    }

}


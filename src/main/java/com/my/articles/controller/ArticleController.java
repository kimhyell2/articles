package com.my.articles.controller;

import com.my.articles.service.ArticleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("articles")
public class ArticleController {
private final ArticleService articleService;

    @GetMapping("")
    public String showAllArticles(Model model)
    {model.addAttribute("lists", articleService.findAll());
        return "/articles/show_all";
    }

    @GetMapping("new")
    public String newArticle(){
        return "/articles/new";
    }

    @PostMapping("create")
    public String createArticle(){
        return "redirect:articles";
    }

    @GetMapping("{id}")
    public String showOneArticle(){
        return "/articles/show";
    }

    @GetMapping("{id}/update")
    public String viewUpdatedArticle(){
        return "/articles/update";
    }

    @PostMapping("update")
    public String updateArticle(){
        return "redirect:articles";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(){
        return "redirect:articles";
    }
}

package com.my.articles.controller;

import com.my.articles.dto.ArticleDto;
import com.my.articles.service.ArticleService;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
    @GetMapping("{id}")
    public String showOneArticle(@PathVariable("id") Long id, Model model){
        ArticleDto dto = articleService.findById(id);
        model.addAttribute("dto", dto);
        log.info("==============="+dto.toString());
        return "/articles/show";
    }

    @GetMapping("new")
    public String newArticle(){
        return "/articles/new";
    }

    @PostMapping("create")
    public String createArticle(){
        return "redirect:articles";
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

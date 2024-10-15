package com.my.articles.controller;

import com.my.articles.dto.ArticleDto;
import com.my.articles.service.ArticleService;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

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
    public String newArticle(Model model){
        model.addAttribute("dto", new ArticleDto());
        return "/articles/new";
    }

    @PostMapping("create")
    public String createArticle(ArticleDto dto){
        articleService.insertArticle(dto);
        return "redirect:/articles";
    }

    @GetMapping("{id}/update")
    public String viewUpdatedArticle(@PathVariable("id")Long id, Model model) {
        model.addAttribute("dto",articleService.findById(id));
        return "/articles/update";
    }

    @PostMapping("update")
    public String updateArticle(ArticleDto dto){
        String url = "redirect:" + dto.getId();
        articleService.updateArticle(dto);
        return url;
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        articleService.deleteArticle(id);
        redirectAttributes.addFlashAttribute("msg","정상적으로 삭제되었습니다");
        return "redirect:/articles";
    }
}

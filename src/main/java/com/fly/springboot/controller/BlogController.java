package com.fly.springboot.controller;

import com.fly.springboot.entity.EsBlog;
import com.fly.springboot.repository.EsblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: fly
 * @Description: Blog控制层
 * @Date: 2018/5/6 20:29
 * @Modified By:
 **/
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsblogRepository esblogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam("title") String title,
         @RequestParam("summary") String summary,
         @RequestParam("content") String content,
         @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Page<EsBlog> page = esblogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
                title, summary, content, PageRequest.of(pageIndex, pageSize));
        return page.getContent();
    }
}

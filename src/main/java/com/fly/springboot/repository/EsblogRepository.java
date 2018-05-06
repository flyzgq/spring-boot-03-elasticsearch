package com.fly.springboot.repository;

import com.fly.springboot.entity.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther: fly
 * @Description: 博客资源库
 * @Date: 2018/5/6 18:05
 * @Modified By:
 **/
public interface EsblogRepository extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询博客(去重)
     * @param title     标题
     * @param summary   摘要
     * @param content   正文
     * @param pageable  分页参数
     * @return
     */
   Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}

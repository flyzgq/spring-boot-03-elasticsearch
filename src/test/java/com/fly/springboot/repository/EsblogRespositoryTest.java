package com.fly.springboot.repository; 

import com.fly.springboot.entity.EsBlog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* EsblogRespositoryW Tester. 
* 
* @author fly 
* @since <pre>五月 6, 2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsblogRespositoryTest {

    @Autowired
    private EsblogRepository esblogRepository;

    @Before
    public void initEsblogRepositoryData(){
        //清除数据
        esblogRepository.deleteAll();
        esblogRepository.save(new EsBlog("登黄雀楼", "王之涣的登黄雀楼",
                "白日依山尽，黄河入海流，欲穷千里目，更上一层楼。"));
        esblogRepository.save(new EsBlog("相思","王维的相思",
                "红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
        esblogRepository.save(new EsBlog("静夜思","李白的静夜思",
                "床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Pageable pageable = PageRequest.of(0, 20);
        Page<EsBlog> esBlogs = esblogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        Assert.assertEquals(esBlogs.getTotalElements(),2);
        System.out.println("********************Start***************************");
        for (EsBlog blog : esBlogs){
            System.out.println(blog);
        }
        System.out.println("********************End***************************");
    }



}

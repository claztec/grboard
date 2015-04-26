package net.claztec.grboard.web;

import net.claztec.grboard.Application;
import net.claztec.grboard.config.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Derek Choi on 15. 4. 26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockServletContext.class})
@WebAppConfiguration
public class ArticleControllerTest {
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    /**
     * get /articles
     * get /articles/{id}
     * post /articles
     * put/post /articles/{id}
     * delete/post /articles/{id}
     */

//   validation
//    http://egloos.zum.com/springmvc/v/509029

//    @Test
//    public void getArticles() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/articles").accept(MediaType.TEXT_HTML))
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void addArticle() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.post("/articles")
//                .param("title", "테스트 타이틀").param("contents", "테스트 내용")).andExpect(status().isOk());
//    }
}

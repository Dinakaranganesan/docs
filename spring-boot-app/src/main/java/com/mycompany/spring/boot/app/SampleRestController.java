/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bas200181
 */
@RestController
public class SampleRestController {
    @GetMapping("/userPosts")
    public List<Post> getUsersPost(){
        Post[] post=new RestTemplate().getForObject(URI.create("https://jsonplaceholder.typicode.com/posts"), Post[].class);
        return Arrays.asList(post);
        
    }
    private static class Post{
        private int userId;
        private int it;
        private String title;
        private String body;

        public Post() {
        }

        public Post(int userId, int it, String title, String body) {
            this.userId = userId;
            this.it = it;
            this.title = title;
            this.body = body;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getIt() {
            return it;
        }

        public void setIt(int it) {
            this.it = it;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
        
    }
    
}

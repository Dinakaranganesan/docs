/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.bassure.subscription.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author bas200181
 */
public class TestApp extends AppApplicationTests{
    @Autowired
    WebApplicationContext applicationContext;
    
    private MockMvc mvc;
    
}

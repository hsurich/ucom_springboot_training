package com.uuu.demo.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Message message;

    @RequestMapping("/hello")
    Message home() {
        //Message message = new Message();
        message.setId(888);
        message.setName("資訊錯誤");
        return message;
    }
}


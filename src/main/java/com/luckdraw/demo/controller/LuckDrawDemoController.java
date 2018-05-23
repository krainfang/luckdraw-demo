package com.luckdraw.demo.controller;

import com.alibaba.fastjson.JSON;
import com.luckdraw.demo.service.LuckDrawService;
import com.luckdraw.demo.vo.LuckDrawVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckDrawDemoController {

    @Autowired
    private LuckDrawService luckDrawService;

    @RequestMapping("/luckDraw")
    public String luckDraw() {
        LuckDrawVo luckDraw = new LuckDrawVo();
        luckDraw.setUserId(123);
        luckDraw.setUserName("111");
        luckDraw.setUserMobile("123");
        luckDraw.setPaId(5L);
        return JSON.toJSONString(luckDrawService.luckDraw(luckDraw));
    }
}

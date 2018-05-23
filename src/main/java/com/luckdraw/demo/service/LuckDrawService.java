package com.luckdraw.demo.service;

import com.luckdraw.demo.vo.LuckDrawVo;

import java.util.Map;

public interface LuckDrawService {

    Map<String, Object> luckDraw(LuckDrawVo luckDraw);
}

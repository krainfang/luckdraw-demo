package com.luckdraw.demo.service;

import com.luckdraw.demo.entity.PrizeCategorie;
import com.luckdraw.demo.entity.PrizeList;

import java.util.List;

public interface OtherService {
    PrizeList GetPrizeList(Long paId, Long plId);

    List<PrizeCategorie> GetCategories(Long paId);

    List<PrizeList> GetPrizeListByPaCode(Long paId);
}

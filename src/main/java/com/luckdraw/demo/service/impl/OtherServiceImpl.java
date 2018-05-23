package com.luckdraw.demo.service.impl;

import com.luckdraw.demo.entity.PrizeCategorie;
import com.luckdraw.demo.entity.PrizeList;
import com.luckdraw.demo.mapper.PrizeCategorieMapper;
import com.luckdraw.demo.mapper.PrizeListMapper;
import com.luckdraw.demo.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("otherService")
public class OtherServiceImpl implements OtherService {

    @Autowired
    private PrizeListMapper prizeListMapper;
    @Autowired
    private PrizeCategorieMapper prizeCategorieMapper;

    @Override
    public PrizeList GetPrizeList(Long paId, Long plId) {
        PrizeList param = new PrizeList();
        param.setPaId(paId);
        param.setPlId(plId);
        return prizeListMapper.GetPrizeList(param);
    }

    @Override
    public List<PrizeCategorie> GetCategories(Long paId) {
        return prizeCategorieMapper.GetCategories(paId);
    }

    @Override
    public List<PrizeList> GetPrizeListByPaCode(Long paId) {
        return prizeListMapper.GetPrizeListByPaCode(paId);
    }
}

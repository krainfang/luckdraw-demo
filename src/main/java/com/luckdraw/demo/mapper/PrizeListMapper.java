package com.luckdraw.demo.mapper;

import com.luckdraw.demo.entity.PrizeList;

import java.util.List;

public interface PrizeListMapper {
    int deleteByPrimaryKey(Long plId);

    int insert(PrizeList record);

    int insertSelective(PrizeList record);

    PrizeList selectByPrimaryKey(Long plId);

    int updateByPrimaryKeySelective(PrizeList record);

    int updateByPrimaryKeyWithBLOBs(PrizeList record);

    int updateByPrimaryKey(PrizeList record);

    List<PrizeList> GetPrizeListByPaCode(Long paId);

    PrizeList GetPrizeList(PrizeList param);
}
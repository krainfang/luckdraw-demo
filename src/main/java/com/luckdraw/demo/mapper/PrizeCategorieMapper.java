package com.luckdraw.demo.mapper;

import com.luckdraw.demo.entity.PrizeCategorie;

import java.util.List;

public interface PrizeCategorieMapper {
    int deleteByPrimaryKey(Long pcId);

    int insert(PrizeCategorie record);

    int insertSelective(PrizeCategorie record);

    PrizeCategorie selectByPrimaryKey(Long pcId);

    int updateByPrimaryKeySelective(PrizeCategorie record);

    int updateByPrimaryKey(PrizeCategorie record);

    List<PrizeCategorie> GetCategories(Long paId);
}
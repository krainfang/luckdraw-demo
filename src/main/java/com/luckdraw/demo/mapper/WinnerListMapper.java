package com.luckdraw.demo.mapper;

import com.luckdraw.demo.entity.WinnerList;

public interface WinnerListMapper {
    int deleteByPrimaryKey(Long wlId);

    int insert(WinnerList record);

    int insertSelective(WinnerList record);

    WinnerList selectByPrimaryKey(Long wlId);

    int updateByPrimaryKeySelective(WinnerList record);

    int updateByPrimaryKey(WinnerList record);
}
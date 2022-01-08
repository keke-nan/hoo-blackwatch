package com.holmes.hoo.blackwatch.service;

import com.holmes.hoo.blackwatch.model.vo.LogisticsDetailInfo;

/**
 * @author A20019
 * @since 2022/1/8 10:48
 */
public interface LogisticsService {

    LogisticsDetailInfo getLogisticsInfo(String no);
}

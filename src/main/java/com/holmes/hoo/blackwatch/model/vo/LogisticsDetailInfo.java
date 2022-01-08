package com.holmes.hoo.blackwatch.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author A20019
 * @since 2022/1/8 17:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsDetailInfo {

    private String number;

    private String type;

    private List<LogisticsDetailVO> list;

    private String deliverystatus;

    private String issign;

    private String expName;

    private String expSite;

    private String expPhone;

    private String courier;

    private String courierPhone;

    private String updateTime;

    private String takeTime;

    private String logo;

}

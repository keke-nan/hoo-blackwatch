package com.holmes.hoo.blackwatch.controller;

import com.holmes.hoo.blackwatch.model.entity.Result;
import com.holmes.hoo.blackwatch.model.vo.LogisticsDetailInfo;
import com.holmes.hoo.blackwatch.service.LogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author A20019
 * @since 2022/1/6 20:40
 */
@Slf4j
@RestController
@RequestMapping(value = "/logistics")
@Api(tags = "Logistics API")
public class LogisticsController {

    @Resource
    private LogisticsService logisticsService;

    @ApiOperation(value = "")
    @GetMapping("/getLogisticsInfo")
    public Result<LogisticsDetailInfo> getLogisticsInfo(@RequestParam String no){
        return Result.ofSucceed(logisticsService.getLogisticsInfo(no));
    }

}

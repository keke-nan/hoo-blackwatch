package com.holmes.hoo.blackwatch.service.impl;

import com.alibaba.fastjson.JSON;
import com.holmes.hoo.blackwatch.common.HooProperty;
import com.holmes.hoo.blackwatch.model.entity.AliResult;
import com.holmes.hoo.blackwatch.model.vo.LogisticsDetailInfo;
import com.holmes.hoo.blackwatch.service.LogisticsService;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author A20019
 * @since 2022/1/8 10:48
 */
@Slf4j
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HooProperty hooProperty;

    @Override
    public LogisticsDetailInfo getLogisticsInfo(String no) {
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("Authorization", "APPCODE " + hooProperty.getKuwlCode());
        //Map<String, String> paramMap = new HashMap<>();
        //paramMap.put("no", no);
        //HttpEntity httpEntity = new HttpEntity<>(JSON.toJSONString(paramMap), headers);
        //ResponseEntity<Object> restResult = restTemplate.exchange(hooProperty.getKuwlUrl(), HttpMethod.GET, httpEntity, Object.class);

        try {
            String urlSend = hooProperty.getKuwlUrl() + "?no=" + no;
            URL url = new URL(urlSend);
            HttpURLConnection httpURLCon = (HttpURLConnection) url.openConnection();
            httpURLCon.setRequestProperty("Authorization", "APPCODE " + hooProperty.getKuwlCode());
            int httpCode = httpURLCon.getResponseCode();
            if (HttpStatus.SC_OK == httpCode) {
                String json = read(httpURLCon.getInputStream());
                AliResult aliResult = JSON.parseObject(json, AliResult.class);
                LogisticsDetailInfo detailInfo = JSON.parseObject(JSON.toJSONString(aliResult.getResult()), LogisticsDetailInfo.class);
                log.info("kuwl restResult: {}", detailInfo);
                return detailInfo;
            }
        } catch (Exception ex) {
            log.error("error: ", ex);
        }
        return null;
    }

    private static String read(InputStream is) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = new String(line.getBytes(), StandardCharsets.UTF_8);
            stringBuffer.append(line);
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }
}

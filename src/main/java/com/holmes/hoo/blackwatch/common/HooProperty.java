package com.holmes.hoo.blackwatch.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author A20019
 * @since 2022/1/8 15:38
 */
@Getter
@Setter
@Component
@RefreshScope
@NoArgsConstructor
@ConfigurationProperties(prefix = "hoo")
public class HooProperty {

    private String kuwlUrl;

    private String kuwlKey;

    private String kuwlSecret;

    private String kuwlCode;
}

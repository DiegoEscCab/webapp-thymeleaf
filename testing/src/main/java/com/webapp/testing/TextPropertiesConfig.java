package com.webapp.testing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
     @PropertySource("classpath:texts.properties")
})
public class TextPropertiesConfig {
}

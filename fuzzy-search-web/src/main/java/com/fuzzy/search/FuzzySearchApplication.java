package com.fuzzy.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 21600, redisNamespace = "fuzzy-search-web")
public class FuzzySearchApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(FuzzySearchApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(FuzzySearchApplication.class);
    }

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("fuzzy-search-web");//cookies名称
        cookieSerializer.setCookieMaxAge(21600);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }


}

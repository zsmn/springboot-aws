package com.zsmn.springbootaws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.zsmn.springbootaws.SpringbootAwsApplication;
import com.zsmn.springbootaws.adapter.dto.Request;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class SpringbootAwsHandler implements RequestHandler<Request, Void> {
    private ApplicationContext getApplicationContext(String [] args) {
        return new SpringApplicationBuilder(SpringbootAwsApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public Void handleRequest(Request payload, Context context) {
        ApplicationContext ctx = getApplicationContext(new String[]{});
        SpringBootAwsService bean = ctx.getBean(SpringBootAwsService.class);

        try {
            bean.teste(payload.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

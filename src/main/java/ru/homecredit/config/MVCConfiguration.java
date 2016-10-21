package ru.homecredit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by RRybasov on 07.09.2016.
 */
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/front/**")) {
            registry.addResourceHandler("/front/**").addResourceLocations(
                    "classpath:/WEB-INF/front/");
        }
        if (!registry.hasMappingForPattern("/assets/**")) {
            registry.addResourceHandler("/assets/**").addResourceLocations(
                    "classpath:/WEB-INF/assets/");
        }

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/front/index.html");
        super.addViewControllers(registry);
    }

}

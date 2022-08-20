package com.knowledge.admin.configs;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan(basePackages = {"com.knowledge.admin.controllers", "com.knowledge.admin.services", "com.knowledge.admin.repository.impl"})
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(KnowledgePackageConstant.VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(KnowledgePackageConstant.VIEW_RESOLVER_SUFFIX);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(KnowledgePackageConstant.RESOURCE_HANDLER)
                .addResourceLocations(KnowledgePackageConstant.RESOURCE_LOCATION,
                        KnowledgePackageConstant.RESOURCE_CODEBASE_LOCATION);
    }

}

package com.knowledge.admin.configs;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class KnowledgePackageAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {KnowledgePackageConstant.RIGHT_SLASH};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebAppConfig.class, DataBaseConfiguration.class};
    }
}

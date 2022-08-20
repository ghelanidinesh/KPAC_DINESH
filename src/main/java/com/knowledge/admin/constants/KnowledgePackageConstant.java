package com.knowledge.admin.constants;

public class KnowledgePackageConstant {

    private KnowledgePackageConstant(){}
    public static final String RIGHT_SLASH = "/";
    public static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
    public static final String VIEW_RESOLVER_SUFFIX = ".jsp";
    public static final String RESOURCE_HANDLER = "/resources/**";
    public static final String RESOURCE_LOCATION = "/resources/";
    public static final String RESOURCE_CODEBASE_LOCATION ="/resources/codebase/";
    public static final String CLASSPATH_DB_PROPERTIES_CONSTANT = "classpath:application.properties";
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static class KnowledgePackageDatabaseConstants{

        private KnowledgePackageDatabaseConstants() {
        }
        public static final String DATE_FORMAT = "dd-MM-yyyy";
        public static final String DB_DRIVER_CLASS_NAME = "DATABASE_DRIVER_CLASS_NAME";
        public static final String DATABASE_URL = "DATABASE_URL";
        public static final String DATABASE_USERNAME = "DATABASE_USERNAME";
        public static final String DATABASE_PASSWORD = "DATABASE_PASSWORD";
        public static final String COLUMN_ID = "id";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String CREATED_DATE="creationDate";

    }
    public static class ApiConstant{
        private ApiConstant() {}
        public static final String RIGHT_SLASH_API = "/api";
        public static final String WELCOME = "welcome";
        public static final String HELLO_SPRING_MVC = "Hello Spring MVC";
        public static final String KPACS_URL_API = "/kpacs";
        public static final String KPACS_ID_URL_API = "/kpacs/{id}";
        public static final String SETS_URL_API = "/sets";
        public static final String SETS_ID_URL_API = "/sets/{id}";
        public static final String KPACS_SETS_ID_URL_API = "/kpacs/{setId}";
        public static final String REDIRECT_KPACS_ID_API = "redirect:/kpacs";
        public static final String KPACS_SETS_PAGE = "kpac_sets";
        public static final String REDIRECT_SET_URL_API = "redirect:/sets";
        public static final String SET_KPI_ID_URL_API =  "/set/{kpacSetId}";
    }
}

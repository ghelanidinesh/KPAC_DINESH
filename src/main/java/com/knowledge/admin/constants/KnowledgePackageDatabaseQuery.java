package com.knowledge.admin.constants;

public class KnowledgePackageDatabaseQuery {
    public static final String SELECT_KPAC_SET_QUERY = "SELECT * FROM KnowledgePackageSet";
    public static final String SELECT_KPAC_SET_BY_ID_QUERY = "SELECT * FROM KnowledgePackageSet  where id = ?";
    public static final String INSERT_KPAC_SET_QUERY = "INSERT into KnowledgePackageSet(title) values(?)";
    public static final String INSERT_KPS_KP_QUERY = "INSERT into knowledge_package_with_set(know_package_setid, know_package_id) values(?,?)";
    public static final String DELETE_KPAC_SET_QUERY = "DELETE from KnowledgePackageSet where id = ?";
    public static final String SELECT_KPAC_QUERY = "SELECT * FROM KnowledgePackage";
    public static final String SELECT_KPAC_FROM_SETID_QUERY = "SELECT k_pac.id, k_pac.title, k_pac.description, k_pac.creationDate FROM KnowledgePackage k_pac JOIN knowledge_package_with_set kpskp ON k_pac.id = kpskp.know_package_id where kpskp.know_package_setid = ?";
    public static final String INSERT_KPAC_QUERY = "INSERT into KnowledgePackage(title, description, creationDate) values(?, ?, ?)";
    public static final String DELETE_KPAC_QUERY = "DELETE from KnowledgePackage where id = ?";


}

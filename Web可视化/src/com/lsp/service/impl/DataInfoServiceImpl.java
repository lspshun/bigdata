package com.lsp.service.impl;

import com.lsp.service.DataInfoService;
import com.lsp.util.PropertiesUtil;
import com.lsp.util.RemoteUtil;

import java.util.Arrays;
import java.util.List;

public class DataInfoServiceImpl implements DataInfoService {

    private PropertiesUtil propertiesUtil = new PropertiesUtil("config/system.properties");
    private RemoteUtil remoteUtil = new RemoteUtil(propertiesUtil.readPropertyByKey("host"),propertiesUtil.readPropertyByKey("bigdataUser"),propertiesUtil.readPropertyByKey("bigdataPwd"));

    @Override
    public List<String> getDatabaseName() {
        String dataSource = propertiesUtil.readPropertyByKey("dataSource");
        String user = propertiesUtil.readPropertyByKey("sourceUser");
        String passwd = propertiesUtil.readPropertyByKey("sourcePwd");
        String result = remoteUtil.execute("source .bash_profile && sqoop list-databases --connect jdbc:mysql://" + dataSource + "/ --username "+ user +" --password " + passwd);
        return Arrays.asList(result.split("\n"));
    }

    @Override
    public List<String> getTableName(String database) {
        String dataSource = propertiesUtil.readPropertyByKey("dataSource");
        String user = propertiesUtil.readPropertyByKey("sourceUser");
        String passwd = propertiesUtil.readPropertyByKey("sourcePwd");
        String result = remoteUtil.execute("source .bash_profile && sqoop list-tables --connect jdbc:mysql://" + dataSource + "/" + database + " --username "+ user +" --password " + passwd);
        return Arrays.asList(result.split("\n"));
    }
}

package com.lsp.service;

import java.util.List;

public interface DataInfoService {

    public List<String> getDatabaseName();

    public List<String> getTableName(String database);

}

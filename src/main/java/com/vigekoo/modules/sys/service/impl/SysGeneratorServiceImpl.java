package com.vigekoo.modules.sys.service.impl;

import com.vigekoo.common.utils.GeneratorUtils;
import com.vigekoo.modules.sys.dao.SysGeneratorDao;
import com.vigekoo.modules.sys.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @author sxia
 * @Description: TODO()
 * @date 2017-6-23 15:07
 */
@Service("sysGeneratorService")
public class SysGeneratorServiceImpl implements SysGeneratorService {

    @Autowired
    private SysGeneratorDao sysGeneratorDao;

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return sysGeneratorDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysGeneratorDao.queryTotal(map);
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return sysGeneratorDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return sysGeneratorDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String[] tableNames,boolean isZip) {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	 ZipOutputStream zip = null;
    	if(isZip){
            zip = new ZipOutputStream(outputStream);
    	}

        for(String tableName : tableNames){
            //查询表信息
        	//tableName  ENGINE  tableComment  createTime
        	//info_qa	InnoDB	一问一答	2018-03-16 10:16:06
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            if(zip != null){
            	GeneratorUtils.generatorCode(table, columns, zip);
            }else{
            	// 特定路径生成代码
            	GeneratorUtils.generatorCode(table, columns);
            }
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}

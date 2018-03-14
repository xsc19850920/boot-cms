package com.vigekoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vigekoo.modules.sys.service.SysGeneratorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void generatorCode() {
        String[] tableNames = {"info_qa"};

        sysGeneratorService.generatorCode(tableNames);

    }
}

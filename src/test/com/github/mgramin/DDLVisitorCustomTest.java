package com.github.mgramin;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by maksim on 28.01.16.
 */
public class DDLVisitorCustomTest {

    @Test
    public void testVisitDdl_stat() throws Exception {
        SQLFileParser.parse(new File("test_script.sql"));
    }

}
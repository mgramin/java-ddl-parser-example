package com.github.mgramin;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by maksim on 28.01.16.
 */
public class SQLFileParser {

    public static void parse(File file) {
        ANTLRInputStream antlrInputStream = null;
        try {
            antlrInputStream = new ANTLRInputStream(new String(Files.readAllBytes(Paths.get("test_script.sql"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DDLLexer lexer = new DDLLexer(antlrInputStream);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        DDLParser parser = new DDLParser( tokens );
        ParseTree tree = parser.ddl_stat();
        DDLBaseVisitor ddlVisitor = new DDLVisitorCustom();
        ddlVisitor.visit(tree);
    }

}

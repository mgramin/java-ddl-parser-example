package com.github.mgramin;

import java.io.File;

public class Main {

    public static void main(String [] args) throws Exception
    {
        SQLFileParser.parse(new File(args[0]));
    }

}
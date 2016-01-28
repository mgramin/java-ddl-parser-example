package com.github.mgramin;

import java.util.Iterator;

public class DDLVisitorCustom<T> extends DDLBaseVisitor {

    public Object visitDdl_stat(DDLParser.Ddl_statContext ctx) {
        Iterator<DDLParser.Create_tableContext> tables = ctx.create_table().iterator();
        while (tables.hasNext()) {
            DDLParser.Create_tableContext table = tables.next();
            System.out.println(table.table_name().getText());
            Iterator<DDLParser.Table_rowContext> tableRows = table.table_row().iterator();
            while (tableRows.hasNext()) {
                DDLParser.Table_rowContext tableRow = tableRows.next();
                System.out.printf("  %s - %s", tableRow.table_column().column_name().getText(), tableRow.table_column().column_type().getText());
                if (tableRow.table_column().primary_key(0) != null)
                    System.out.print(" (PK) ");
                if (tableRow.table_column().not_null(0) != null)
                    System.out.print(" (not null) ");
                System.out.println();
            }
            System.out.println();
        }
        return (T) visitChildren(ctx);
    }

}
grammar DDL;

ID
   : ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
   ;

WS
   : ( ' ' | '\t' | '\n' | '\r' )+ -> skip
   ;

LEFT_BRACKET
   : '('
   ;

RIGHT_BRACKET
   : ')'
   ;

DOT
   : '.'
   ;

COMMA
   : ','
   ;

SEMICOLON
   : ';'
   ;

QUOTE
   : '\''
   ;

DOUBLE_QUOTE
   : '"'
   ;


SINGLE_LINE_COMMENT
   : '--' ~[\r\n]* -> skip
   ;

MULTIPLE_LINE_COMMENT
   : '/*' .*? '*/' -> skip
   ;






ddl_stat
   : (create_table (SEMICOLON create_table)*)
   ;

create_table
   : create table (schema_name+ DOT)? table_name
      LEFT_BRACKET table_row( COMMA table_row )* RIGHT_BRACKET
      SEMICOLON?
   ;






primary_key
   : 'primary key' | 'PRIMARY KEY'
   ;

not_null
   : 'not null' | 'NOT NULL'
   ;







create
   : 'create' | 'CREATE'
   ;

table
   : 'table' | 'TABLE'
   ;

schema_name
   : ID
   ;

table_name
   : (DOUBLE_QUOTE)? ID (DOUBLE_QUOTE)?
   ;

table_row
   : table_column
   ;

table_column
   : column_name column_type (primary_key | not_null)*
   ;

column_name
   : (DOUBLE_QUOTE)? ID (DOUBLE_QUOTE)?
   ;



column_type
   : ID (column_type_scale | column_type_scale_2)?;

column_type_scale
   : '(' ID ')'
   ;

column_type_scale_2
   : '(' ID COMMA ID ')'
   ;
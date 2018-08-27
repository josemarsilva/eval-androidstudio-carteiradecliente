package com.carteiracliente.josemarsilva.carteiradecliente.database;

public class ScriptDDL {

    public static String getCreateTableCliente() {

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS CLIENTE (");
        sql.append("  CODIGO   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("  NOME     VARCHAR(255) NOT NULL DEFAULT(''), ");
        sql.append("  ENDERECO VARCHAR(255) NOT NULL DEFAULT(''), ");
        sql.append("  EMAIL    VARCHAR(255) NOT NULL DEFAULT(''), ");
        sql.append("  TELEFONE VARCHAR(20) NOT NULL DEFAULT('')   ");
        sql.append(")");

        return sql.toString();

    }
}

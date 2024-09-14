package br.com.manicure.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author John
 * @param <T>
 */
public interface CrudPesquisa<T> {

    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, T t);

    public int editar(Connection conn, PreparedStatement stmt, T t);

    public void excluir(Connection conn, PreparedStatement stmt, int id);

}

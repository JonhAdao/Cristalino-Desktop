package br.com.manicure.interfaces;

import java.util.List;

/**
 *
 * @author John
 * @param <T>
 */
public interface GenericDAO<T> {

    public void cadastrar(T t);

    public void editar(T t);

    public void excluir(T t);

    public List<T> listar();

    public List<T> filtrar(String s);

}

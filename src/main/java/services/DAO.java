/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HB
 */
public interface DAO<T, ID> {

    List<T> findAll() throws SQLException;

    T getById(ID id) throws SQLException;

    ID create(T t) throws SQLException;

    Integer update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void deleteById(ID id) throws SQLException;
}

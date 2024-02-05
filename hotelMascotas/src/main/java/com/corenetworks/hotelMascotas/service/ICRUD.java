package com.corenetworks.hotelMascotas.service;

import java.util.List;

public interface ICRUD<T,ID>{
    List<T> consultarTodos() throws Exception;
    T consultarUno(ID id) throws Exception;
    T insertar(T t) throws Exception;
    T modificar(T t) throws Exception;
    void eliminar(ID id) throws Exception;

}

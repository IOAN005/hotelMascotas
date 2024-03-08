package com.corenetworks.hotelMascotas.repository;

import com.corenetworks.hotelMascotas.modelo.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IReservaRepositorio extends IGenericoRepositorio <Reserva,Integer>{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value= "Insert into reservas_mascotas_habitaciones (fecha_entrada,fecha_salida,precio,id_mascota,id_habitacion) values (:fecha_entrada,:fecha_salida,:precio,:id_mascota,:id_habitacion)" ,nativeQuery = true)
    public Integer insertar1(@Param("fecha_entrada")LocalDate fecha_entrada,@Param("fecha_salida")LocalDate fecha_salida,@Param("precio")double precio,@Param("id_mascota")int idMascota,@Param("id_habitacion")int idHabitacion);


    @Query(value = "FROM Reserva r WHERE r.fechaEntrada >= :f1 AND r.fechaSalida <= :f2")
    public List<Reserva> obtenerReservas(@Param("f1") LocalDate f1, @Param("f2") LocalDate f2);

    @Query(value = "Update reservas_mascotas_habitaciones, SET (fecha_entrada ,fecha_salida , precio ,id_mascota ,id_habitacion ) values(:fechaEntrada,  :fechaSalida,   :precio, :idMascota,  :idHabitacion) WHERE id_reserva = :idReserva",nativeQuery = true)
    public void actualizarReserva(@Param("idReserva") Integer idReserva,
                                  @Param("fechaEntrada") LocalDate fechaEntrada,
                                  @Param("fechaSalida") LocalDate fechaSalida,
                                  @Param("precio") Double precio,
                                  @Param("idMascota") Integer idMascota,
                                  @Param("idHabitacion") Integer idHabitacion);
}

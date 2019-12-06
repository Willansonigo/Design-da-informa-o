package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento , String> {//Essa classe facilita a nossa aplicação fazer o CRUDE.

}//Toda implementação seleção de dados no banco,insert,update.

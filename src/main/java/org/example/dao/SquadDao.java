package org.example.dao;

import org.example.models.Hero;
import org.example.models.Squad;

import java.util.List;

public interface SquadDao {

    List<Squad> getAll();


    void add(Squad task);


    Squad findById(int id);


    void update(int id, String name, int size, String cause);


    void deleteById(int id);

    void clearAllSquads();

    List<Hero> getAllHeroesBySquad(int squadId);

    void deleteAllHeroesInSquad(int squadId);
}

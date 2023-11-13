package org.example.dao;

import org.example.models.Hero;

import java.util.List;

public interface HeroDao {

    List<Hero> getAll();


    void add(Hero task);


    Hero findById(int id);


    void update(int id, String name, int age, String power, String cause, int squadId);


    void deleteById(int id);

    void clearAllHeroes();

    void uploadImage(int id, byte[] image);
}

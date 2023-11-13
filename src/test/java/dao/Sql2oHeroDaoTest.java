package dao;

import org.example.dao.Sql2oHeroDao;
import org.example.dao.Sql2oSquadDao;
import org.example.models.Hero;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oHeroDaoTest {
    private static Sql2oHeroDao heroDao;
    private static Sql2oSquadDao squadDao;
    private static Connection conn;


    @Test
    public void addingHeroSetsId() throws Exception {
        Hero hero = setUpNewHero();
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void aHeroIsSuccessfullyAdded() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        assertTrue(heroDao.getAll().contains(hero));
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        Hero foundHero = heroDao.findById(hero.getId());
        assertEquals(hero, foundHero);
    }

    @Test
    public void existingHeroCanBeUpdated() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        heroDao.update(hero.getId(),"Superman",33,"Invincibility","Kryptonite",2);
        Hero foundHero = heroDao.findById(hero.getId());
        assertNotEquals(hero, foundHero);
    }

    @Test
    public void existingHeroCanBeDeleted() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertFalse(heroDao.getAll().contains(hero));
    }

    @Test
    public void AllExistingHeroesCanBeDeleted() throws Exception {
        Hero hero = setUpNewHero();
        Hero otherHero = setUpNewHero();
        heroDao.add(hero);
        heroDao.add(otherHero);
        heroDao.clearAllHeroes();
        assertFalse(heroDao.getAll().contains(hero));
        assertFalse(heroDao.getAll().contains(otherHero));
        assertEquals(0,heroDao.getAll().size());
    }

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/heroes_test";
        Sql2o sql2o = new Sql2o(connectionString, "baraka", "fRankline");
        squadDao = new Sql2oSquadDao();
        heroDao = new Sql2oHeroDao();
        conn = sql2o.open();
    }


    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Hero setUpNewHero(){
        return new Hero("Wolverine", 78, "Metal Claws", "Magnets",1, "".getBytes());
    }
}

package co.com.udea.tourofhero.domain.repository;

import co.com.udea.tourofhero.domain.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {

    Optional<Hero> getHeroByCodigo(Integer codigo);
    Optional<List<Hero>> getHeros();
    Optional<Hero> save(Hero hero);
    void delete(Integer codigo);
    Optional<Hero> update(Hero hero);

    Optional<List<Hero>> getHeroesContainsTerm(String term);
}

package co.com.udea.tourofhero.persistence.repositoryimpl;

import co.com.udea.tourofhero.domain.model.Hero;
import co.com.udea.tourofhero.domain.repository.HeroRepository;
import co.com.udea.tourofhero.persistence.crud.HeroCrud;
import co.com.udea.tourofhero.persistence.entity.HeroEntity;
import co.com.udea.tourofhero.persistence.mapper.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HeroRepositoryImpl implements HeroRepository {

    private final HeroMapper mapper;

    private final HeroCrud persistence;

    @Autowired
    public HeroRepositoryImpl(HeroMapper mapper, HeroCrud persistence) {
        this.mapper = mapper;
        this.persistence = persistence;
    }

    @Override
    public Optional<Hero> getHeroByCodigo(Integer codigo) {
        return persistence.findHeroEntitiesByCodigo(codigo)
                .map(mapper::toHero);
    }

    @Override
    public Optional<List<Hero>> getHeros() {
        List<HeroEntity> lista = persistence.findAll();
        if (lista.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.toHeroes(lista));
    }

    @Override
    public Optional<Hero> save(Hero hero) {
        HeroEntity entity = mapper.toHeroEntity(hero);
        return Optional.of(mapper.toHero(persistence.save(entity)));
    }

    @Override
    public void delete(Integer codigo) {
        persistence.deleteHeroEntityByCodigo(codigo);
    }

    @Override
    public Optional<Hero> update(Hero hero) {
        HeroEntity entity = mapper.toHeroEntity(hero);
        return Optional.of(mapper.toHero(persistence.save(entity)));
    }
}

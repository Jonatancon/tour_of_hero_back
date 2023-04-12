package co.com.udea.tourofhero.persistence.crud;

import co.com.udea.tourofhero.persistence.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeroCrud extends JpaRepository<HeroEntity, Integer> {
    Optional<HeroEntity> findHeroEntitiesByCodigo(Integer codigo);

    void deleteHeroEntityByCodigo(Integer codigo);

    List<HeroEntity> findAllByNombreIsContainingIgnoreCase(String term);
}

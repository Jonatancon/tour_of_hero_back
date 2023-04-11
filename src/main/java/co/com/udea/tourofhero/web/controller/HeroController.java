package co.com.udea.tourofhero.web.controller;

import co.com.udea.tourofhero.domain.model.Hero;
import co.com.udea.tourofhero.domain.model.Mensaje;
import co.com.udea.tourofhero.domain.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HeroController.HERO_URL)
public class HeroController {

    public static final String HERO_URL = "/hero";

    private final HeroService service;

    @Autowired
    public HeroController(HeroService service) {
        this.service = service;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Hero> getHeroByCodigo(@PathVariable Integer codigo) {
        return new ResponseEntity<>(service.getHeroByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getHeroes() {
        return new ResponseEntity<>(service.getHeros(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hero> saveHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(service.saveHero(hero), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Mensaje> deleteHeroByCodigo(@PathVariable Integer codigo) {
        service.deleteHero(codigo);
        return new ResponseEntity<>(new Mensaje( "001", "Hero delete"), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(service.updateHero(hero), HttpStatus.OK);
    }
}
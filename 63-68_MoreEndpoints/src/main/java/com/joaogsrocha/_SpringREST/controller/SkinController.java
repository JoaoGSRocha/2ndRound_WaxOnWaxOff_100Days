package com.joaogsrocha._SpringREST.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
class SkinController {
/*    private final SkinRepository repository;

    SkinController(SkinRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("api/skin")
    List<Skin> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("api/skin")
    Skin newSkin(@RequestBody Skin newSkin) {
        return repository.save(newSkin);
    }

    // Single item

    @GetMapping("api/skin/{id}")
    Skin one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SkinNotFoundException(id));
    }

*//*    @PatchMapping("api/skin/{id}")
    Skin replaceSkin(@RequestBody Skin newSkin, @PathVariable Long id) {
        return repository.findById(id)
            .map(skin -> {
                skin.setName(newSkin.getName() != null? newSkin.getName() : skin.getName());
                skin.setRarity(newSkin.getRarity() != null ? newSkin.getRarity() : skin.getRarity());
                skin.setCondition(newSkin.getCondition() != null ? newSkin.getCondition() : skin.getCondition());
                skin.setPrice(newSkin.getPrice() != null ? newSkin.getPrice() : skin.getPrice());
                skin.setReleaseDate(newSkin.getReleaseDate() != null ? newSkin.getReleaseDate() : skin.getReleaseDate());
                return repository.save(skin);
            })
            .orElseGet(() -> {
            newSkin.setId(id);
            return repository.save(newSkin);
            });
    }*//*

    @DeleteMapping("api/skin/{id}")
    void deleteSkin(@PathVariable Long id) {
        repository.deleteById(id);
                }

    @DeleteMapping("api/skin")
    void deleteAll() {
        repository.deleteAll();
    }*/
}

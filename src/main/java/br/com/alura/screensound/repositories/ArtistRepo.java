package br.com.alura.screensound.repositories;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.repositories.repository.ArtistRepository;
import br.com.alura.screensound.repositories.specifications.ArtistSpec;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ArtistRepo {
  private ArtistRepository repository;

  public void save(Artist artist) {
    repository.save(artist);
    log.info("Artist salvo com sucesso!");
  }

  public Optional<Artist> findByName(String name) {
    Specification<Artist> spec = ArtistSpec.filterByName(name);
    return this.repository.findOne(spec);
  }
}

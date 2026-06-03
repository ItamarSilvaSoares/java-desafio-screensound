package br.com.alura.screensound.repositories.specifications;

import br.com.alura.screensound.models.Artist;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;

public class ArtistSpec {
  public static Specification<Artist> filterByName(String name) {
    return (root, _, cb) ->
        Optional.ofNullable(name)
            .filter(n -> !n.isBlank())
            .map(n -> cb.like(cb.lower(root.get("name")), n.toLowerCase()))
            .orElseGet(cb::conjunction);
  }
}

package br.com.alura.screensound.repositories.specifications;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Music;
import jakarta.persistence.criteria.Join;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;

public class MusicSpec {
  public static Specification<Music> byArtist(String artistName) {
    return (root, _, cb) -> {
      Join<Music, Artist> join = root.join("artist");
      return Optional.ofNullable(artistName)
          .filter(n -> !n.isBlank())
          .map(n -> cb.like(cb.lower(join.get("name")), "%" + n.toLowerCase() + "%"))
          .orElseGet(cb::conjunction);
    };
  }
}

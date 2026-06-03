package br.com.alura.screensound.repositories;

import br.com.alura.screensound.models.Music;
import br.com.alura.screensound.repositories.repository.MusicRepository;
import br.com.alura.screensound.repositories.specifications.MusicSpec;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MusicRepo {
  private final MusicRepository musicRepository;

  public List<Music> findAllMusics() {
    return musicRepository.findAll();
  }

  public List<Music> findAllMusicsByArtist(String artistName) {
    Specification<Music> spc = MusicSpec.byArtist(artistName);
    return musicRepository.findAll(spc);
  }
}

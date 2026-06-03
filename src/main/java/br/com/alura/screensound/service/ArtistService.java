package br.com.alura.screensound.service;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Music;
import br.com.alura.screensound.models.TypeArtist;
import br.com.alura.screensound.repositories.ArtistRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ArtistService {
  private final ArtistRepo artistRepo;

  public void saveArtist(String artistName, String artistType) {
    try {
      Artist artist = new Artist(artistName, TypeArtist.valueOf(artistType.toUpperCase()));

      this.artistRepo.save(artist);

    } catch (IllegalArgumentException e) {
      log.error("Tipo '{}' não cadastrado", artistType);
    }
  }

  public void addMusicToArtist(String artistName, String musicName) {
    Artist artist = artistRepo.findByName(artistName).orElse(null);

    if (artist == null) {
      log.warn("Artista '{}' não encontrado", artistName);
      return;
    }

    artist.addMusic(new Music(musicName, artist));
    artistRepo.save(artist);
  }
}

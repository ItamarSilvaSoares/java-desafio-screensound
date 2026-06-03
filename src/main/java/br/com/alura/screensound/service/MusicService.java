package br.com.alura.screensound.service;

import br.com.alura.screensound.models.Music;
import br.com.alura.screensound.repositories.MusicRepo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MusicService {
  private MusicRepo musicRepo;

  public List<Music> findAll() {
    return this.musicRepo.findAllMusics();
  }

  public List<Music> findAllByArtist(String artistName) {
    
    return this.musicRepo.findAllMusicsByArtist(artistName);
  }
}

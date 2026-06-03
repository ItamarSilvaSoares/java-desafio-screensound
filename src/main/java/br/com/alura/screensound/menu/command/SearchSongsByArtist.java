package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.ConsoleReader;
import br.com.alura.screensound.service.MusicService;
import org.springframework.stereotype.Component;

@Component
public class SearchSongsByArtist extends Command {
  private final MusicService musicService;

  public SearchSongsByArtist(ConsoleReader consoleReader, MusicService musicService) {
    super(
        consoleReader,
        MenuOptions.SEARCH_SONGS_BY_ARTIST.getCode(),
        MenuOptions.SEARCH_SONGS_BY_ARTIST.getDescription());
    this.musicService = musicService;
  }

  @Override
  public void executar() {
    System.out.println("Buscar músicas de que artista? ");
    String artistName = this.sc.getString();

    this.musicService.findAllByArtist(artistName).forEach(System.out::println);
  }
}

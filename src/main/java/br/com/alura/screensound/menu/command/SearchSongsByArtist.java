package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class SearchSongsByArtist extends Command {

  public SearchSongsByArtist() {
    super(
        null,
        MenuOptions.SEARCH_SONGS_BY_ARTIST.getCode(),
        MenuOptions.SEARCH_SONGS_BY_ARTIST.getDescription());
  }

  @Override
  public void executar() {}
}

package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class SearchArtistInformation extends Command {

  protected SearchArtistInformation() {
    super(null, MenuOptions.SEARCH_ARTIST_INFORMATION.getCode(), MenuOptions.SEARCH_ARTIST_INFORMATION.getDescription());
  }

  @Override
  public void executar() {

  }
}

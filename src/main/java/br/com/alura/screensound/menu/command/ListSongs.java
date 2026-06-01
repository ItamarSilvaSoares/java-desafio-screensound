package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class ListSongs extends Command {

  public ListSongs() {
    super(null, MenuOptions.LIST_SONGS.getCode(), MenuOptions.LIST_SONGS.getDescription());
  }

  @Override
    public void executar() {}
}

package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.MusicService;
import org.springframework.stereotype.Component;

@Component
public class ListSongs extends Command {
  private final MusicService musicService;

  public ListSongs(MusicService musicService) {
    super(null, MenuOptions.LIST_SONGS.getCode(), MenuOptions.LIST_SONGS.getDescription());
    this.musicService = musicService;
  }

  @Override
  public void executar() {
    this.musicService.findAll().forEach(System.out::println);
  }
}

package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class RegisterSongs extends Command {

  public RegisterSongs() {
    super(null, MenuOptions.REGISTER_SONGS.getCode(), MenuOptions.REGISTER_SONGS.getDescription());
  }

  @Override
  public void executar() {}
}

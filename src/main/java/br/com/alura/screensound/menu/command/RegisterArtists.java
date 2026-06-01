package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class RegisterArtists extends Command {

  public RegisterArtists() {
    super(
        null,
        MenuOptions.REGISTER_ARTISTS.getCode(),
        MenuOptions.REGISTER_ARTISTS.getDescription());
  }

  @Override
  public void executar() {}
}

package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.ArtistService;
import br.com.alura.screensound.service.ConsoleReader;
import org.springframework.stereotype.Component;

@Component
public class RegisterSongs extends Command {
  private final ArtistService service;

  public RegisterSongs(ConsoleReader cr, ArtistService service) {
    super(cr, MenuOptions.REGISTER_SONGS.getCode(), MenuOptions.REGISTER_SONGS.getDescription());
    this.service = service;
  }

  @Override
  public void executar() {
    System.out.println("Cadastrar música de que artista? ");
    String artistName = this.sc.getString();
    System.out.println("Informe o título da música: ");
    String nomeMusica = sc.getString();

    this.service.addMusicToArtist(artistName, nomeMusica);
  }
}

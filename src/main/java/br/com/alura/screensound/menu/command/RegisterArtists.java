package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.ArtistService;
import br.com.alura.screensound.service.ConsoleReader;
import org.springframework.stereotype.Component;


@Component
public class RegisterArtists extends Command {
  private final ArtistService service;

  public RegisterArtists(ConsoleReader cr, ArtistService artistService) {
    super(
        cr, MenuOptions.REGISTER_ARTISTS.getCode(), MenuOptions.REGISTER_ARTISTS.getDescription());
    this.service = artistService;
  }

  @Override
  public void executar() {
    String again = "s";

    while (again.equalsIgnoreCase("s")) {

      System.out.println("Informe o nome desse artista: ");
      String artistName = this.sc.getString();
      System.out.println("Informe o tipo desse artista: (solo, dupla ou banda)");
      String artistType = this.sc.getString();

      this.service.saveArtist(artistName, artistType);

      System.out.println("Cadastrar novo artista?: (s/N)");
      again = this.sc.getString().isEmpty() ? "n" : "s";
    }
  }
}

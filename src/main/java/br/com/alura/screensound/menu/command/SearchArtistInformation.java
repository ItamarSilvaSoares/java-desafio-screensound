package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.ConsoleReader;
import br.com.alura.screensound.service.ConsultaChatGPT;
import org.springframework.stereotype.Component;

@Component
public class SearchArtistInformation extends Command {

  protected SearchArtistInformation(ConsoleReader consoleReader) {
    super(
        consoleReader,
        MenuOptions.SEARCH_ARTIST_INFORMATION.getCode(),
        MenuOptions.SEARCH_ARTIST_INFORMATION.getDescription());
  }

  @Override
  public void executar() {
    System.out.println("Pesquisar dados sobre qual artista? ");
    String nome = this.sc.getString();
    String resposta = ConsultaChatGPT.obterInformacao(nome);
    System.out.println(resposta.trim());
  }
}

package br.com.alura.screensound.menu.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuOptions {
  REGISTER_ARTISTS("1", "Cadastrar artistas"),
  REGISTER_SONGS("2", "Cadastrar músicas"),
  LIST_SONGS("3", "Listar musicas"),
  SEARCH_SONGS_BY_ARTIST("4", "Buscar músicas por artistas"),
  SEARCH_ARTIST_INFORMATION("5", "Pesquisar dados sobre um artista"),
  EXIT("9", "Sair");

  private final String code;
  private final String description;
}

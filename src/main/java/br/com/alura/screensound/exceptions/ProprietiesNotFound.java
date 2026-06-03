package br.com.alura.screensound.exceptions;

public class ProprietiesNotFound extends RuntimeException {
  public ProprietiesNotFound() {
    String message = "As 'properties' do banco de dados não encontrado";
    super(message);
  }
}

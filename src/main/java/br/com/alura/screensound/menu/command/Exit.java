package br.com.alura.screensound.menu.command;

import org.springframework.stereotype.Component;

@Component
public class Exit extends Command {

  protected Exit() {
    super(null, MenuOptions.EXIT.getCode(), MenuOptions.EXIT.getDescription());
  }

  @Override
  public void executar() {
    System.out.println("saindo...");
  }
}

package br.com.alura.screensound.menu.command;

import br.com.alura.screensound.service.ConsoleReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Command {
  protected final ConsoleReader sc;
  @Getter protected String operationId;
  protected String description;

  protected Command(ConsoleReader scanner, String operationId, String description) {
    this.sc = scanner;
    this.operationId = operationId;
    this.description = description;
  }

  public abstract void executar();

  @Override
  public String toString() {
    return this.operationId + " - " + this.description;
  }
}

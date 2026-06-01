package br.com.alura.screensound.menu;

import br.com.alura.screensound.menu.command.Command;
import br.com.alura.screensound.menu.command.CreatListCommand;
import br.com.alura.screensound.menu.command.MenuOptions;
import br.com.alura.screensound.service.ConsoleReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Menu {

  private final CreatListCommand mapCommand;
  private final ConsoleReader sc;
  private List<Entry<String, Command>> listCommands = null;

  public Menu(CreatListCommand command, ConsoleReader scanner) {
    this.mapCommand = command;
    this.sc = scanner;
  }

  public void show() {
    this.listCommands =
        this.mapCommand.createListCommand().entrySet().stream()
            .sorted(Comparator.comparing(e -> Integer.parseInt(e.getKey())))
            .toList();

    String opcao;

    do {
      System.out.println("\n*** Screen Sound Músicas ***");
      this.listCommands.forEach(e -> System.out.println(e.getValue()));

      opcao = this.sc.getString();

      if (opcao.equals(MenuOptions.EXIT.getCode())) {
        getCommand(5).executar();
        break;
      }

      Command cmd = null;

      try {
        cmd = getCommand(Integer.parseInt(opcao));
      } catch (NumberFormatException e) {
        log.warn("Opção '{}' Invalida", opcao);
      }

      if (cmd != null) {
        cmd.executar();
        continue;
      }

      System.out.println("\nOpção Invalida\n");

    } while (true);
  }

  private Command getCommand(int index) {
    return this.listCommands.get(index).getValue();
  }
}

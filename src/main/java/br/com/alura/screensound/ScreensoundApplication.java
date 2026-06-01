package br.com.alura.screensound;

import br.com.alura.screensound.menu.Menu;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {
  private final Menu menu;

  public ScreensoundApplication(Menu menu) {
    this.menu = menu;
  }

  static void main(String[] args) {
    SpringApplication.run(ScreensoundApplication.class, args);
  }

  @Override
  public void run(String @NonNull ... args) {
    this.menu.show();
  }
}

package br.com.alura.screensound.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "artistas")
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(unique = true, name = "nome")
  @NonNull
  private String name;

  @Enumerated(EnumType.STRING)
  @NonNull
  @Column(name = "tipo")
  private TypeArtist typeArtist;

  @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Column(name = "musicas")
  private List<Music> musics = new ArrayList<>();

  public void addMusic(Music music) {
    if (music != null) {
      this.musics.add(music);
    }
  }

  @Override
  public String toString() {
    return "Artista: " + '\'' + name + '\'' + ", tipo: " + typeArtist + ", musicas: " + musics;
  }
}

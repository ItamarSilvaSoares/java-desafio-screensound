package br.com.alura.screensound.repositories.repository;

import br.com.alura.screensound.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository
    extends JpaRepository<Music, Long>, JpaSpecificationExecutor<Music> {}

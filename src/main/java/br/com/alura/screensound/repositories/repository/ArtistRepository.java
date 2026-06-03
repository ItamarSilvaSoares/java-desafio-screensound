package br.com.alura.screensound.repositories.repository;

import br.com.alura.screensound.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository
    extends JpaRepository<Artist, Long>, JpaSpecificationExecutor<Artist> {}

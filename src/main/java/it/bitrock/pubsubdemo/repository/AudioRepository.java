package it.bitrock.pubsubdemo.repository;

import it.bitrock.pubsubdemo.entity.AudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<AudioEntity, Long> {
}

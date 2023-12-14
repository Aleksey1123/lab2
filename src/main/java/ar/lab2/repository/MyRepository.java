package ar.lab2.repository;

import ar.lab2.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Word, Integer> {
}

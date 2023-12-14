package ar.lab2.service;

import ar.lab2.entity.Word;

import java.util.List;
import java.util.Optional;


public interface MyService {

    List<Word> printAllWords();

    Optional<Word> saveNewWord(Word word);

    Optional<Word> updateWordById(Integer id, Word newWord);

    void deleteWordById(Integer id);
}

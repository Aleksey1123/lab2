package ar.lab2.service;

import ar.lab2.entity.Word;
import ar.lab2.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
@Service
public class MyServiceImpl implements MyService {

    private final MyRepository myRepository;

    @Override
    public List<Word> printAllWords() {
        return myRepository.findAll();
    }

    @Override
    public Optional<Word> saveNewWord(Word word) {
        return Optional.of(myRepository.save(word));
    }

    @Override
    public Optional<Word> updateWordById(Integer id, Word newWord) {

        AtomicReference<Optional<Word>> atomicReference = new AtomicReference<>();

        myRepository.findById(id).ifPresentOrElse(foundWord -> {
            foundWord.setText(newWord.getText());
            foundWord.setTranslation(newWord.getTranslation());
            atomicReference.set(Optional.of(myRepository.save(foundWord)));
        }, () -> atomicReference.set(Optional.empty()));

        return atomicReference.get();
    }

    @Override
    public void deleteWordById(Integer id) {
        myRepository.findById(id).ifPresent(word -> myRepository.deleteById(id));
    }
}

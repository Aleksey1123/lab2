package ar.lab2.bootstrap;

import ar.lab2.entity.Word;
import ar.lab2.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final MyRepository myRepository;

    @Override
    public void run(String... args) throws Exception {
        loadWordData();
    }

    private void loadWordData() {
        if (myRepository.count() == 0) {
            myRepository.save(Word.builder()
                    .text("hello")
                    .translation("привет")
                    .build());

            myRepository.save(Word.builder()
                    .text("world")
                    .translation("мир")
                    .build());

            myRepository.save(Word.builder()
                    .text("apple")
                    .translation("яблоко")
                    .build());
        }
    }
}

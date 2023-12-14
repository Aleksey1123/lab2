package ar.lab2.controller;


import ar.lab2.entity.Word;
import ar.lab2.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyController {

    public static final String PATH = "/api/";
    public static final String WORD_PATH_ID = PATH + "{wordId}";

    private final MyService myService;

    @DeleteMapping(WORD_PATH_ID)
    public ResponseEntity controllerDelete(@PathVariable Integer wordId) {

        myService.deleteWordById(wordId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(PATH)
    public ResponseEntity controllerPut(@RequestBody Word newWord) throws Exception {

        if (myService.updateWordById(newWord.getId(), newWord).isEmpty()) {
            throw new Exception("Invalid id");
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(PATH)
    public ResponseEntity controllerPost(@RequestBody Word word) throws Exception {

        if (myService.saveNewWord(word).isEmpty()) {
            throw new Exception("Invalid id");
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(PATH)
    public List<Word> controllerGet() {

        return myService.printAllWords();
    }

}

package versionone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {
    private static final Logger log = LoggerFactory.getLogger(WordsController.class);

    private Greeting greeting;
//    fetch('/', { method: 'POST', headers:{'Content-Type': 'application/json'}, body: JSON.stringify({words:'word'})}).then(console.log)

    @GetMapping("/")
    public Greeting greeting(){
        greeting = new Greeting();
        greeting.setWords(new String[]{"hi","ingo","organ"});
        log.info(greeting.toString());
        return greeting;
    }

    @PostMapping("/")
    public Greeting greetingAnswer(@RequestBody Greeting inputGreeting){
        greeting = inputGreeting;
        log.info("input: "+greeting.toString());
        String[] words = greeting.getWords();
        String [] response = greeting.controlWords(words);
        greeting.setWords(response);
        log.info("output: "+greeting.toString());
        return greeting;
    }
}

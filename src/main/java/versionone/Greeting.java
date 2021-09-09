package versionone;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greeting {
    private static final Logger log = LoggerFactory.getLogger(Greeting.class);

    @JsonProperty
    private String [] words;

    public Greeting() {
    }

    public Greeting(String[] words) {
        this.words = words;
    }

    public String [] controlWords(String [] word) {
        log.info(Arrays.toString(word));
        if (word.length==0) return new String[0];
        if (word[0]==null|| word[0].equals("")) return new String[0];
        List<String> list = new ArrayList<>();
        list.add(word[0]);
        for (int i = 1; i < word.length; i++) {
            if (word[i]==null || word[i].equals("")) break;
            char [] wordChars = word[i-1].toCharArray();
            char [] nextWordChars = word[i].toCharArray();
            if (wordChars[wordChars.length-1]==nextWordChars[0]){
                list.add(word[i]);
                log.info("list.add("+word[i]+")");
            } else {
                log.info("else block: "+word[i-1]+"&"+word[i]);
                break;
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}

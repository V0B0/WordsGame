package versionone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VersionOneApplicationTests {

    private WordsController controller = new WordsController();

    @Test
    void testControlWords_1() {
        String[] expect = new String[] {"fish", "horse", "egg", "goose", "eagle"};
        Greeting greeting = new Greeting(new String[] {"fish", "horse", "egg", "goose", "eagle"});
        Assertions.assertArrayEquals(expect,
                controller.greetingAnswer(greeting).getWords(),
                "Complete test 1");
    }

    @Test
    void testControlWords_2() {
        String[] expect = new String[] {"fish", "horse"};
        Greeting greeting = new Greeting(new String[] {"fish", "horse", "snake", "goose", "eagle"});
        Assertions.assertArrayEquals(expect,
                controller.greetingAnswer(greeting).getWords(),
                "Complete test 2");
    }

    @Test
    void testControlWords_3() {
        String[] expect = new String[] {"fish", "horse"};
        Greeting greeting = new Greeting(new String[] {"fish", "horse", "", "goose", "eagle"});
        Assertions.assertArrayEquals(expect,
                controller.greetingAnswer(greeting).getWords(),
                "Complete test 3");
    }

    @Test
    void testControlWords_4() {
        String[] expect = new String[] {};
        Greeting greeting = new Greeting(new String[] {"", "horse", "", "goose", "eagle"});
        Assertions.assertArrayEquals(expect,
                controller.greetingAnswer(greeting).getWords(),
                "Complete test 4");
    }
}

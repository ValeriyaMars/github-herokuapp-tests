package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void solutionEnterprizeLoadTest() {
        //1. Открыть github
        open("https://github.com/");
        //2. Навести курсор на меню Solutions
        $(byText("Solutions")).hover();
        //3. Выбрать пункт меню Solutions->Enterprise
        $(byText("Enterprise")).click();
        //4. Проверить, что загрузилась нужная страница (проверить заголовок)
        $(".font-mktg").shouldHave(text("Build like the best"));
    }
}

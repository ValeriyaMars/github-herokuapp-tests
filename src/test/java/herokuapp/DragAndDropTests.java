package herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void actionMoveToElementTest() {
        //Тест падает, элемент не двигается
        $("#column-a").shouldHave(exactText("A"));
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"))
                .release().perform();
        $("#column-a").shouldHave(exactText("B"));
    }

    @Test
    void dragAndDropTest() {

        open("/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(exactText("B"));
    }


}

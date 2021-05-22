import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    static Logger logs = LoggerFactory.getLogger(TextBoxTests.class);

    @BeforeAll
    static void browserInitConf() {
        logs.info("@BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Cena");
        $("[id=userEmail]").setValue("JohnCena@JC.pro");
        $("[id=gender-radio-1]").doubleClick();
        $("[id=userNumber]").setValue("2024561111");

        $("[for=hobbies-checkbox-1]").click();
        $("[id=currentAddress]").setValue("Buckingham Palace London SW1A 1AA");
        $("[id=state").click();
        $("[id=react-select-3-option-0]").click();
        $("[id=city").click();
        $("[id=react-select-4-option-0]").click();
        $("[id=submit").click();

        $("tbody").shouldHave(text("John Cena"),
                text("JohnCena@JC.pro"),
                text("Male"),
                text("2024561111"),
                text("Sports"),
                text("Buckingham Palace London SW1A 1AA"),
                text("NCR"),
                text("Delhi")
        );

    }

}

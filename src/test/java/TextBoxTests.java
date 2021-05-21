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
        $("[id=currentAddress]").setValue("Buckingham Palace London SW1A 1AA");
        $("[id=submit").click();

        $("tr", 1).shouldHave(text("John Cena"));
        $("tr", 2).shouldHave(text("JohnCena@JC.pro"));
        $("tr", 3).shouldHave(text("Male"));
        $("tr", 4).shouldHave(text("2024561111"));
        $("tr", 5).shouldHave(text("21 May,2021"));
        $("tr", 9).shouldHave(text("Buckingham Palace London SW1A 1AA"));

    }

}

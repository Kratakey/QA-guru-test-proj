import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.UploadFile;
import com.codeborne.selenide.commands.UploadFileFromClasspath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.content.image.png;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
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
        $("[id=dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1958");
        $(".react-datepicker__month-select").selectOption("August");
        $(byText("29"), 1).click();
        $("[id=subjectsInput").setValue("Physics").pressEnter().setValue("Math").pressEnter().setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("input[id=uploadPicture]").uploadFile(new File("src/test/resources/png.jpg"));
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
                text("29 August,1958"),
                text("Physics"),
                text("Math"),
                text("English"),
                text("Sports"),
                text("png.jpg"),
                text("Buckingham Palace London SW1A 1AA"),
                text("NCR"),
                text("Delhi")
        );

    }

}

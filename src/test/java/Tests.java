import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

    static Logger log = LoggerFactory.getLogger(Tests.class);

    @BeforeAll
    static void setUpConfig() {
        log.info("@BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void openGooglePage() {
        log.info("@BeforeEach method");
        open("https://www.google.com/");
    }

    @AfterEach
    void closeBrowser(){
        log.info("@AfterEach");
        closeWebDriver();
    }

    @Test
    void selenideSearchTest() {
        $(byName("q")).setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
    @Test
    void allureSearchTest02() {
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
}

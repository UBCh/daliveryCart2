import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestDeliveryCard2 {
    //DataGenerator.UserInfo userInfo =new DataGenerator.UserInfo();
    //DataGenerator generator = new DataGenerator();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldOrderRepeat() throws InterruptedException {
        DataGenerator.UserInfo userInfo = DataGenerator.Registration.generateUser();
        String meetingDate = DataGenerator.DateGenerate(4);
        String meetingDateNew = DataGenerator.DateGenerateNew(7);
        $("[data-test-id='city'] input").setValue(userInfo.getCity());
        sleep(5000);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDate);
        sleep(5000);
        $("[data-test-id='name'] input").setValue(userInfo.getName());
        $("[data-test-id='phone'] input").setValue(userInfo.getPhone());
        $(".checkbox__text").click();
        $(".button__text").click();
        sleep(5000);
        $(".notification__title").shouldBe(visible);
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + meetingDate));
        $(".button__text").click();
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDateNew);
        $(".button_size_s ").click();
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + meetingDateNew));

    }

}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDeliveryCard2 {
    //DataGenerator.UserInfo userInfo =new DataGenerator.UserInfo();
    //DataGenerator generator = new DataGenerator();
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
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDate);
        $("[data-test-id='name'] input").setValue(userInfo.getName());
        $("[data-test-id='phone'] input").setValue(userInfo.getPhone());
        $(".checkbox__text").click();
        $(".button__text").click();
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

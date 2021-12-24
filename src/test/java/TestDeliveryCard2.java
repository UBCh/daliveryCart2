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
   DataGenerator.UserInfo userInfo =new DataGenerator.UserInfo();
      //DataGenerator generator = new DataGenerator();
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldOrderRepeat() throws InterruptedException {

       $("[data-test-id='city'] input").setValue(userInfo.getCity());

        //$("[data-test-id='city'] input").setValue(generator.generateCity());
        //$("[data-test-id='city'] input").setValue("Краснодар");

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(userInfo.getDate());

        //$("[data-test-id='date'] input").setValue(generator.generateDate());
        //$("[data-test-id='date'] input").setValue("27.12.2021");

        $("[data-test-id='name'] input").setValue(userInfo.getName());

        //$("[data-test-id='name'] input").setValue(generator.generateName());
        //$("[data-test-id='name'] input").setValue("мадама Брошкина");

        $("[data-test-id='phone'] input").setValue(userInfo.getPhone());

        //$("[data-test-id='phone'] input").setValue(generator.generatePhone());
        //$("[data-test-id='phone'] input").setValue("+7967438724");

        Thread.sleep(5000);
        $(".checkbox__text").click();
        Thread.sleep(5000);
        $(".button__text").click();
        Thread.sleep(5000);
        $(".notification__title").shouldBe(visible);
        Thread.sleep(5000);
       $(".notification__content").shouldBe(visible)
              .shouldHave(exactText("Встреча успешно забронирована на " + userInfo.getDate()));

        //$(".notification__content").shouldBe(visible)
                //.shouldHave(exactText("Встреча успешно забронирована на " + generator.generateDate()));
        //$(".notification__content").shouldBe(visible)
               // .shouldHave(exactText("Встреча успешно запланирована на 27.12.2021"));

        Thread.sleep(5000);
        $(".button__text").click();
        Thread.sleep(5000);
        $(".button_size_s ").click();
        Thread.sleep(5000);
        $(withText("Успешно!")).shouldBe(visible);

    }

}

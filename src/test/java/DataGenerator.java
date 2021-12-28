import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {


    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));


    public static String generateCity() {
        String city = faker.address().cityName();
        return city;
    }

    public static String DateGenerate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String DateGenerateNew(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName() {
        String name = faker.name().fullName();
        return name;
    }

    private static String generatePhone() {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {

        private Registration() {
        }

        public static UserInfo generateUser() {

            return new UserInfo(generateCity(), generateName(), generatePhone());
        }

    }

    //@Data
    //@RequiredArgsConstructor
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

    }

}

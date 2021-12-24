import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator{


    public DataGenerator() {
    }

    static Faker faker;



    @BeforeEach
    void setUpAll() {
       faker = new Faker(new Locale("ru"));
        }

    public static String generateCity() {
        String city = faker.address().cityName();
        return city;
    }

    public static String DateGenerate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String generateDate() {
        String date = DateGenerate(4);
        return date;
    }
    
    public static String generateName() {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone() {
        PhoneNumber phone = faker.phoneNumber();
        return String.valueOf(phone);
    }
    @Data
    @RequiredArgsConstructor
    public static class UserInfo {
        String city;
        String date;
        String name;
        String phone;

       }

}

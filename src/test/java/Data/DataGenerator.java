package Data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

    public static String generateCity() {
        List cities = Arrays.asList("Москва", "Магадан", "Самара", "Майкоп", "Кострома", "Махачкала", "Великий Новгород", "Саратов", "Севастополь", "Симферополь", "Краснодар", "Красноярск", "Псков", "владивосток", "Смоленск", "Ставрополь", "Астрахань", "Тула", "Тамбов");
        Random randomizer = new Random();
        Object city = cities.get(randomizer.nextInt(cities.size()));
        return (String) city;
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }

    }
}
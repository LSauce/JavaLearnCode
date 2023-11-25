package _02dsdb.fakerdata;


import net.datafaker.Faker;

import java.util.Locale;

/**
 * @author kiro
 * @description:
 * @data 15:31 25/11/2023
 **/
public class FakerUtils {
    public static void main(String[] args) {
        testFaker();
    }

    public static void  testFaker(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        for (int i = 0; i < 10; i++) {

        }
    }

}

package dev.sandbox;

import dev.sandbox.entity.TestEntity;
import dev.sandbox.entity.TestEnum;
import dev.sandbox.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        testService.createTestEntity();
        TestEntity testEntity = testService.findTestEntityByTestEnum(TestEnum.FIRST_VALUE);
        System.out.println("Value: " + testService.getEnumValueInCurrentLanguage(testEntity));
    }

}

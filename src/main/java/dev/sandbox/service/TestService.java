package dev.sandbox.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sandbox.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TestService {

    private final ObjectMapper customObjectMapper;

    @Autowired
    public TestService(ObjectMapper customObjectMapper) {
        this.customObjectMapper = customObjectMapper;
    }

    public void writeToJson() throws IOException {
        TestModel testModel = createTestModel();
        ObjectMapper objectMapper = new ObjectMapper();
        String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testModel);
        System.out.println("Without custom configuration: " + output);

        output = customObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testModel);
        System.out.println("With custom configuration: " + output);
    }

    private TestModel createTestModel() {
        TestModel testModel = new TestModel();
        testModel.setTestLocalDateTime(LocalDateTime.now());
        testModel.setTestLocalDate(LocalDate.now());
        return testModel;
    }

}

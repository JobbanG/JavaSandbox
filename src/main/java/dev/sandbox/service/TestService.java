package dev.sandbox.service;

import dev.sandbox.entity.TestEntity;
import dev.sandbox.entity.TestEnum;
import dev.sandbox.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final MessageService messageService;
    private final TestRepository testRepository;

    @Autowired
    public TestService(MessageService messageService, TestRepository testRepository) {
        this.messageService = messageService;
        this.testRepository = testRepository;
    }

    public String getEnumValueInCurrentLanguage(TestEntity testEntity) {
        return messageService.getValueInCurrentLanguage(testEntity.getTestEnum().toString());
    }

    public void createTestEntity() {
        TestEntity testEntity = new TestEntity();
        testEntity.setTestEnum(TestEnum.FIRST_VALUE);
        testRepository.save(testEntity);
    }

    public TestEntity findTestEntityByTestEnum(TestEnum testEnum) {
        return testRepository.findByTestEnum(testEnum);
    }

}

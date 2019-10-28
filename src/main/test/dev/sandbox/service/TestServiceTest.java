package dev.sandbox.service;

import dev.sandbox.entity.TestEntity;
import dev.sandbox.entity.TestEnum;
import dev.sandbox.repository.TestRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestServiceTest {

    @Mock
    private TestRepository testRepository;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private TestService underTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEnumValueInCurrentLanguage() {
        // GIVEN
        TestEntity testEntity = new TestEntity();
        testEntity.setTestEnum(TestEnum.SECOND_VALUE);
        when(messageService.getValueInCurrentLanguage("second.value")).thenReturn("Second value");

        // WHEN
        String actual = underTest.getEnumValueInCurrentLanguage(testEntity);

        // THEN
        assertEquals("Second value", actual);
    }

    @Test
    public void createTestEntity() {
        // WHEN
        underTest.createTestEntity();

        // THEN
        ArgumentCaptor<TestEntity> captor = ArgumentCaptor.forClass(TestEntity.class);
        verify(testRepository).save(captor.capture());
        assertEquals(TestEnum.FIRST_VALUE, captor.getValue().getTestEnum());
    }

    @Test
    public void findTestEntityByTestEnum() {
        // GIVEN
        TestEntity testEntity = new TestEntity();
        testEntity.setId(1);
        testEntity.setTestEnum(TestEnum.SECOND_VALUE);
        when(testRepository.findByTestEnum(TestEnum.SECOND_VALUE)).thenReturn(testEntity);

        // WHEN
        TestEntity actual = underTest.findTestEntityByTestEnum(TestEnum.SECOND_VALUE);

        // THEN
        assertEquals(TestEnum.SECOND_VALUE, actual.getTestEnum());
        assertEquals(1, actual.getId());
    }

}

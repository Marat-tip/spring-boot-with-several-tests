package kz.halykacademy.testappp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(classes = PhoneValidationService.class)
public class PhoneValidationTest {
    @Autowired
    private PhoneValidationService validator;

    @Test
    public void invalidLengthPhone() {
        assertSame(PhoneValidationResult.INVALID_LENGTH, validator.validatePhone("123456"));
    }

    @Test
    public void invalidStart() {
        assertSame(PhoneValidationResult.INVALID_START, validator.validatePhone("1234567890"));
    }
}

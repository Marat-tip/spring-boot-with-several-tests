package kz.halykacademy.testappp;

import org.springframework.stereotype.Service;

import static kz.halykacademy.testappp.PhoneValidationResult.INVALID_LENGTH;
import static kz.halykacademy.testappp.PhoneValidationResult.INVALID_START;
import static kz.halykacademy.testappp.PhoneValidationResult.VALID;

@Service
public class PhoneValidationService {
    private final static int VALID_PHONE_LENGTH = 10;

    public PhoneValidationResult validatePhone(String phone) {
        if (invalidLength(phone)) {
            return INVALID_LENGTH;
        }

        if (invalidStart(phone)) {
            return INVALID_START;
        }
        //TODO other checks
        return VALID;
    }

    private boolean invalidStart(String phone) {
        return !phone.startsWith("7");
    }

    private boolean invalidLength(String phone) {
        return phone.length() != VALID_PHONE_LENGTH;
    }
}

package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UpperCaseLetterRuleTest {
    private UpperCaseLetterRule rule;

    @BeforeEach
    public void setup() {
        PasswordValidatorConfig passwordValidatorConfig = mock(PasswordValidatorConfig.class);
        when(passwordValidatorConfig.getMinUpperCase()).thenReturn(3);

        rule = new UpperCaseLetterRule(passwordValidatorConfig);
    }

    @Test
    public void testApply() {
        assertTrue(rule.apply("ab12I34@#AH"));
        assertFalse(rule.apply("123490"));
        assertFalse(rule.apply( null));
    }

    @Test
    public void testIsMandatory() {
        assertFalse(rule.isMandatory());
    }
}

package com.stefaninitest;

import org.junit.Test;
import java.io.IOException;
import com.stefaninitest.exceptions.ParameterException;

import static com.stefaninitest.utils.TestUtils.EXPECTED_CORRECT_PATH;
import static com.stefaninitest.utils.TestUtils.TEST_CORRECT_ARGS;
import static com.stefaninitest.utils.TestUtils.TEST_INCORRECT_ARGS;
import static com.stefaninitest.utils.TestUtils.TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ParametersTest {

    @Test
    public void ofMethodShouldReturnCorrectParameterObjectTest() throws ParameterException {
        final int expectedTopValue = 5;
        final int expectedPhraseSizeValue = 3;

        final var actualParameters = Parameters.of(TEST_CORRECT_ARGS);

        assertEquals(expectedTopValue, actualParameters.getTop());
        assertEquals(EXPECTED_CORRECT_PATH, actualParameters.getPath());
        assertEquals(expectedPhraseSizeValue, actualParameters.getPhraseSize());
    }

    @Test
    public void getTextFromFileShouldReturnCorrectTextTest() throws ParameterException, IOException {
        final var parameters = Parameters.of(TEST_CORRECT_ARGS);

        String actualText = parameters.getTextFromFile();

        assertEquals(TEXT, actualText);
    }

    @Test
    public void ofMethodShouldThrowExceptionWhenArgsAreIncorrect() {
        assertThrows(ParameterException.class, () -> Parameters.of(TEST_INCORRECT_ARGS));
    }
}

package com.stefaninitest;

import org.junit.Test;
import com.stefaninitest.validators.ParamsValidator;
import com.stefaninitest.exceptions.ParameterException;

import static com.stefaninitest.utils.TestUtils.NEGATIVE_INT_VALUE_STRING;
import static com.stefaninitest.utils.TestUtils.NON_INT_VALUE_STRING;
import static com.stefaninitest.utils.TestUtils.NON_EXISTENT_PATH;
import static com.stefaninitest.utils.TestUtils.PATH_TO_DIRECTORY;
import static com.stefaninitest.utils.TestUtils.EMPTY_PATH;
import static org.junit.Assert.assertThrows;

public class ParametersValidatorTest {

    @Test
    public void getValidatedTopShouldThrowParameterExceptionWhenIntValueIsNegativeTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedTop(NEGATIVE_INT_VALUE_STRING));
    }

    @Test
    public void getValidatedTopShouldThrowParameterExceptionWhenValueIsNonIntTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedTop(NON_INT_VALUE_STRING));
    }

    @Test
    public void getValidatedPhraseSizeShouldThrowParameterExceptionWhenIntValueIsNegativeTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedPhraseSize(NEGATIVE_INT_VALUE_STRING));
    }

    @Test
    public void getValidatedPhraseSizeShouldThrowParameterExceptionWhenValueIsNonIntTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedTop(NON_INT_VALUE_STRING));
    }

    @Test
    public void getValidatedPathShouldThrowExceptionWhenPathDoesNotExistTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedPath(NON_EXISTENT_PATH));
    }

    @Test
    public void getValidatedPathShouldThrowExceptionWhenPathIsDirectoryTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedPath(PATH_TO_DIRECTORY));
    }

    @Test
    public void getValidatedPathShouldThrowExceptionWhenPathIsEmptyTest() {
        assertThrows(ParameterException.class, () -> ParamsValidator.getValidatedPath(EMPTY_PATH));
    }


}

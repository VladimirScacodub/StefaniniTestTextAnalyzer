package com.stefaninitest.validators;

import com.stefaninitest.exceptions.ParameterException;

import java.io.File;
import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isReadable;

public class ParamsValidator {

    public static Path getValidatedPath(String pathStr) throws ParameterException {
        File file = new File(pathStr);
        Path path = Path.of(file.getAbsolutePath());
        if(pathStr.isBlank() || pathStr.isEmpty()){
            throw new ParameterException("File path should not be empty or blank!");
        }
        if (!exists(path)){
            throw new ParameterException("File does not exists!");
        }
        if (!isReadable(path)){
            throw new ParameterException("File can not be read!");
        }
        if (isDirectory(path)){
            throw new ParameterException("File can not be directory!");
        }
        return path;
    }

    public static int getValidatedTop(String topParam) throws ParameterException {
        return getValidatedIntParameter(topParam, "top");
    }

    public static int getValidatedPhraseSize(String phraseSize) throws ParameterException {
        return getValidatedIntParameter(phraseSize, "phraseSize");
    }

    private static int getValidatedIntParameter(String param, String paramName) throws ParameterException {
        int intVal;
        try {
            intVal = Integer.parseInt(param);
        } catch (NumberFormatException e){
            throw new ParameterException("\"" + paramName + "\" parameter should be int value");
        }
        if (intVal < 1){
            throw new ParameterException("\"" + paramName + "\" parameter should be bigger than zero");
        }
        return intVal;
    }
}

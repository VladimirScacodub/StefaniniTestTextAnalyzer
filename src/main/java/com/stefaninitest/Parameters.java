package com.stefaninitest;

import com.stefaninitest.exceptions.ParameterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static com.stefaninitest.validators.ParamsValidator.getValidatedPath;
import static com.stefaninitest.validators.ParamsValidator.getValidatedPhraseSize;
import static com.stefaninitest.validators.ParamsValidator.getValidatedTop;

class Parameters {

    private final Path path;
    private final int top;
    private final int phraseSize;

    private Parameters(Path path, int top, int phraseSize) {
        this.path = path;
        this.top = top;
        this.phraseSize = phraseSize;
    }

    public String getTextFromFile() throws IOException {
        String text;
        var linesStream = Files.lines(path.toAbsolutePath());
        text = linesStream.collect(Collectors.joining("\n"));
        linesStream.close();
        return text;
    }

    public Path getPath() {
        return path;
    }

    public int getTop(){
        return top;
    }

    public int getPhraseSize(){
        return phraseSize;
    }

    public static Parameters of(String[] args) throws ParameterException {
        final String errorMessage = "User should provide parameters: -path, -top and -phraseSize";
        if (args.length == 0){
            throw new ParameterException(errorMessage);
        }
        Path path = null;
        int top = 0;
        int phraseSize = 0;
        for (String param : args) {
            param = param.toLowerCase().trim();
            if (param.startsWith("-path=")) {
                path = getValidatedPath(param.substring(6));
                continue;
            }
            if (param.startsWith("-top=")) {
                top = getValidatedTop(param.substring(5));
                continue;
            }
            if (param.startsWith("-phrasesize=")) {
                phraseSize = getValidatedPhraseSize(param.substring(12));
                continue;
            }
            throw new ParameterException(errorMessage);
        }

        return new Parameters(path, top, phraseSize);
    }

}


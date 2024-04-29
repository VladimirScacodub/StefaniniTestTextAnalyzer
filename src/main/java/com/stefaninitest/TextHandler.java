package com.stefaninitest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;

public class TextHandler {

    private final List<String> listOfWords;
    private Integer numberOfSentences;
    private int maxAlign;

    public TextHandler(String text) {
        numberOfSentences = 0;
        maxAlign = 7;
        listOfWords = Arrays.stream(text.split("[\\s]"))
                .peek(this::countSentences)
                .flatMap(this::splitWordByNonAlphanumericSymbols)
                .collect(Collectors.toList());
    }

    public int getNumberOfWords() {
        return listOfWords.size();
    }

    public Integer getNumberOfSentences() {
        return numberOfSentences;
    }

    public String showInfo(int top, int phraseSize) {
        StringBuilder resultStringBuilder = new StringBuilder();

        String formatForWordsAndSentencesCounts = "| %-20s| %-3s |\n";
        resultStringBuilder.append("+---------------------+-----+\n");
        resultStringBuilder.append(format(formatForWordsAndSentencesCounts, "Number of words:", getNumberOfWords()));
        resultStringBuilder.append("+---------------------+-----+\n");
        resultStringBuilder.append(format(formatForWordsAndSentencesCounts, "Number of sentences:", getNumberOfSentences()));
        resultStringBuilder.append("+---------------------+-----+\n\n");

        var topWordsCounts = getTopWordsCounts(top, countPhrases(phraseSize));
        String formatForPhrasesCounts = "| %-" + (maxAlign) + "s | %5s |\n";
        resultStringBuilder.append(format("+" + getCopiesOfMinus(maxAlign) + "+-------+\n"));
        resultStringBuilder.append(format(formatForPhrasesCounts, "Phrases", "Count"));
        resultStringBuilder.append(format("+" + getCopiesOfMinus(maxAlign) + "+-------+\n"));
        for (Map.Entry<String, Integer> entry : topWordsCounts) {
            resultStringBuilder.append(format(formatForPhrasesCounts, entry.getKey(), entry.getValue()));
        }
        resultStringBuilder.append(format("+" + getCopiesOfMinus(maxAlign) + "+-------+\n"));

        return resultStringBuilder.toString();
    }

    private static String getCopiesOfMinus(int maxAlign) {
        int maxMinusNumber = Math.min(maxAlign + 2, 227);
        return IntStream.range(0, maxMinusNumber)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    private void countSentences(String word) {
        if (word.matches("[A-Za-z0-9]+[.!?]")) {
            numberOfSentences++;
        }
    }

    private Stream<String> splitWordByNonAlphanumericSymbols(String word) {
        return Arrays.stream(word.split("[^a-zA-Z0-9'$]"))
                .filter(str -> !str.isEmpty() && !str.isBlank());
    }

    public List<Map.Entry<String, Integer>> getTopWordsCounts(int top, Map<String, Integer> mapOfWordsCounts) {
        return mapOfWordsCounts.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .limit(top)
                .peek(this::setMaxAlign)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> countPhrases(int phraseSize) {
        if (phraseSize > listOfWords.size()) {
            phraseSize = listOfWords.size();
        }

        Map<String, Integer> mapOfWordsCounts = new HashMap<>();
        for (int i = 0; i < listOfWords.size(); i++) {
            if (i + phraseSize > listOfWords.size()) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < i + phraseSize && j < listOfWords.size(); j++) {
                stringBuilder.append(listOfWords.get(j).toLowerCase()).append(" ");
            }
            mapOfWordsCounts.merge(stringBuilder.toString().trim(), 1, Integer::sum);
        }

        return mapOfWordsCounts;
    }

    private void setMaxAlign(Map.Entry<String, Integer> word) {
        int wordLength = word.getKey().length();
        if (maxAlign < wordLength) {
            maxAlign = wordLength;
        }
    }

}

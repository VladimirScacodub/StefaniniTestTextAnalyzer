package com.stefaninitest.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

    public static final String TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

    public static final String NEGATIVE_INT_VALUE_STRING = "-1";

    public static final String NON_INT_VALUE_STRING = "Hi";

    public static final String NON_EXISTENT_PATH = "/path/does/not/exist.txt";

    public static final String PATH_TO_DIRECTORY = "src/";

    public static final String EMPTY_PATH = "";

    public static final String CORRECT_PATH_TO_TXT_FILE = "src/test/java/com/stefaninitest/utils/resources/testText.txt";

    public static final String[] TEST_CORRECT_ARGS = new String[]{"-path=" + CORRECT_PATH_TO_TXT_FILE, "-top=5", "-phraseSize=3"};

    public static final String[] TEST_INCORRECT_ARGS = new String[]{"-pathers=" + CORRECT_PATH_TO_TXT_FILE, "-topd=5", "-phaseSize=3"};

    public static final Path EXPECTED_CORRECT_PATH = Paths.get(new File(CORRECT_PATH_TO_TXT_FILE).getAbsolutePath());

    public static final String OUTPUT = "+---------------------+-----+\n" +
            "| Number of words:    | 43  |\n" +
            "+---------------------+-----+\n" +
            "| Number of sentences:| 2   |\n" +
            "+---------------------+-----+\n\n" +
            "+-----------------+-------+\n" +
            "| Phrases         | Count |\n" +
            "+-----------------+-------+\n" +
            "| lorem ipsum     |     2 |\n" +
            "| dummy text      |     2 |\n" +
            "| to make         |     1 |\n" +
            "| unknown printer |     1 |\n" +
            "| is simply       |     1 |\n" +
            "+-----------------+-------+\n";

}
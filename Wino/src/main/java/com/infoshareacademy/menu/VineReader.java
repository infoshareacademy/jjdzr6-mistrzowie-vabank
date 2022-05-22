package com.infoshareacademy.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class VineReader {
    public void loadVineAsResource() throws IOException {

        try (InputStream inputStream = getClass().getResourceAsStream("/Vine.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(contents);
        }
    }
}

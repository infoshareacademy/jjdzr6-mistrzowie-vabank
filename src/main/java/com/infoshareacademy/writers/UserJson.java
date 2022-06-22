package com.infoshareacademy.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.domain.User;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UserJson {
    List<User> users = Arrays.asList(
            new User(0, "Janek", "Password", "Jan", "Kowalski", "jankowalski@yahoo.com", 123456789),
            new User(1, "Matiu", "Haslo", "Mateusz", "Jankowski", "mateuszjankowski@yahoo.com", 789456123),
            new User(2, "Casi", "qwerty", "Kasia", "Solecka", "kasiasolecka@yahoo.com", 456789321),
            new User(3, "Marti", "asdfgh", "Martyna", "Elska", "martynaelska@yahoo.com", 357891264)
    );
    public void WritingUserToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/User.json"));
        gson.toJson(users, writer);

        writer.close();
    }
}

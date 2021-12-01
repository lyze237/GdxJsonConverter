package dev.lyze;

import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("Usage: stdin => gdx json, stdout => actual json");
            System.exit(-1);
        }

        try {
            InputStreamReader inputReader = new InputStreamReader(System.in);
            JsonValue value = new JsonReader().parse(inputReader);
            inputReader.close();

            String json = value.toJson(JsonWriter.OutputType.json);

            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

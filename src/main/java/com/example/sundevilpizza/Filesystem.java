package com.example.sundevilpizza;

import static java.lang.System.out;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filesystem {

    JSONParser jsonParser = new JSONParser();

    FileReader reader = new FileReader(".\\src\\main\\java\\com.example.sundevilpizza\\test.json");

    Object obj = jsonParser.parse(reader);
    JSONObject empjsonobj = (JSONObject)obj;

    String fname = (String)empjsonobj.get("title");
//    System.out.print("First name:" + fname);

    public Filesystem() throws IOException, ParseException {
    }
}

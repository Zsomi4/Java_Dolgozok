package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
* File: Restapi.java
* Author: Gubis Zsombor Dániel
* Copyright: 2023, Gubis Zsombor Dániel
* Group: Szoft II N
* Date: 2023-02-19
* Github: https://github.com/zsomi4/
* Licenc: GNU GPL
*/

public class Restapi {
    String host;
    public Restapi() {
        this.host = "http://localhost:3000/";
    }
    public String getEmployee() {
        String response = null;
        try {
            response = tryGetEmployee();
        }catch (MalformedURLException e) {
            System.err.println("Hiba! Érvénytelen URL!");
        }catch(IOException e) {
            System.err.println("Hiba! A REST API elérése sikeretelen!");
        }
        return response;
    }
    public String tryGetEmployee() 
            throws MalformedURLException, IOException {
        String endpoint = "employee";
        String urlStr = this.host + endpoint;
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();
        int responseCode = http.getResponseCode();
        String text = null;
        if(responseCode == 200) {
            InputStream inputStream = http.getInputStream();
            text = this.convertInputStreamToString(inputStream);
        }else {
            text = "--hiba--";
        }
        return text;
    }
    private String convertInputStreamToString(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        Scanner scanner = new Scanner(reader);
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        return stringBuilder.toString();
    }
    public ArrayList<Employee> getEmployees() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getEmployee();
        Employee[] employeeArray = gson.fromJson(text, Employee[].class);
        ArrayList<Employee> employeeList =
            new ArrayList<>(Arrays.asList(employeeArray));
        return employeeList;
    }

}

package com.hakki.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper=new ObjectMapper();

          //  Student student=objectMapper.readValue(new File("data/sample-lite.json"),Student.class);
            Student student1=objectMapper.readValue(new File("data/sample-full.json"),Student.class);
            System.out.println("Student firstname = "+student1.getFirstName());
            System.out.println("Student lastname = "+student1.getLastName());
            System.out.println("Student is active ? => "+student1.isActive());
            System.out.println("Student address = "+student1.getAddress());
            System.out.println("Student languages = "+student1.getLanguages());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

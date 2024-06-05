package com.epam.mjc.io;

import java.io.*;

import java.util.HashMap;
import java.util.Map;


public class FileReader {






    public Profile getDataFromFile(File file) {

        Map<String,String>hashmap=new HashMap<String, String>();

        FileInputStream fis = null;
        String str = "";

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                str += (char) content;
            }

            System.out.println("After reading file");
            System.out.println(str);

            String[] keyVals = str.split("[:\\n]");

            return new Profile(keyVals[1].trim(),
                    Integer.parseInt(keyVals[3].trim()),
                    keyVals[5].trim(),
                    Long.parseLong(keyVals[7].trim()));


            /*String[] array=str.split("\r\n");
            System.out.println(array.length);







            for (String item : array){
                String [] key=item.split(":");

                if (key.length==2){
                    hashmap.put(key[0],key[1]);


                }

                else {
                System.out.println("isn't work");
                }



             }*/













        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        return new Profile();
    }

    public static void main(String[] args) {

       File file=new File("C:\\Users\\user\\stage1-module6-io-task1\\target\\classes\\Profile.txt");



        FileReader fileReader=new FileReader();
        fileReader.getDataFromFile(file);








    }
}

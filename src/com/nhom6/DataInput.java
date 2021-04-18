package com.nhom6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataInput {
	 private final static String FILE_URL = "D:\\oop.txt";//file dau vao
	 
    public static void main(String[] args) throws IOException {
        File file = new File(FILE_URL);
    	
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// doc tung ki tu
        BufferedReader reader = new BufferedReader(inputStreamReader);
    }
    	
}

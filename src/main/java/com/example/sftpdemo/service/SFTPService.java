package com.example.sftpdemo.service;

import java.util.Map;

public class SFTPService {
    public void downloadAndProcessFile(String fileContent, Map<String, Object> headers) {
        System.out.println("File: " + headers.get("fileName") + " | Content: " + fileContent);
    }
}

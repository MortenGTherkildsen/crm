package com.example.crm.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserInfo {
    public static String username = "admin";
    public static String password = "f0480c4f5bd0ad186514b2d7d26f63393967bc7b5ff2f480c9f6e22cce2bc3369b4a4b2f303e42b9464a2470d2452524a3e938d25d3f1babe476f2e8378a7c20";
    public static boolean isLoggedIn = false;
    public static String loginError = "";

    public static boolean checkLogin(String userInput, String passInput) {
        loginError = "";
        passInput = UserInfo.getSHA512(passInput);
        if (userInput.equalsIgnoreCase(username) && passInput.equalsIgnoreCase(password)) {
            isLoggedIn = true;
            return true;
        } else {
            isLoggedIn = false;
            loginError = "Brugernavn eller kodeord er forkert";
            return false;
        }
    }

    public static void logout() {
        loginError = "Du er nu logget ud";
        isLoggedIn = false;
    }

    public static String getSHA512(String passwordToHash) {
        String generatedPassword = null;
        String salt = "CRM";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
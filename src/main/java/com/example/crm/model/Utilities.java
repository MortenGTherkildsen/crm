package com.example.crm.model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utilities {

    private static Random rand = new Random((new Date()).getTime());

    public static String StringEncrypt(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(str.getBytes());
    }

    public static String StringDecrypt(String encstr) {
        if (encstr.length() > 12) {
            String cipher = encstr.substring(12);
            BASE64Decoder decoder = new BASE64Decoder();

            try {
                return new String(decoder.decodeBuffer(cipher));
            } catch (IOException e) {
                //  throw new InvalidImplementationException(
                //Fail
            }
        }
        return null;
    }

    public static String TimestampToDatestamp(Date date) {
        final Calendar c = Calendar.getInstance();
        String Datestamp = "";

        c.setTime(date);
        Datestamp += c.get(Calendar.DATE);
        Datestamp += "/" + c.get(Calendar.MONTH);
        Datestamp += " " + c.get(Calendar.YEAR);

        Datestamp += " " + c.get(Calendar.HOUR);
        Datestamp += ":" + c.get(Calendar.MINUTE);

        return Datestamp; // Format: d/M Y H:m
    }

}

package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Nick on 11/14/2016.
 */
public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length < 3)
        {
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists())
        {
            System.out.println("File exists, please remove it manually: " + file);
            return;
        }

        List<ContactData> contacts = generateRandomContatcts(amount);
        if ("csv".equals(format)) {
            saveContatcsToCsvFile(contacts, file);
        } else if ("xml".equals(format)) {
            saveContatcsToXmlFile(contacts, file);
        } else {
            System.out.println("Unknown format " + format);
        }
    }

    private static void saveContatcsToXmlFile(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        String xml = xStream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    public static List<ContactData> loadContactsFromXmlFile(File file) {
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        return (List<ContactData>) xStream.fromXML(file);
    }

    private static void saveContatcsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact : contacts)
        {
            writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + ","
            + contact.getHomePhone() + "," + contact.getMobilePhone() + "," + contact.getWorkPhone() + ","
            + contact.getFirstEmail() + "," + contact.getSecondEmail() + "," + contact.getDayOfBirthday() + ","
            + contact.getMonthOfBirthday() + "," + contact.getYearOfBirthday() + "," + contact.getSecondAddress() + ","
            + contact.getSecondHomePhone() + ",!" +  "\n");
        }
        writer.close();
    }

    public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
        List<ContactData> list = new ArrayList<>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null)
        {
            String[] part = line.split(",");
            ContactData contact = new ContactData().
                    withFirstName(part[0]).
                    withLastName(part[1]).
                    withAddress(part[2]).
                    withHomePhone(part[3]).
                    withMobilePhone(part[4]).
                    withWorkPhone(part[5]).
                    withFirstEmail(part[6]).
                    withSecondEmail(part[7]).
                    withDayOfBirthday(part[8]).
                    withMonthOfBirthday(part[9]).
                    withYearOfBirthday(part[10]).
                    withSecondAddress(part[11]).
                    withSecondHomePhone(part[12]);
            list.add(contact);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }

    public static List<ContactData> generateRandomContatcts(int amount) {
        List<ContactData> list = new ArrayList<>();
        for (int i = 0; i < amount; i++)
        {
            ContactData contact = new ContactData().
                    withFirstName(generateRandomString()).
                    withLastName(generateRandomString()).
                    withAddress(generateRandomString()).
                    withHomePhone(generateRandomString()).
                    withMobilePhone(generateRandomString()).
                    withWorkPhone(generateRandomString()).
                    withFirstEmail(generateRandomEmail()).
                    withSecondEmail(generateRandomEmail()).
                    withDayOfBirthday("13").
                    withMonthOfBirthday("June").
                    withYearOfBirthday("1989").
                    withSecondAddress(generateRandomString()).
                    withSecondHomePhone(generateRandomString());
            list.add(contact);
        }
        return list;
    }

    public static String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    private static String generateRandomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }
}

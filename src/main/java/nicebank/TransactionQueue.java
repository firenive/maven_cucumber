package nicebank;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TransactionQueue {
    private static String MESSAGES_FOLDER = "./messages";
    private static String MESSAGE_FILE_PATH = "%s/%03d";
    private int nextId = 1;

    public static void clear() {
        try {
            FileUtils.deleteDirectory(new File(MESSAGES_FOLDER));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new File(MESSAGES_FOLDER).mkdirs();
    }

    public void write(String transaction) {
        String messageFilePath = String.format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);


        try (PrintWriter writer = new PrintWriter(messageFilePath, StandardCharsets.UTF_8)) {
            writer.println(transaction);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nextId++;
    }

    public String read() {
        // Get files in messages
        File messageFolder = new File(MESSAGES_FOLDER);
        File[] messages = messageFolder.listFiles();
        String message = "";
        // if a message file found
        if (messages != null && messages.length > 0) {
            Arrays.sort(messages, new Comparator<File>() {
                @Override
                public int compare(File f1, File f2) {
                    return Integer.parseInt(f1.getName()) - Integer.parseInt(f2.getName());
                }
            });
            // Open it
            try (Scanner scanner = new Scanner(messages[0])) {
                if (scanner.hasNextLine()) {
                    message = scanner.nextLine();
                    scanner.close();
                    // Delete it
                    messages[0].delete();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return message;

    }

}

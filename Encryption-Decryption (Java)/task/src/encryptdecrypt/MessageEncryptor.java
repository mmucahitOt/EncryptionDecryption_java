package encryptdecrypt;

import encryptdecrypt.enums.Command;
import encryptdecrypt.packages.Encryptor;
import encryptdecrypt.packages.FileManager;
import encryptdecrypt.packages.enums.Algorithm;

import java.util.Scanner;

public class MessageEncryptor {
    static Scanner scanner = new Scanner(System.in);
    Command command;
    Encryptor encryptor;


    private MessageEncryptor() {};
    public static MessageEncryptor startCoding(String inputCommand, String inputKey, String data, String fileName, Algorithm algorithm) {
        try {
            MessageEncryptor messageEncryptor = new MessageEncryptor();
            messageEncryptor.command = validateInputCommand(inputCommand);
            int key = validateInputKey(inputKey);
            messageEncryptor.encryptor = Encryptor.build((data != null ? data : ""), key, algorithm);
            messageEncryptor.carryOutCommand(fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    static Command validateInputCommand(String inputCommand) throws Exception {
        if (inputCommand == null) {
            return Command.ENC;
        }
        return Command.validateInputCommand(inputCommand);
    }
    static int validateInputKey(String inputKey) {
        if (inputKey == null || inputKey.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(inputKey);
        }
    }


    void carryOutCommand(String fileName) {
        if (this.command == Command.ENC) {
            String encryptedMessage = this.encryptMessage();
            System.out.println(encryptedMessage);
            if (fileName != null) {
                FileManager.writeData(fileName, encryptedMessage);
            }
        } else if  (this.command == Command.DEC) {
            String decryptedMessage = this.decryptMessage();
            System.out.println(decryptedMessage);
            if (fileName != null) {
                FileManager.writeData(fileName, decryptedMessage);
            }
        }
    }

    private void inputCommand() throws Exception {
        String input = scanner.nextLine();
        this.command = Command.validateInputCommand(input);
    }


    public String encryptMessage() {
        return this.encryptor.encryptedMessage;
    }

    public String decryptMessage() {
        return this.encryptor.decryptMessage();
    }
}

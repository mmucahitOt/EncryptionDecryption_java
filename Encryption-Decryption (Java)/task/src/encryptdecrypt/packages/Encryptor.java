package encryptdecrypt.packages;

import encryptdecrypt.packages.enums.Algorithm;

import java.util.Objects;

public class Encryptor {
    private int startCode;
    private int key;
    static char[] letters =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String message;
    public String encryptedMessage;

    public Algorithm algorithm;

    private Encryptor() {};

    public static Encryptor build(String message, int key, Algorithm algorithm) {
        Encryptor encryptor = new Encryptor();
        encryptor.algorithm = algorithm;
        encryptor.message = message;
        encryptor.key = key;
        encryptor.encryptedMessage = encryptor.encryptMessage();

        return encryptor;
    }


    public String encryptMessage() {
        if (algorithm == Algorithm.SHIFT) {
            return this.shiftEnc();
        } else {
            return this.defaultEnc();
        }
    }

    public String decryptMessage() {
        if (algorithm == Algorithm.SHIFT) {
            return this.shiftDec();
        } else {
            return this.defaultDec();
        }
    }

    public String defaultEnc() {

        String[] strings = this.message.split("");
        for (int i=0;i<this.message.length();i++) {
            //if (!Character.isAlphabetic(this.message.charAt(i))) { Objects.equals(this.message.charAt(i), ' ') ||
            //    continue;
            //}
            char character = this.message.charAt(i);
            strings[i] = String.valueOf(this.defaultEncCharacter(character));
        }
        return Helper.mergeStrings(strings);
    }


    private char defaultEncCharacter(char character) {
        this.revaluateStartCode(character);
        return (char) ((int) character  + this.key); // (char) (this.startCode + (((int) character - this.startCode) + this.key) % 26);
    }

    public String defaultDec() {

        String[] strings = this.message.split("");
        for (int i=0;i<this.message.length();i++) {
            //if (Objects.equals(this.message.charAt(i), ' ') || !Encryptor.isALetter(message.charAt(i))) {
            //    continue;
            // }
            char character = this.message.charAt(i);
            strings[i] = String.valueOf(this.defaultDecCharacter(character));
        }
        return Helper.mergeStrings(strings);
    }

    private char defaultDecCharacter(char character) {
        //this.revaluateStartCode(character);
        return (char) ((int) character  - this.key);  //(char) (this.startCode + (((int) character - this.startCode) - this.key) % 26);
    }


    static private boolean isALetter(char character) {
        return Helper.findIndex(letters, character) >= 0;
    }

    public String shiftEnc() {

        String[] strings = this.message.split("");
        for (int i=0;i<this.message.length();i++) {
            if (Objects.equals(this.message.charAt(i), ' ') || !Character.isAlphabetic(this.message.charAt(i))) {
                continue;
            }
            char character = this.message.charAt(i);
            strings[i] = String.valueOf(this.shiftEncCharacter(character));
        }
        return Helper.mergeStrings(strings);
    }

    private char shiftEncCharacter(char character) {
        this.revaluateStartCode(character);
        return (char) ((char) (this.startCode + (((int) character - this.startCode) + this.key) % 26)); //
    }

    public String shiftDec() {

        String[] strings = this.message.split("");
        for (int i=0;i<this.message.length();i++) {
            if (Objects.equals(this.message.charAt(i), ' ') || !Character.isAlphabetic(this.message.charAt(i))) {
                continue;
            }
            char character = this.message.charAt(i);
            strings[i] = String.valueOf(this.shiftDecCharacter(character));
        }
        return Helper.mergeStrings(strings);
    }

    private char shiftDecCharacter(char character) {
        this.revaluateStartCode(character);
        return (char) ((char) (this.startCode + (((int) character - this.startCode) - this.key + 26) % 26));
    }

    private void revaluateStartCode(char character) {
        if (Character.isUpperCase(character)) {
            this.startCode = (int) 'A';
        } else {
            this.startCode = (int) 'a';
        }
    }

    @Override
    public String toString() {
        return this.encryptedMessage;
    }
}

/*
public class Encryptor {
    static char[] letters =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String message;
    public String encryptedMessage;

    static Encryptor build(String message) {
        Encryptor encryptor = new Encryptor();
        encryptor.message = message;
        encryptor.encryptedMessage = encryptor.encryptMessage(message);

        return encryptor;
    }

    public String encryptMessage(String message) {

        String[] strings = message.split("");
        for (int i=0;i<message.length();i++) {
            if (Objects.equals(message.charAt(i), ' ') || !Encryptor.isALetter(message.charAt(i))) {
                continue;
            }
            char character = message.charAt(i);
            strings[i] = String.valueOf(this.encryptCharacter(character));
        }
        return Helper.mergeStrings(strings);
    }

    private char encryptCharacter(char character) {
        return (char) (97 + 25 - ((int) character - 97));
    }


    static private boolean isALetter(char character) {
        return Helper.findIndex(letters, character) >= 0;
    }

}
*/

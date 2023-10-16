package encryptdecrypt.enums;

import java.util.Objects;

public enum Command {
    ENC("enc"),
    DEC("dec");

    final String value;

    Command(String value) {
        this.value = value;
    }


    public static Command validateInputCommand(String input) throws Exception {
        return stringToCommand(input);
    }

    private boolean equals(Command command) {
        return Objects.equals(this.value, command.value);
    }

    static private boolean isInputACommand(String input) {
        for (Command command: Command.values()) {
            if (Objects.equals(input, command.value)) {
               return true;
            }
        }
        return false;
    }

    static private Command stringToCommand(String string) throws Exception {
        if(Objects.equals(string, ENC.value)) {
            return ENC;
        } else if(Objects.equals(string, DEC.value)) {
            return DEC;
        } else {
            throw new Exception("string is not a command");
        }
    }
}

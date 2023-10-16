package encryptdecrypt.packages.enums;

import java.util.Objects;

public enum Algorithm {
    SHIFT("shift"),
    UNICODE("unicode");

    final String value;
    Algorithm(String value) {
        this.value = value;
    }

    private boolean equals(Algorithm algorithm) {
        return Objects.equals(this.value, algorithm.value);
    }

    static private boolean isInputAlgorithm(String input) {
        for (Algorithm algorithm: Algorithm.values()) {
            if (Objects.equals(input, algorithm.value)) {
                return true;
            }
        }
        return false;
    }

    public static Algorithm stringToCommand(String string) {
        if(Objects.equals(string, SHIFT.value)) {
            return SHIFT;
        } else {
            return UNICODE;
        }
    }

}

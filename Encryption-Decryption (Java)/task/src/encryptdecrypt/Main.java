package encryptdecrypt;

import encryptdecrypt.packages.FileManager;
import encryptdecrypt.packages.enums.Algorithm;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        String command = inputCommand(args);
        String key = inputKey(args);
        String data = inputData(args);
        String out = inputOut(args);
        String alg = inputAlg(args);
        Algorithm algorithm = Algorithm.stringToCommand(alg);
        MessageEncryptor messageEncryptor = MessageEncryptor.startCoding(command, key, data, out, algorithm);

    }


    static String inputCommand(String[] args) {
        String arg1 = args[0];
        String arg2 = args[2];
        String arg3= args[4];


        return checkArgs(args, "-mode");
    }

    static String inputKey(String[] args) {
        String arg1 = args[0];
        String arg2 = args[2];
        String arg3= args[4];

        return checkArgs(args, "-key");
    }


    static String inputData(String[] args) {
        String arg1 = args[0];
        String arg2 = args[2];
        String arg3= args[4];


        String data1 = checkArgs(args, "-data");
        if (data1 != null) {
            return data1;
        }
        String data2 = checkArgs(args, "-in");
        if (data2 != null) {
            String data = FileManager.readData(data2);
            return data;
        }

        return "";
    }

    static String inputOut(String[] args) {
        String arg1 = args[0];
        String arg2 = args[2];
        String arg3= args[4];

        return checkArgs(args, "-out");
    }

    static String inputAlg(String[] args) {
        String arg1 = args[0];
        String arg2 = args[2];
        String arg3= args[4];


        return checkArgs(args, "-alg");
    }


    static String checkArgs(String[] args, String key) {
        for(int i = 0; i < args.length; i = i + 1) {
            if (i % 2 == 0) {
                if (Objects.equals(args[i], key)) {
                    return args[i + 1];
                }
            }
        }
        return null;
    }
}

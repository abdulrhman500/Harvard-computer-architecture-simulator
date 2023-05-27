package harvard.utils;

public class BaseConversion {
    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static String ByteToBinary(byte number) {
        if (number > 127 || number < -128) throw new RuntimeException("Number in not byte");
        int[] bits = new int[8];
        int i = 0;
        while (number != 0) {

            int tmp = number & (1);
            i++;
            if (tmp == 1) bits[8 - i] = 1;
            number >>= 1;
        }
        StringBuilder x = new StringBuilder();
        for (int j = 0; j < bits.length; j++) {
            x.append(bits[j] + "");
        }

        return x.toString();
    }


}

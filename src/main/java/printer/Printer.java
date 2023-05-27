package printer;

import harvard.constants.Constants;

public class Printer {

	public static String printInstruction(short instruction) {
		return instruction + ", in binary : "
				+ extendBinaryNumber(Integer.toBinaryString(instruction), Constants.INSTRUCTION_SIZE);
	}

	public static String extendBinaryNumber(String binary, int length) {
		while (binary.length() < Constants.INTEGER_SIZE) {
			binary = '0' + binary;
		}
		return binary.substring(Constants.INTEGER_SIZE - length);
	}

}

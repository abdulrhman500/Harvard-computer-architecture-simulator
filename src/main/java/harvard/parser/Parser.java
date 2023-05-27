package harvard.parser;

import harvard.constants.Constants;
import harvard.exception.AssemblySyntaxError;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.InstructionMemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import static harvard.constants.Constants.*;

public class Parser {
	String path;
	Scanner sc;
	Vector<String> instructions;

	public Parser(String path) {
		this.path = path;
	}

	private void setupReader() {
		File file = new File(path);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Program File not found at location : " + path);
			throw new RuntimeException(e);
		}
		instructions = new Vector<>();
	}

	private void close() {
		if (sc != null)
			sc.close();

	}

	private void read() {
		if (sc == null || instructions == null)
			setupReader();
		while (sc.hasNext()) {
			String currLine = sc.nextLine();
			currLine = currLine.trim();
			if ((!currLine.isBlank()) && (!currLine.isEmpty()) && currLine.charAt(0) != ASSEMBLY_COMMENT_CHAR)
				instructions.add(currLine);
		}

	}

	public void parse() throws AssemblySyntaxError, IncorrectMemoryAddressException {
		setupReader();
		read();
		cleanInput();

		for (String curr : instructions) {
			if (!isValid(curr))
				throw new AssemblySyntaxError(ASSEMBLY_SYNTAX_ERROR + curr);
			String[] parts = curr.split(" ");

			decode(parts);

		}

		close();
	}

	private void decode(String[] parts) throws IncorrectMemoryAddressException {

		int opCode = getOpCode(parts[0]);
		int secondInput = getR1Number(parts[1]);
		int thirdInput = getThirdInput(parts[2], (byte) opCode);
//		System.out.println("OP: " + opCode);
//		System.out.println("R1 " + secondInput);
//		System.out.println("R2 or imm : " + thirdInput);
//		System.out.println("---------------------------------");
		boolean rtype = Arrays.binarySearch(Constants.R_TYPE_INSTRUCTIONS, opCode) >= 0;
		if (opCode < 0 || secondInput < 0 || (thirdInput < 0 && rtype))
			try {
				throw new AssemblySyntaxError(NEGATIVE_NUMBER_ERROR);
			} catch (AssemblySyntaxError e) {
				throw new RuntimeException(e);
			}

		int binaryInstruction = thirdInput & Constants.SIX_ONES_MASK;
		binaryInstruction |= (secondInput & Constants.SIX_ONES_MASK) << 6;
		binaryInstruction |= (opCode & Constants.FOUR_ONES_MASK) << 12;

		InstructionMemory.getInstance().addInstruction((short) binaryInstruction);

	}

	private byte getThirdInput(String part, byte opCode) {
		if (Arrays.binarySearch(Constants.I_TYPE_INSTRUCTIONS, opCode) >= 0) {
			try {
				return Byte.parseByte(part);
			} catch (NumberFormatException e) {
				throw new NumberFormatException(ASSEMBLY_SYNTAX_ERROR_AT_THIRD_INPUT + part);
			}
		}
//        System.out.println("R type");
		return getR1Number(part);
	}

	private byte getR1Number(String part) {

		try {
			String strNum = part.substring(1);
//            if (strNum.toLowerCase().charAt(0) != 'r')
//                throw new AssemblySyntaxError(ASSEMBLY_SYNTAX_ERROR + part);
			return Byte.parseByte(strNum);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ASSEMBLY_SYNTAX_ERROR_AT_SECOND_INPUT + part);
		}
//        catch (AssemblySyntaxError e) {
//            throw new RuntimeException(e);
//        }

	}

	private byte getOpCode(String part) {

		switch (part.toUpperCase()) {
		case "ADD":
			return Constants.ADD_OPCODE;
		case "SUB":
			return Constants.SUB_OPCODE;
		case "MUL":
			return Constants.MUL_OPCODE;
		case "LDI":
			return Constants.LDI_OPCODE;
		case "BEQZ":
			return Constants.BEQZ_OPCODE;
		case "AND":
			return Constants.AND_OPCODE;
		case "OR":
			return Constants.OR_OPCODE;
		case "JR":
			return Constants.JR_OPCODE;
		case "SLC":
			return Constants.SLC_OPCODE;
		case "SRC":
			return Constants.SRC_OPCODE;
		case "LB":
			return Constants.LB_OPCODE;
		case "SB":
			return Constants.SB_OPCODE;
		}
		try {
			throw new AssemblySyntaxError(OPCODE_ERROR + part);
		} catch (AssemblySyntaxError e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isValid(String curr) {
		return curr.split(" ").length == 3;

	}

	private void cleanInput() {
		if (instructions == null)
			return;
		for (int j = 0; j < instructions.size(); j++) {
			String curr = instructions.get(j);
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < curr.length() - 1; i++) {
				if (curr.charAt(i) == ' ' && curr.charAt(i) == curr.charAt(i + 1))
					continue;
				tmp.append(curr.charAt(i));
			}
			tmp.append(curr.charAt(curr.length() - 1));
			instructions.set(j, tmp.toString().trim());
		}

	}

	public void setPath(String path) {
		this.path = path;
	}
//    public static void main(String a[]) throws AssemblySyntaxError {
//        Parser x = new Parser(PROGRAM_PATH);
//        x.parse();
//
//        for (int i = 0; i < 12; i++) {
//
//            short pc = RegisterFile.getInstance().getPC();
//            Short curInstruction = InstructionMemory.getInstance().getInstruction(pc);
//            RegisterFile.getInstance().setPC((short) (pc + 1));
//            System.out.println(BaseConversion.toBinary(curInstruction));
//        }
//}
}

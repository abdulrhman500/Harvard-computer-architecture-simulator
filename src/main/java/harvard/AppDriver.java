package harvard;

import app.App;
import harvard.constants.Constants;
import harvard.exception.AssemblySyntaxError;
import harvard.harvardComputerExceptions.HarvardComputerArchException;

import harvard.memory.DataMemory;
import harvard.memory.InstructionMemory;
import harvard.memory.RegisterFile;
import harvard.operation.ALU;
import harvard.parser.Parser;
import printer.Printer;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Arrays;

public class AppDriver {
	private int clock;
	private Short FETCH, DECODE, EXECUTE;
	private boolean isBranch = false;

	public static String printGUI = new String();

	public void init() {
		clock = 1;
		RegisterFile.getInstance();
		InstructionMemory.getInstance();
		DataMemory.getInstance();
	}

	public void reset() throws HarvardComputerArchException {
		InstructionMemory.getInstance().reset();
		DataMemory.getInstance().reset();
		ALU.getInstance().clear();
		RegisterFile.getInstance().reset();
	}

	public Short fetch() throws HarvardComputerArchException {
		short pc = RegisterFile.getInstance().getPC();
		Short curInstruction = InstructionMemory.getInstance().getInstruction(pc);
		RegisterFile.getInstance().setPC((short) (pc + 1));
		return curInstruction;
	}

	public void decode(Short instruction) {
		byte opCode = getOpCode(instruction);
		byte register1 = getR1(instruction);
		byte register2 = getR2(instruction);

		byte operand1 = RegisterFile.getInstance().getRegister(register1).getData();
		byte operand2 = isRType(opCode) ? RegisterFile.getInstance().getRegister(register2).getData()
				: extend(register2);

		ALU.getInstance().setOpCode(opCode);
		ALU.getInstance().setOperand1(operand1);
		ALU.getInstance().setOperand2(operand2);
		ALU.getInstance().setDestReg(register1);
	}

	public void runNext() throws HarvardComputerArchException {
		if (isBranch) {
			isBranch = false;
			FETCH = null;
			DECODE = null;
			EXECUTE = null;
			ALU.getInstance().clear();
		}

		if (isExecFinished()) {
			return;
		}

		System.out.println("Start of Clock Cycle: " + clock);
		App.output("Start of Clock Cycle: " + clock);
		EXECUTE = DECODE;
		DECODE = FETCH;
		FETCH = fetch();

		if (FETCH != null) {
			System.out.println("current Fetched Instruction: " + Printer.printInstruction(FETCH));
			App.output("current Fetched Instruction: " + Printer.printInstruction(FETCH));
		} else {
			System.out.println("No Fetch Instruction");
			App.output("No Fetch Instruction");
		}

		if (DECODE != null) {
			System.out.println("current Decoded Instruction: " + Printer.printInstruction(DECODE));
			App.output("current Decoded Instruction: " + Printer.printInstruction(DECODE));
		} else {
			System.out.println("No Decode Instruction");
			App.output("No Decode Instruction");
		}

		if (EXECUTE != null) {
			System.out.println("current Executed Instruction: " + Printer.printInstruction(EXECUTE));
			App.output("current Executed Instruction: " + Printer.printInstruction(EXECUTE));
			ALU.getInstance().execute();
			isBranch |= ALU.getInstance().checkForBranch();
		} else {
			System.out.println("No Execute Instruction");
			App.output("No Execute Instruction");
		}

		if (DECODE != null) {
			decode(DECODE);
		}

		System.out.println("End of Clock Cycle: " + clock);
		System.out.println();
		App.output("End of Clock Cycle: " + clock);
		App.output("\n");
		clock++;

	}

	private byte getRangeFromBinaryNumber(int binNum, int i, int j) {
		int mask = ((1 << j) - 1) & ~((1 << i) - 1);
		return (byte) ((binNum & mask) >> i);
	}

	private byte getOpCode(short curInstruction) {
		return getRangeFromBinaryNumber(curInstruction, 12, 16);
	}

	private byte getR1(short curInstruction) {
		return getRangeFromBinaryNumber(curInstruction, 6, 12);
	}

	private byte getR2(short curInstruction) {
		return getRangeFromBinaryNumber(curInstruction, 0, 6);
	}

	private boolean isRType(Byte opcode) {
		return Arrays.binarySearch(Constants.R_TYPE_INSTRUCTIONS, opcode) >= 0;
	}

	private byte extend(byte operand) {
		if ((operand & (1 << Constants.BIT6)) != 0) {
			operand = (byte) ((-1 << Constants.BIT6) | operand);
		}
		return operand;
	}

	private boolean isExecFinished() {
		return FETCH == null && DECODE == null && EXECUTE == null
				&& RegisterFile.getInstance().getPC() >= InstructionMemory.getInstance().getCurrentSize();
	}

	public void run(String path) throws AssemblySyntaxError, HarvardComputerArchException {
		Parser parser = new Parser(path);
		parser.parse(); // this mean that instructions are read from file and loaded to instruction
		// memory as binary
		System.out.println();
		App.output("\n");
		// next is to apply dataPath
		do {
			runNext();
		} while (!isExecFinished());

		System.out.println("FINISHED EXECUTION\n");
		System.out.println(RegisterFile.getInstance().toString());
		App.output("FINISHED EXECUTION\n");
		App.output(RegisterFile.getInstance().toString());
		System.out.println(DataMemory.getInstance().toString());
		App.output(DataMemory.getInstance().toString());
		System.out.println(InstructionMemory.getInstance().toString());
		App.output(InstructionMemory.getInstance().toString());
		reset();
	}
	// TODO : handle BEQZ instruction


}
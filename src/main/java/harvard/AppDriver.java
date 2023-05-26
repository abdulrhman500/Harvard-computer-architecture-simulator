package harvard;

import java.util.Arrays;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.InstructionMemory;
import harvard.memory.RegisterFile;
import harvard.operation.ALU;
import harvard.storage.ProgramCounter;

public class AppDriver {
	private int clock;
	private Short FETCH, DECODE, EXECUTE;
	private boolean isBranch = false;

	private void init() {
		clock = 1;
//		SREG.getInstance().setData((byte) 0);
	}

	public short fetch() {
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
		EXECUTE = DECODE;
		DECODE = FETCH;
		FETCH = fetch();

		if (FETCH == null && DECODE == null && EXECUTE == null) {
			System.out.println("FINISHED EXECUTION");
			// TODO: print all and reset
			return;
		}

		System.out.println("Start of Clock Cycle " + (clock));
		System.out.println("Program Counter: " + (ProgramCounter.getInstance().getData() - 1));

		if (FETCH != null) {
			System.out.println("current Fetched Instruction: " + FETCH);
		} else {
			System.out.println("No Fetch Instruction");
		}

		if (DECODE != null) {
			System.out.println("current Decoded Instruction: " + DECODE);
			decode(DECODE);
		} else {
			System.out.println("No Decode Instruction");
		}

		if (EXECUTE != null) {
			System.out.println("current Executed Instruction: " + EXECUTE);
			ALU.getInstance().execute();
			isBranch |= ALU.getInstance().checkForBranch();
		} else {
			System.out.println("No Execute Instruction");
		}

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

	public void run(String path) {
		this.init();
		// parser
		// load to memory
		// for (int inst : program )
		// fetch(this);
		// decode()
		// execute()
		// print(CLOCK)
		// increment

	}

	public static void main(String args[]) {
//		AppDriver app = new AppDriver();
	}
}
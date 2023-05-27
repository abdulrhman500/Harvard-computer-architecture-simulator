package harvard.operation;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.instruction.*;

public class ALU {

	private Byte opCode, operand1, operand2, destReg;

	private static ALU instance = null;

	public static ALU getInstance() {
		if (instance == null)
			instance = new ALU();
		return instance;
	}

	public void setOpCode(byte opCode) {
		this.opCode = opCode;
	}

	public void setOperand1(Byte operand1) {
		this.operand1 = operand1;
	}

	public void setOperand2(byte operand2) {
		this.operand2 = operand2;
	}

	public void setDestReg(byte destReg) {
		this.destReg = destReg;
	}

	public void execute() throws HarvardComputerArchException {
		Instruction instruction = getInstruction();
		instruction.doOperation();
	}

	private Instruction getInstruction() {
		switch (opCode) {
			case Constants.ADD_OPCODE:
				return new ADD(operand1, operand2, destReg);
			case Constants.SUB_OPCODE:
				return new SUB(operand1, operand2, destReg);
			case Constants.MUL_OPCODE:
				return new MUL(operand1, operand2, destReg);
			case Constants.LDI_OPCODE:
				return new LDI(operand1, operand2, destReg);
			case Constants.BEQZ_OPCODE:
				return new BEQZ(operand1, operand2, destReg);
			case Constants.AND_OPCODE:
				return new AND(operand1, operand2, destReg);
			case Constants.OR_OPCODE:
				return new OR(operand1, operand2, destReg);
			case Constants.JR_OPCODE:
				return new JR(operand1, operand2, destReg);
			case Constants.SLC_OPCODE:
				return new SLC(operand1, operand2, destReg);
			case Constants.SRC_OPCODE:
				return new SRC(operand1, operand2, destReg);
			case Constants.LB_OPCODE:
				return new LB(operand1, operand2, destReg);
			case Constants.SB_OPCODE:
				return new SB(operand1, operand2, destReg);
			default:
				throw new IllegalStateException("Unexpected value: " + opCode);
		}
	}

	public boolean checkForBranch() {
		return opCode == Constants.JR_OPCODE || opCode == Constants.BEQZ_OPCODE && operand1 == 0;
	}

	public void clear() {
		opCode = null;
		operand1 = null;
		operand2 = null;
		destReg = null;
	}
}

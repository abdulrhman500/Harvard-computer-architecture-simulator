package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public abstract class RInstruction implements Instruction {
	private byte op1, op2, destReg;

	RInstruction(byte op1, byte op2, byte destReg) {
		this.op1 = op1;
		this.op2 = op2;
		this.destReg = destReg;
	}

	public abstract void doOperation() throws HarvardComputerArchException;

	public abstract void updateFlags(int result) throws HarvardComputerArchException;

	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}

	public byte getDestReg() {
		return destReg;
	}

	public void setDestReg(byte destReg) {
		this.destReg = destReg;
	}

}
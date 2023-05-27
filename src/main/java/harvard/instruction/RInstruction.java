package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public abstract class RInstruction implements Instruction {
	private Byte op1, op2, destReg;

	RInstruction(Byte op1, Byte op2, Byte destReg) {
		this.op1 = op1;
		this.op2 = op2;
		this.destReg = destReg;
	}

	public abstract void doOperation() throws HarvardComputerArchException;

	public abstract void updateFlags(int result) throws HarvardComputerArchException;

	public Byte getOp1() {
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
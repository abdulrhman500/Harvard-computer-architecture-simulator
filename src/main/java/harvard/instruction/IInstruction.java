package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public abstract class IInstruction implements Instruction {
	byte op1, immediate, destReg;

	public IInstruction(byte op1, byte immediate, byte destReg) {
		this.op1 = op1;
		this.immediate = immediate;
		this.destReg = destReg;
	}

	public abstract void doOperation();

	public abstract void updateFlags(int result) throws HarvardComputerArchException;

	public byte getDestReg() {
		return destReg;
	}

	public int getOp1() {
		return op1;
	}

	public byte getImmediate() {
		return immediate;
	}

}
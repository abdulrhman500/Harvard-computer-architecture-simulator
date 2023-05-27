package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;

public abstract class IInstruction implements Instruction {
	Byte op1, immediate, destReg;

	public IInstruction(Byte op1, Byte immediate, Byte destReg) {
		this.op1 = op1;
		this.immediate = immediate;
		this.destReg = destReg;
	}

	public abstract void doOperation() throws IncorrectMemoryAddressException;

	public abstract void updateFlags(int result) throws HarvardComputerArchException;

	public Byte getDestReg() {
		return destReg;
	}

	public int getOp1() {
		return op1;
	}

	public Byte getImmediate() {
		return immediate;
	}

}
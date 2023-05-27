package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.memory.RegisterFile;

public class LB extends IInstruction {

	public LB(byte register1, byte immediate, byte destReg) {
		super(register1, immediate, destReg);
	}

	@Override
	public void doOperation() throws IncorrectMemoryAddressException {
		byte data = (DataMemory.getInstance().readAddress(getImmediate()));
		RegisterFile.getInstance().setRegister(getDestReg(), data);
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.LB, result, (byte) getOp1(), null);
	}
}

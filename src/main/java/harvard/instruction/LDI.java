package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;

public class LDI extends IInstruction {

	public LDI(Byte register1, Byte immediate, Byte destReg) {
		super(register1, immediate, destReg);
	}

	@Override
	public void doOperation() {
		RegisterFile.getInstance().setRegister(getDestReg(), getImmediate());
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.LDI, result, (byte) getOp1(), null);
	}

}

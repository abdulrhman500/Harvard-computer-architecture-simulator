package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;

public class SLC extends IInstruction {

	public SLC(Byte register1, Byte immediate, Byte destReg) {
		super(register1, immediate, destReg);
	}

	@Override
	public void doOperation() {
		Byte result = (byte) ((getOp1() << immediate) | (getOp1() >>> (8 - immediate)));
		RegisterFile.getInstance().setRegister(getDestReg(), result);
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.SLC, result, (byte) getOp1(), null);
	}

}

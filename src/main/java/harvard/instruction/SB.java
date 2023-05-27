package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.memory.RegisterFile;

public class SB extends IInstruction {

	public SB(Byte register1, Byte immediate, Byte destReg) {
		super(register1, immediate, destReg);
	}

	@Override
	public void doOperation() {
		try {
			DataMemory.getInstance().writeAddress(immediate, (byte) getOp1());
		} catch (IncorrectMemoryAddressException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.SB, result, (byte) getOp1(), null);
	}

}

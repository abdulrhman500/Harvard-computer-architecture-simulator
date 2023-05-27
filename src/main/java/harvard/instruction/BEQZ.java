package harvard.instruction;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;

public class BEQZ extends IInstruction {

	public BEQZ(Byte op1, Byte immediate, Byte destReg) {
		super(op1, immediate, destReg);
	}

	@Override
	public void doOperation() {
		if (getOp1() == 0) {
			RegisterFile.getInstance()
					.setPC((short) (RegisterFile.getInstance().getPC() + Constants.OFFSET + immediate));
		}
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.BEQZ, result, (byte) getOp1(), null);
	}

}

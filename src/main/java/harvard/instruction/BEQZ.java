package harvard.instruction;

import app.App;
import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;

public class BEQZ extends IInstruction {

	public BEQZ(Byte op1, Byte immediate, Byte destReg) {
		super(op1, immediate, destReg);
	}

	@Override
	public void doOperation() throws HarvardComputerArchException {
		if (getOp1() == 0) {
			System.out.println("Branch to Instruction at address : "
					+ (RegisterFile.getInstance().getPC() + Constants.OFFSET + immediate));
			App.output("Branch to Instruction at address : "
					+ (RegisterFile.getInstance().getPC() + Constants.OFFSET + immediate));
			RegisterFile.getInstance()
					.setPC((short) (RegisterFile.getInstance().getPC() + Constants.OFFSET + immediate));
		}
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.BEQZ, result, (byte) getOp1(), null);
	}

}

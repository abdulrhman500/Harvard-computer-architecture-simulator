package harvard.instruction;

import harvard.memory.RegisterFile;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public class ADD extends RInstruction {

	public ADD(byte op1, byte op2, byte destReg) {
		super(op1, op2, destReg);
	}

	@Override
	public void doOperation() throws HarvardComputerArchException {
		int tmpResult = getOp1() + getOp2();
		byte result = (byte) (tmpResult & EIGHT_ONES_MASK);
		RegisterFile.getInstance().setRegister(getDestReg(), result);
		updateFlags(tmpResult);
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.ADD, result, (byte) getOp1(), (byte) getOp2());
	}

}

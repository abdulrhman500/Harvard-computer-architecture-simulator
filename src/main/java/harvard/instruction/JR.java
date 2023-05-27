package harvard.instruction;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;
import printer.Printer;

public class JR extends RInstruction {

	public JR(Byte op1, Byte op2, Byte destReg) {
		super(op1, op2, destReg);
	}

	@Override
	public void doOperation() throws HarvardComputerArchException {
		String op1 = Printer.extendBinaryNumber(Integer.toBinaryString(getOp1()), Constants.REGISTER_SIZE);
		String op2 = Printer.extendBinaryNumber(Integer.toBinaryString(getOp2()), Constants.REGISTER_SIZE);
		int newAddress = Integer.parseInt(op1 + op2, 2);
		System.out.println("Jump to instruction at address : " + newAddress);
		RegisterFile.getInstance().setPC((short) newAddress);
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.JR, result, (byte) getOp1(), (byte) getOp2());
	}
}

package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.memory.RegisterFile;

public class JR extends RInstruction {

	public JR(Byte op1, Byte op2, Byte destReg) {
		super(op1, op2, destReg);
	}

	@Override
	public void doOperation() {
		String op1 = adjust(Integer.toBinaryString(getOp1()));
		String op2 = adjust(Integer.toBinaryString(getOp2()));
		short newAddress = Short.valueOf(op1 + op2, 2);
		RegisterFile.getInstance().setPC(newAddress);
	}

	private String adjust(String s) {
		if (s.length() > 8)
			return s.substring(24);
		while (s.length() < 8) {
			s = '0' + s;
		}
		return s;
	}

	@Override
	public void updateFlags(int result) throws HarvardComputerArchException {
		RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.JR, result, (byte) getOp1(), (byte) getOp2());
	}
}

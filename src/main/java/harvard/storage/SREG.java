package harvard.storage;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.instruction.EInstuctions;

public class SREG extends Register {

	private static SREG instance = null;

	public SREG() {
		super();
	}

	public SREG(Byte data) {
		super(data);
	}

	public static SREG getInstance() {
		if (instance == null)
			instance = new SREG();
		return instance;
	}

	public void setZBit(boolean setter) {
		setBit((byte) 0, setter);
	}

	public void setSBit(boolean setter) {
		setBit((byte) 1, setter);
	}

	public void setNBit(boolean setter) {
		setBit((byte) 2, setter);
	}

	public void setVBit(boolean setter) {
		setBit((byte) 3, setter);
	}

	public void setCBit(boolean setter) {
		setBit((byte) 4, setter);
	}

	private void setBit(Byte bitNum, boolean setter) {
		Byte data = getData();
		data = (byte) (data | (((byte) 1) << bitNum));
		if (!setter) {
			data = (byte) (data ^ (((byte) 1) << bitNum));
		}
		setData(data);
	}

	public void updateFlags(EInstuctions Einstruction, int result, Byte register1, Byte register2)
			throws HarvardComputerArchException {

		switch (Einstruction) {
		case ADD:
			boolean carry = ((result >> 8) & 1) == 1;
			SREG.getInstance().setCBit(carry);
			// TODO: set V & N & S & Z
			break;

		case SUB:
			// TODO: set V & N & S & Z
			break;

		case MUL:
			// TODO: N & Z
			break;
//            case AND,OR,SLC,SRC:
		// TODO: N & Z
//                break;

		default:
			throw new HarvardComputerArchException("wrong instr");

		}
		// TODO: implement

		boolean overflow = false;
		boolean negative = result < 0;
		boolean zero = result == 0;
		int resultSign = (result >> 7) & 1;
		int register1Sign = (register1 >> 7) & 1;
		int register2Sign = (register2 >> 7) & 1;
		if ((register1Sign == register2Sign) && resultSign != register1Sign)
			overflow = true;
		boolean sign = negative ^ overflow;

		SREG.getInstance().setNBit(negative);

		SREG.getInstance().setVBit(overflow);
		SREG.getInstance().setZBit(zero);
		SREG.getInstance().setSBit(sign);
	}

}

package harvard.storage;

import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.instruction.EInstuctions;

public class SREG extends Register {

	private static SREG instance = null;

	public SREG() {
		super();
		setData((byte) 0);
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
			setCBit((result & (1 << 8)) > 0);
			// TODO: check about the zero
			setVBit((register1 >= 0 && register2 >= 0 && (byte) result < 0)
					|| (register1 < 0 && register2 < 0 && (byte) result >= 0));
			setNBit((byte) result < 0);
			setSBit(((getData() >> 2 & 1) > 0) ^ ((getData() >> 3 & 1) > 0));
			setZBit(result == 0);
			break;
		case SUB:
			setVBit((register1 >= 0 && register2 >= 0 && (byte) result < 0)
					|| (register1 < 0 && register2 < 0 && (byte) result >= 0));
			setNBit((byte) result < 0);
			setSBit(((getData() >> 2 & 1) > 0) ^ ((getData() >> 3 & 1) > 0));
			setZBit(result == 0);
			break;
		case MUL:
			// TODO: N & Z
			setNBit((byte) result < 0);
			setZBit(result == 0);
			break;
		case AND, OR, SLC, SRC:
			// TODO: N & Z
			setNBit((byte) result < 0);
			setZBit(result == 0);
			break;

		default:
			throw new HarvardComputerArchException("wrong instr");

		}

		System.out.println(SREG.getInstance().toString());
	}

	@Override
	public String toString() {
		return "SREG: " + super.toString();
	}
	@Override
	public String toString() {
		return "SREG "+ super.toString();
	}

}

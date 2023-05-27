package harvard.storage;

import harvard.constants.Constants;
import harvard.utils.BaseConversion;
import printer.Printer;

public class Register {
	private byte data;

	public Register(byte data) {
		this.data = data;
	}

	public Register() {
	}

	public byte getData() {
		return data;
	}

	public void setData(byte data) {
		this.data = data;
	}

	public String toBinary() {
		return BaseConversion.toBinary(data);
	}

	@Override
	public String toString() {
		return "Data in decimal = " + data + " Data in binary = "
				+ Printer.extendBinaryNumber(toBinary(), Constants.REGISTER_SIZE);
	}
}

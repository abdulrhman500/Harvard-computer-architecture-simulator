package harvard.memory;

import app.App;
import harvard.constants.Constants;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class RegisterFile {
	private Register[] registers;

	private static RegisterFile registerFile;

	private RegisterFile() {
		registers = new Register[Constants.REGISTER_FILE_SIZE];
		for (int i = 0; i < Constants.REGISTER_FILE_SIZE; i++) {
			registers[i] = new Register();
		}
	}

	public Register getRegister(int index) {
		return registers[index];
	}

	public void setRegister(byte index, byte data) {
		System.out.println("Set register R" + index + " : " + data);
		App.output("Set register R" + index + " : " + data);
		registers[index].setData(data);
	}

	public short getPC() {
		return (short) (ProgramCounter.getInstance().getData());
	}

	public void setPC(short data) throws HarvardComputerArchException {
		if (data < 0) {
			throw new HarvardComputerArchException(Constants.SET_PC_NEG_VAL);
		}
		ProgramCounter.getInstance().setData(data);
		System.out.print("Set PC : " + ProgramCounter.getInstance().getData() + "\n");
		App.output("Set PC : " + ProgramCounter.getInstance().getData() + "\n");
	}

	public SREG getSREG() {
		return SREG.getInstance();
	}

	public static RegisterFile getInstance() {
		if (registerFile == null)
			registerFile = new RegisterFile();
		return registerFile;
	}

	public void reset() throws HarvardComputerArchException {
		registerFile = new RegisterFile();
		registerFile.setPC((short) 0);
		registerFile.getSREG().setSREG((short) 0);
	}

	@Override
	public String toString() {
		String print = "-- Register File --\n";
		print += ProgramCounter.getInstance().toString() + "\n";
		print += SREG.getInstance().toString() + "\n";
		for (int i = 0; i < registers.length; i++) {
			print += "Register R" + i + " " + registers[i].toString() + '\n';
		}
		print += "-- Register File End --\n";
		return print;
	}
}

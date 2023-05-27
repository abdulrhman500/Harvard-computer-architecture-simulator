package harvard.memory;

import harvard.constants.Constants;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class RegisterFile {
	private Register[] registers;

	private static final RegisterFile registerFile = new RegisterFile();

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
		registers[index].setData(data);
	}

	public short getPC() {
		return ProgramCounter.getInstance().getData();
	}

	public void setPC(short data) {
		ProgramCounter.getInstance().setData(data);
	}

	public SREG getSREG() {
		return SREG.getInstance();
	}

	public static RegisterFile getInstance() {
		return registerFile;
	}

	@Override
	public String toString() {
		String print = new String();
		print+="-- Register File --\n";
		print+=ProgramCounter.getInstance().toString();
		print+=SREG.getInstance().toString();
		for (int i=0;i<registers.length;i++){
			print+="Reg No"+i+" "+registers[i].toString();
		}
		print+="-- Register File End -- ";
		return print;
	}
}

package harvard.memory;

import harvard.constants.Constants;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

import java.util.Arrays;

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
		System.out.println(" inside set regFile "+index+" "+data);
		registers[index].setData(data);
//		System.out.println(Arrays.toString(registers));
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
		if(registerFile == null)
			registerFile = new RegisterFile();
		return registerFile;
	}


	@Override
	public String toString() {
		Register[] generalPurposeRegisters = getInstance().registers;
		String print = "-- Register File --\n";
		for(int i =0;i<generalPurposeRegisters.length;i++){
			print+= "Register No "+ i +" "+ generalPurposeRegisters[i].toString()+'\n';
		}
		print+= ProgramCounter.getInstance().toString()+"\n";
		print+= SREG.getInstance().toString()+"\n";
		return print;

	}
}

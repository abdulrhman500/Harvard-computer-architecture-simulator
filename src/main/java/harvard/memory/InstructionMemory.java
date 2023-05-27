package harvard.memory;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;

public class InstructionMemory {

	private Short[] instructionMemory;
	private short currentSize;
	private short pointer;
	private static InstructionMemory instance = null;

	private InstructionMemory() {
		instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		currentSize = 0;
		pointer = 0;
	}

	public static InstructionMemory getInstance() {
		if (instance == null)
			instance = new InstructionMemory();
		return instance;
	}

	public int nextIntruction(){
		if (pointer != currentSize)
			return pointer++;
			return -1;
	}

	public void addInstruction(short instruction) throws IncorrectMemoryAddressException {
		if(currentSize<0 || currentSize>=getInstance().instructionMemory.length) throw new IncorrectMemoryAddressException();
		instructionMemory[currentSize++] = instruction;
	}

	@Override
	public String toString() {
		String print = new String("-- Instruction memory --\n");
		int idx = 0;
		for (;idx!=currentSize;idx++) {

			print += comBits(Integer.toBinaryString(instructionMemory[idx])).substring(16)+"\n";
		}
		print +='\n';
		return print;
	}
	String comBits(String m){
		while (m.length()<32){
			m = "0"+m;
		}
		return m;
	}

	public void reset() {
		this.instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		this.currentSize = 0;
	}

	public Short getInstruction(int pc) throws IncorrectMemoryAddressException {
		if(pc<0 || pc>=instructionMemory.length) throw new IncorrectMemoryAddressException();
		return instructionMemory[pc];
	}

	public short getCurrentSize() {
		return currentSize;
	}

}

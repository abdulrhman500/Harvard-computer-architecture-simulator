package harvard.memory;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;

public class InstructionMemory {

	private Short[] instructionMemory;
	private short currentSize;
	private static InstructionMemory instance = null;

	private InstructionMemory() {
		instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		currentSize = 0;
	}

	public static InstructionMemory getInstance() {
		if (instance == null)
			instance = new InstructionMemory();
		return instance;
	}

	public void addInstruction(short instruction) throws IncorrectMemoryAddressException {
		if(currentSize<0 || currentSize>=getInstance().instructionMemory.length) throw new IncorrectMemoryAddressException();
		instructionMemory[currentSize++] = instruction;
	}

	@Override
	public String toString() {
		String print = new String();
		for (short inst : instructionMemory) {
			// TODO: waiting for the full implemntaion of intruction
		}
		return print;
	}

	public void reset() {
		this.instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		this.currentSize = 0;
	}

	public short getInstruction(int pc) throws IncorrectMemoryAddressException {
		if(pc<0 || pc>=instructionMemory.length) throw new IncorrectMemoryAddressException();
		return instructionMemory[pc];
	}

	public short getCurrentSize() {
		return currentSize;
	}

}

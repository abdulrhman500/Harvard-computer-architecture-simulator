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
		if(currentSize>=instructionMemory.length) throw new IncorrectMemoryAddressException("Memory is Full");
		System.out.println("Instruction Memory| Accessing Address "+currentSize+" to write "+instruction);
		instructionMemory[currentSize++] = instruction;

	}

	@Override
	public String toString() {
		String print = new String();
		print += "-- Instruction Memory --\n";
		for (int memLoc =0;memLoc<instructionMemory.length;memLoc++) {
			print += "Memory Location "+memLoc+" data in decimal="+instructionMemory[memLoc]+" in binary="+Integer.toBinaryString(0xFFFF & instructionMemory[memLoc])+"\n";
		}
		print+= "-- Instruction Memory End --";
		return print;
	}

	public void reset() {
		this.instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		this.currentSize = 0;
	}

	public short getInstruction(int pc) throws IncorrectMemoryAddressException {
		if(pc<0 || pc>=instructionMemory.length) throw new IncorrectMemoryAddressException();
		System.out.println("Instruction Memory| Accessing Address "+currentSize+" to read "+instructionMemory[pc]);
		return instructionMemory[pc];
	}

	public short getCurrentSize() {
		return currentSize;
	}

}

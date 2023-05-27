package harvard.memory;

import printer.*;
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
		if(currentSize>=instructionMemory.length) 
      throw new IncorrectMemoryAddressException("Memory is Full");
		System.out.println("Instruction Memory| Accessing Address "+currentSize+" to write "+instruction);
		instructionMemory[currentSize++] = instruction;

	}

	@Override
	public String toString() {
		String print = new String("-- Instruction memory --\n");
		int idx = 0;
		for (; idx != instructionMemory.length; idx++) {

			print += "Memory Location "+idx+ ": " + (instructionMemory[idx] == null ? null
					: Printer.extendBinaryNumber(Integer.toBinaryString(instructionMemory[idx]),
							Constants.INSTRUCTION_SIZE))
					+ "\n";
		}
		print += '\n';
		return print;
	}

	public void reset() {
		this.instructionMemory = new Short[Constants.INSTRUCTION_MEMORY_SIZE];
		this.currentSize = 0;
	}


	public short getInstruction(int pc) throws IncorrectMemoryAddressException {
		if(pc<0 || pc>=instructionMemory.length) throw new IncorrectMemoryAddressException();
		System.out.println("Instruction Memory| Accessing Address "+pc+" to read "+instructionMemory[pc]);

		return instructionMemory[pc];
	}

	public short getCurrentSize() {
		return currentSize;
	}

}

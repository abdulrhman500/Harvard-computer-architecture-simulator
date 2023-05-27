package harvard.memory;

import app.App;
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
		if (currentSize >= instructionMemory.length)
			throw new IncorrectMemoryAddressException("Memory is Full");
		System.out.println("Instruction Memory| Accessing Address " + currentSize + " to write " + instruction);
		App.output("Instruction Memory| Accessing Address " + currentSize + " to write " + instruction);
		instructionMemory[currentSize++] = instruction;

	}

	public void reset() {
		instance = new InstructionMemory();
	}

	public Short getInstruction(int pc) throws IncorrectMemoryAddressException {
		if (pc < 0 || pc >= instructionMemory.length)
			throw new IncorrectMemoryAddressException();
		if (instructionMemory[pc] != null){
			System.out.println("Instruction Memory| Accessing Address " + pc + " to read instruction :: in decimal : "
					+ instructionMemory[pc] + ", in binary : " + Printer.extendBinaryNumber(
					Integer.toBinaryString(instructionMemory[pc]), Constants.INSTRUCTION_SIZE));
		App.output("Instruction Memory| Accessing Address " + pc + " to read instruction :: in decimal : "
				+ instructionMemory[pc] + ", in binary : " + Printer.extendBinaryNumber(
				Integer.toBinaryString(instructionMemory[pc]), Constants.INSTRUCTION_SIZE));
	}

		return instructionMemory[pc];
	}

	public short getCurrentSize() {
		return currentSize;
	}

	@Override
	public String toString() {
		String print = new String("-- Instruction memory --\n");
		int idx = 0;
		for (; idx != instructionMemory.length; idx++) {

			print += "Memory Location " + idx + ": "
					+ (instructionMemory[idx] == null ? null
					: Printer.extendBinaryNumber(Integer.toBinaryString(instructionMemory[idx]),
					Constants.INSTRUCTION_SIZE))
					+ "\n";
		}
		print += "-- Data Memory End --\n";
		return print;
	}

}

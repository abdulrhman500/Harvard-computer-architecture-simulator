package harvard.memory;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.storage.Register;
import printer.Printer;

import static harvard.constants.Constants.*;

public class DataMemory {
	Byte[] memory;
	private static DataMemory instance = null;

	private DataMemory() {
		memory = new Byte[DATA_MEMORY_SIZE];
	}

	public static DataMemory getInstance() {
		if (instance == null)
			instance = new DataMemory();
		return instance;
	}

	public Byte readAddress(int address) throws IncorrectMemoryAddressException {
		if (address > DATA_MEMORY_SIZE - 1 || address < 0)
			throw new IncorrectMemoryAddressException();
		System.out.println("Data Memory| Accessing Address " + address + " to read " + memory[address]);
		return memory[address];
	}

	public void writeAddress(int address, Byte data) throws IncorrectMemoryAddressException {
		if (address > DATA_MEMORY_SIZE - 1 || address < 0)
			throw new IncorrectMemoryAddressException();
		System.out.println("Data Memory| Accessing Address " + address + " to write " + data);
		memory[address] = data;
	}

	public void store(Register R1, int add) throws IncorrectMemoryAddressException {
		if (add > DATA_MEMORY_SIZE - 1 || add < 0)
			throw new IncorrectMemoryAddressException();
		memory[add] = R1.getData();
	}

	@Override
	public String toString() {
		// TODO: ask about the print format
		System.out.println();
		String print = new String("-- Data memory --\n");
		for (int memLoc = 0; memLoc < memory.length; memLoc++) {
			print += "Memory Location " + memLoc + ": "
					+ (memory[memLoc] == null ? memory[memLoc]
							: " data in decimal=" + memory[memLoc] + " in binary= "
									+ Printer.extendBinaryNumber(Integer.toBinaryString(memory[memLoc]), REGISTER_SIZE))
					+ "\n";
		}
		print += "-- Data Memory End --\n";
		return print;
	}

	public void reset() {
		memory = new Byte[DATA_MEMORY_SIZE];
	}
}

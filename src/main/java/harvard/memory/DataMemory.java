package harvard.memory;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.storage.Register;

import static harvard.constants.Constants.*;

public class DataMemory {
    Byte [] memory;
    private static DataMemory instance = null;

    private DataMemory(){
        memory = new Byte[DATA_MEMORY_SIZE];
    }
    public static DataMemory getInstance() {
        if (instance == null)
            instance = new DataMemory();
        return instance;
    }

    public Byte readAddress(int address) throws IncorrectMemoryAddressException {
        if(address<0 || address>=memory.length)throw new IncorrectMemoryAddressException();
        System.out.println("Data Memory| Accessing Address "+address+" to read "+memory[address]);
        return memory[address];
    }

    public void writeAddress(int address, Byte data) throws IncorrectMemoryAddressException {
        if(address<0 || address>=memory.length)throw new IncorrectMemoryAddressException();
        System.out.println("Data Memory| Accessing Address "+address+" to write "+data);
        memory[address] = data;

    }


    @Override
    public String toString() {
        String print = new String();
        print += "-- Data Memory --\n";
        for (int memLoc =0;memLoc<memory.length;memLoc++) {
            print += "Memory Location "+memLoc+" data in decimal="+memory[memLoc]+" in binary="+Integer.toBinaryString(0xFFFF & memory[memLoc])+"\n";
        }
        print+= "-- Data Memory End --";
        return print;
    }


    public void reset() {
        memory = new Byte[DATA_MEMORY_SIZE];
    }

}

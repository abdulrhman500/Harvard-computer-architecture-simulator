package harvard.memory;

import harvardComputerExceptions.IncorrectMemoryAddressException;
import storage.Register;

import static constants.Constants.*;

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

    public Byte readAddress(int address) {
     //TODO: implement this method
        return null;
    }

    public void writeAddress(int address, Byte data) throws IncorrectMemoryAddressException {
        //TODO: implement this method
        if (address > DATA_MEMORY_SIZE-1 || address < 0)
        {
            throw new IncorrectMemoryAddressException();
        }
    }

    public void store(Register R1, int add){
        //TODO: exception
        memory[add] = R1.getData();
    }

    @Override
    public String toString(){
        //TODO: ask about the print format
        String print = new String();
        for(Byte data: memory)
        {
            print+= data;
        }
        return print;
    }

    public void reset() {
        memory = new Byte[DATA_MEMORY_SIZE];
    }

}
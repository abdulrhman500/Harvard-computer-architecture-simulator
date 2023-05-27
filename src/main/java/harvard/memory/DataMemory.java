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
        if (address > DATA_MEMORY_SIZE-1 || address < 0) throw new IncorrectMemoryAddressException();
        return  (getInstance().memory)[address];
    }

    public void writeAddress(int address, Byte data) throws IncorrectMemoryAddressException {
        if (address > DATA_MEMORY_SIZE-1 || address < 0) throw new IncorrectMemoryAddressException();
        (getInstance().memory)[address] = data;
    }

    public void store(Register R1, int add) throws IncorrectMemoryAddressException {
        if (add > DATA_MEMORY_SIZE-1 || add < 0) throw new IncorrectMemoryAddressException();
        memory[add] = R1.getData();
    }

    @Override
    public String toString(){
        //TODO: ask about the print format
        System.out.println();
        String print = new String("-- Data memory --\n");
        for(Byte data: memory)
        {
            print+= (data==null?"null":data)+"\n";
        }
        return print;
    }

    public void reset() {
        memory = new Byte[DATA_MEMORY_SIZE];
    }

}

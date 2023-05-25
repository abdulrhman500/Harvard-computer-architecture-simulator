package harvard.memory;

import harvard.instruction.RInstruction;

import static harvard.constants.Constants.INSTRUCTION_MEMORY_SIZE;

public class InstructionMemory {

    private short[] instructionMemory;
    private int currentIntruction;
    private static InstructionMemory instance = null;

    private InstructionMemory() {
        instructionMemory = new short[INSTRUCTION_MEMORY_SIZE];
        currentIntruction = 0;
    }

    public static InstructionMemory getInstance() {
        if (instance == null)
            instance = new InstructionMemory();
        return instance;
    }

    public int getCurrentIntruction() {
        return currentIntruction;
    }

    public void addInstruction(short instruction) {
        //TODO: waiting for the full implementation
        instructionMemory[currentIntruction++] = instruction;
        //RInstruction.setAddress(currentIntruction);
    }

    @Override
    public String toString() {
        String print = new String();
        for (short inst : instructionMemory) {
            //TODO: waiting for the full implemntaion of intruction
        }
        return print;
    }

    public void reset() {
        this.instructionMemory = new short[INSTRUCTION_MEMORY_SIZE];
        this.currentIntruction = 0;
    }


    public short getInstruction(int pc) {
        return instructionMemory[pc];
    }
}

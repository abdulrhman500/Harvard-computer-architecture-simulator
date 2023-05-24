package harvard.memory;

import harvard.instruction.Instuctions;

import static harvard.constants.Constants.INSTRUCTION_MEMORY_SIZE;
import static harvard.instruction.Instuctions.*;

public class InstructionMemory {

    private Instuctions[] RInstructionMemory;
    private int currentIntruction;
    private static InstructionMemory instance = null;
    private InstructionMemory(){
        RInstructionMemory = new Instuctions[INSTRUCTION_MEMORY_SIZE];
        currentIntruction =0 ;
    }

    public static InstructionMemory getInstance() {
        if (instance == null)
            instance = new InstructionMemory();
        return instance;
    }

    public Instuctions fetch() {
        //TODO: waiting for the PC
        return null;
    }

    public void addInstruction(Instuctions RInstruction) {
        //TODO: waiting for the full implementation
        RInstructionMemory[currentIntruction++] = RInstruction;
        //RInstruction.setAddress(currentIntruction);
    }

    @Override
    public String toString(){
        String print = new String();
        for(Instuctions RInstruction : RInstructionMemory)
        {
            //TODO: waiting for the full implemntaion of intruction
        }
        return print;
    }
    public void reset() {
        this.RInstructionMemory = new Instuctions[INSTRUCTION_MEMORY_SIZE];
        this.currentIntruction = 0;
    }


}

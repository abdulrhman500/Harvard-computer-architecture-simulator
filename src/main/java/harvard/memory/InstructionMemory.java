package harvard.memory;

import static harvard.constants.Constants.INSTRUCTION_MEMORY_SIZE;

public class InstructionMemory {

    private RInstruction[] RInstructionMemory;
    private int currentIntruction;
    private static InstructionMemory instance = null;
    private InstructionMemory(){
        RInstructionMemory = new RInstruction[INSTRUCTION_MEMORY_SIZE];
        currentIntruction =0 ;
    }

    public static InstructionMemory getInstance() {
        if (instance == null)
            instance = new InstructionMemory();
        return instance;
    }

    public RInstruction fetch() {
        //TODO: waiting for the PC
        return null;
    }

    public void addInstruction(RInstruction RInstruction) {
        //TODO: waiting for the full implementation
        RInstructionMemory[currentIntruction++] = RInstruction;
        //RInstruction.setAddress(currentIntruction);
    }

    @Override
    public String toString(){
        String print = new String();
        for(RInstruction RInstruction : RInstructionMemory)
        {
            //TODO: waiting for the full implemntaion of intruction
        }
        return print;
    }
    public void reset() {
        this.RInstructionMemory = new RInstruction[INSTRUCTION_MEMORY_SIZE];
        this.currentIntruction = 0;
    }


}

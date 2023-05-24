package harvard.memory;

import harvard.instruction.Instruction;

import static harvard.constants.Constants.Intruction_MEMORY_SIZE;

public class InstructionMemory {

    private Instruction[] instructionMemory;
    private int currentIntruction;
    private static InstructionMemory instance = null;
    private InstructionMemory(){
        instructionMemory = new Instruction[Intruction_MEMORY_SIZE];
        currentIntruction =0 ;
    }

    public static InstructionMemory getInstance() {
        if (instance == null)
            instance = new InstructionMemory();
        return instance;
    }

    public Instruction fetch() {
        //TODO: waiting for the PC
        return null;
    }

    public void addInstruction(Instruction instruction) {
        //TODO: waiting for the full implementation
        instructionMemory[currentIntruction++] = instruction;
        //instruction.setAddress(currentIntruction);
    }

    @Override
    public String toString(){
        String print = new String();
        for(Instruction instruction: instructionMemory)
        {
            //TODO: waiting for the full implemntaion of intruction
        }
        return print;
    }
    public void reset() {
        this.instructionMemory = new Instruction[Intruction_MEMORY_SIZE];
        this.currentIntruction = 0;
    }


}

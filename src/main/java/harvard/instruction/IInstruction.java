package harvard.instruction;

import harvard.storage.Register;

public abstract class IInstruction implements Instruction {
    int register1, immediate, destReg;

    public IInstruction(int register1, int immediate, int destReg) {
        this.register1 = register1;
        this.immediate = immediate;
        this.destReg = destReg;
    }

    public abstract void doOperation();


    public abstract void updateFlags(int result);

}
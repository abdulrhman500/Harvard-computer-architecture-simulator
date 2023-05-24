package harvard.instruction;

import harvard.memory.DataMemory;
import harvard.storage.Register;

public class LB extends IInstruction {


    public LB(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        register1.setData(DataMemory.getInstance().readAddress(immediate));
    }

    @Override
    public Byte getResult() {

        return result;
    }

    @Override
    public void updateFlags(int result) {

    }

    @Override
    public void setRegisters(Register register1, Byte immediate) {
        this.register1 = register1;
       this.immediate= immediate;
    }
}

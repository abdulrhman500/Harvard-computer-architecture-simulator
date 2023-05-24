package harvard.instruction;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.storage.Register;

public class SB extends IInstruction {

    public SB(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        try {
            DataMemory.getInstance().writeAddress(immediate,register1.getData());
        } catch (IncorrectMemoryAddressException e) {
            throw new RuntimeException(e);
        }

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
        this.immediate = immediate;
    }
}

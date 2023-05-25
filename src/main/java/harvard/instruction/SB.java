package harvard.instruction;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.storage.Register;

public class SB extends IInstruction {

    public SB(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        try {
            DataMemory.getInstance().writeAddress(immediate, (byte) register1);
        } catch (IncorrectMemoryAddressException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateFlags(int result) {
    }

}

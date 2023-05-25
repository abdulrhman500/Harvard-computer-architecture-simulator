package harvard.instruction;

import harvard.storage.ProgramCounter;
import harvard.storage.Register;

public class BEQZ extends IInstruction {

    public BEQZ(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        if (register1.getData() == 0) {
            ProgramCounter pc = ProgramCounter.getInstance();
            pc.setData((byte) (pc.getData() + 1 + immediate));
        }
    }

    @Override
    public Byte getResult() {
        // Implementation specific to BEQZ instruction
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to BEQZ instruction
    }

    @Override
    public void setRegisters(Register register1, Byte immediate) {
        this.register1 = register1;
        this.immediate = immediate;
    }


}

package harvard.instruction;

import harvard.storage.ProgramCounter;
import harvard.storage.Register;

public class BEQZ extends IInstruction {

    public BEQZ(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        if (register1 == 0) {
            ProgramCounter pc = ProgramCounter.getInstance();
            pc.setData((byte) (pc.getData() + 1 + immediate));
        }
    }


    @Override
    public void updateFlags(int result) {
        // Implementation specific to BEQZ instruction
    }

}

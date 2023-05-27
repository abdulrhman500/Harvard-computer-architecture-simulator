package harvard.instruction;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

public class SB extends IInstruction {

    public SB(String register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        result =(short) (((Register)RegisterFile.getInstance().getRegister(reg1)).getData() & Constants.BYTE_NUMBER_BITS);
    }

    @Override
    public void setOperation() throws IncorrectMemoryAddressException {
        try{
            DataMemory.getInstance().writeAddress(immediate,(byte)(result & Constants.BYTE_NUMBER_BITS));
        }
        catch (IncorrectMemoryAddressException e) {
            throw new IncorrectMemoryAddressException(e.getMessage());
        }
    }

    @Override
    public void updateFlags() {
        //TODO: take care of this
        SREG.updateFlags(EInstuctions.SB,this.result, (Register) this.register1, null);
    }
}

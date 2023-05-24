package harvard.instruction;

import harvard.storage.Register;

import static harvard.constants.Constants.SIX_ONES_MASK;
import static harvard.utils.BaseConversion.toBinary;

public class ADD implements Instruction {
    private Register register1, register2;
    byte result;
    private InstructionType type;

    public ADD() {
        // Empty constructor
    }

    public ADD(Register register1, Register register2, InstructionType type) {
        setRegisters(register1, register2, type);
    }

    @Override
    public void doOperation() {

        System.out.println("R1: "+ register1.toBinary());
        System.out.println("R2: "+ register2.toBinary());
        System.out.println(SIX_ONES_MASK);
        System.out.println(register2.getData().intValue() & SIX_ONES_MASK);
        byte tmp1 = (byte) (register1.getData() & SIX_ONES_MASK);
        byte tmp2 = (byte) (register2.getData() & SIX_ONES_MASK);
        System.out.println("tmp1: "+ toBinary(tmp1));
        System.out.println("tmp2: "+ toBinary(tmp2));

        byte tmpResult = (byte) (tmp1 + tmp2);
        int carry = (tmpResult >> 6)&1;
        
        System.out.println("tmpResult: "+ toBinary(tmpResult));
        tmpResult &= SIX_ONES_MASK;
        System.out.println("After mask tmpResult: "+ toBinary(tmpResult));

        byte sign = (byte) (tmpResult >> 5);

        System.out.println("Sign: "+ sign);
        if (sign == 1)
            tmpResult |= 0b110000;
        else
            tmpResult &= 0b001111;

        System.out.println("After sign extend tmpResult: "+tmpResult);
        System.out.println("After sign extend tmpResult: "+toBinary(tmpResult));


        result = tmpResult;
    }

    @Override
    public Byte getResult() {
        // Implementation specific to ADD instruction
        return result;
    }

    @Override
    public void updateFlags() {





    }

    @Override
    public void setRegisters(Register register1, Register register2, InstructionType type) {
        this.register1 = register1;
        this.register2 = register2;
        this.type = type;
    }
}

package harvard.instruction;

public interface Instruction {

     void doOperation();

    Byte getResult();

    void updateFlags(int result);


}

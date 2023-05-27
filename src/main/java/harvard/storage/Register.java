package harvard.storage;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.DataMemory;
import harvard.utils.BaseConversion;

public class Register {
    private Byte data;
    public Register(Byte data){
        this.data = data;
    }
    public Register(){}

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public void add(Register R2){
        int tmp = (int)data + (int)R2.getData();
        SREG.getInstance().setCBit( (tmp & (1<<9)) > 0 );
        data = (byte) (data + R2.getData());
    }
    public String toBinary() {
        if (data == null)
            return null;
        return BaseConversion.toBinary(data);
    }

    //TODO: (V & N & S & Z) flags registerfile conditions
    public void sub(Register R2){
        data = (byte) (data - R2.getData());
    }

    public void mul(Register R2){
        data = (byte) (data * R2.getData());
    }

    public void and(Register R2){
        data = (byte) (data & R2.getData());
    }

    public void or(Register R2){
        data = (byte) (data | R2.getData());
    }

    public void shiftLeft(Byte imm){
        data = (byte)(data << imm | data >>> 8 - imm);
    }

    public void shiftRight(Byte imm){
        data = (byte)( data >>> imm | data << 8 - imm);
    }

    public void loadByte(int add) throws IncorrectMemoryAddressException {
        setData(DataMemory.getInstance().readAddress(add));
    }

    @Override
    public String toString() {
        return "Data in decimal = " + data + " Data in binary = " + this.toBinary();
    }

}

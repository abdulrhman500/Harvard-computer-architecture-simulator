package storage;

import harvard.memory.DataMemory;

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
        data = (byte) (data + R2.getData());
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

    public void loadByte(int add){
        setData(DataMemory.getInstance().readAddress(add));
    }

}
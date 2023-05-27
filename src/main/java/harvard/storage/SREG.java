package harvard.storage;

import harvard.instruction.EInstuctions;

public class SREG extends Register{

    private static SREG instance = null;
    public SREG(){ super();}
    public SREG(Byte data){ super(data);}

    public static SREG getInstance() {
        if (instance == null)
            instance = new SREG();
        return instance;
    }

    public void setZBit(boolean setter){
        setBit((byte) 0, setter);
    }

    public void setSBit(boolean setter){
        setBit((byte) 1, setter);
    }

    public void setNBit(boolean setter){
        setBit((byte) 2, setter);
    }

    public void setVBit(boolean setter){
        setBit((byte) 3, setter);
    }

    public void setCBit(boolean setter){
        setBit((byte) 4, setter);
    }
    private void setBit(Byte bitNum, boolean setter){
        Byte data = getData();
        data = (byte) (data | (((byte)1)<<bitNum));
        if(!setter) {
            data = (byte) (data ^ (((byte) 1) << bitNum));
        }
        setData(data);
    }

    public static void updateFlags(EInstuctions Einstruction, int result, Register register1, Register register2) {


        boolean carry = ((result >> 8) & 1) == 1;
        boolean overflow = false;
        boolean negative = result < 0;
        boolean zero = result == 0;
        int resultSign = (result>>7)&1;
        int register1Sign = (register1.getData() >> 7) & 1;
        int register2Sign = (register2.getData() >> 7) & 1;
        if ((register1Sign == register2Sign) && resultSign != register1Sign)
            overflow = true;
        boolean sign = negative ^ overflow;
        switch (Einstruction){

        }
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setCBit(carry);
        SREG.getInstance().setVBit(overflow);
        SREG.getInstance().setZBit(zero);
        SREG.getInstance().setSBit(sign);
    }

}

package harvard.storage;

public class SREG extends Register {

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

    public void setSBit(){
        setBit((byte) 1,((getData()>>2 & 1)>0) ^ ((getData()>>3 & 1)>0));
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

}

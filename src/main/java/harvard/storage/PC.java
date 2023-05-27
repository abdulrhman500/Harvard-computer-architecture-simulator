package harvard.storage;

import harvard.constants.Constants;

public class PC{

    Short data;
    public PC (Short data){
        this.data = (short) (data & Constants.PC_BITS_NUMBER);
    }
    public PC(){

    }

    public Short getData() {
        return data;
    }

    public void setData(Short data) {
        this.data = data;
    }
}

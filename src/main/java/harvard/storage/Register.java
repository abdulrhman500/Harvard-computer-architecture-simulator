package harvard.storage;

import harvard.constants.Constants;
import harvard.memory.DataMemory;
import harvard.utils.BaseConversion;

public class Register {
    private Byte data;
    public Register(byte data){
        this.data = data ;
    }
    public Register(){}

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }


}

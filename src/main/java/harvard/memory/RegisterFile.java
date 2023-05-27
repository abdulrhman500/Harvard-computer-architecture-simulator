package harvard.memory;

import harvard.constants.Constants;
import harvard.storage.PC;
import harvard.storage.Register;
import harvard.storage.SREG;

import java.util.HashMap;

public class RegisterFile {

    HashMap<String, Register> registers;
    PC pc;

    static RegisterFile instance = null;
    private RegisterFile(){
        this.registers = new HashMap<String, Register>();
        for(int i=0;i<64;i++){
            this.registers.put(Constants.R_NAME_REGISTER +i,new Register());
        }
        this.registers.put(Constants.SREG_NAME_REGISTER, SREG.getInstance());
        pc = new PC();
    }

    public static RegisterFile getInstance() {
        if(RegisterFile.instance == null) RegisterFile.instance= new RegisterFile();
        return RegisterFile.instance;
    }

    public Register getRegister(String registerName){
        return this.registers.get(registerName);
    }

    public void setRegister(String registerName,byte data){
        this.registers.get(registerName).setData(data);
    }

    public PC getPCRegister(String registerName){
        return this.pc;
    }

    public void setPCRegister(short data){
        this.pc.setData(data);
    }
}
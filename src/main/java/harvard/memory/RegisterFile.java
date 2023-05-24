package harvard.memory;


import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

import java.util.HashMap;

public class RegisterFile {

    HashMap<String, Register> registers;

    static RegisterFile instance = null;
    private RegisterFile(){
        this.registers = new HashMap<String,Register>();
        for(int i=0;i<64;i++){
            this.registers.put("R"+i,new Register());
        }
        this.registers.put("PC", ProgramCounter.getInstance());
        this.registers.put("SREG", SREG.getInstance());

    }

    public static RegisterFile getInstance() {
        if(RegisterFile.instance == null) RegisterFile.instance= new RegisterFile();
        return RegisterFile.instance;
    }

    public Register getRegister(String registerName){
        return this.registers.get(registerName);
    }

}

package harvard.storage;

public class ProgramCounter extends Register {

    private static ProgramCounter instance = null;
    public ProgramCounter(){ super();}
    public ProgramCounter(Byte data){ super(data);}

    public void BEQZ ( Register R1, int imm){
        if(R1.getData() == 0){
            setData((byte)(getData()+1+imm));
        }
    }

    public static ProgramCounter getInstance() {
        if (instance == null)
            instance = new ProgramCounter();
        return instance;
    }

    public void jump(Register R1, Register R2){
        //TODO: implement data = R1 || R2  -> || concatanate
    }

}


package harvard.storage;

public class ProgramCounter {

    private short data;
    private static ProgramCounter instance = null;


    private ProgramCounter(){ }
    public ProgramCounter(short data){ this.data = data;}


    public static ProgramCounter getInstance() {
        if (instance == null)
            instance = new ProgramCounter();
        return instance;
    }

    public short getData() {
        return data;
    }

    public void setData(short data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Program Counter "+ super.toString();
    }
}


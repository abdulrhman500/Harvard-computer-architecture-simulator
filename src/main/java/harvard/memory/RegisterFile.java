package harvard.memory;

import harvard.constants.Constants;
import harvard.storage.Register;

public class RegisterFile {
    private Register[] registers;
    public static final RegisterFile registerFile = new RegisterFile();

    private RegisterFile() {
        registers = new Register[Constants.REGISTER_FILE_SIZE];
        for (int i = 0; i < Constants.REGISTER_FILE_SIZE; i++) {
            registers[i] = new Register();
        }
    }

    public Register getRegister(int index) {
        return registers[index];
    }

    public static RegisterFile getInstance() {
        return registerFile;
    }
}

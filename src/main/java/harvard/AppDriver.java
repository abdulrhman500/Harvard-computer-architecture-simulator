package harvard;

import harvard.instruction.ADD;
import harvard.instruction.RInstruction;
import harvard.instruction.InstructionType;
import harvard.storage.Register;

public class AppDriver {
     int clock ;
     RInstruction[] program;
     int program_count;
     int max_clock;
     int FETCH=0;
     int DECODE = -1;
     int EXECUTE = -2;
   private  void init(){
       clock = 0;

   }
   public  void run(String path){
       this.init();
       // parser
       // load to memory
       // for (int inst : program )
       //fetch(this);
       //decode()
       //execute()
       //print(CLOCK)
       //increment


   }
    public static void main(String args[]) {
//     AppDriver app = new AppDriver();
//     app.run("");
//        Parser parser = new Parser();
//        int pc;

//       Fetch.fetch(pc);
        Register r1 = new Register((byte)-5);
        Register r2 = new Register((byte)-8);

        ADD add= new ADD(r1,r2);
        add.doOperation();
        System.out.println(add.getResult());



    }
}
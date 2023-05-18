package harvard;

import harvard.instruction.Instruction;

public class AppDriver {
     int clock ;
     Instruction[] program;
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



    }
}
package problema;

public class MainClass {
    public static void main(String[] args) throws Exception {        
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int nrOfObservations = 0;
        boolean exit = false;
        
        try {
            nrOfObservations = sc.nextInt();
        }
        catch(java.util.InputMismatchException e) {
            //System.out.println(e.getLocalizedMessage());
            System.out.println("You must enter an integer!");
            exit = true;
        }
        
        if(!exit) {
            TimeHandler s = new TimeHandler();

            if (1 <= nrOfObservations && nrOfObservations <= 1000) {
                if (s.enterTime(nrOfObservations, sc)) {
                    System.out.println(s.calculateAverageSLMinute());
                }
            }
            else {
                System.out.println("Only an integer with the value 1-1000 is acceptable.");
            }
        }
    }
}

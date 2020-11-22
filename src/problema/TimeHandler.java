package problema;

public class TimeHandler {
      
    private int secondsWaited;
    private int displayedMinutes;
    
    public TimeHandler() {
        this.secondsWaited = 0;
        this.displayedMinutes = 0;
    }
    
    public boolean enterTime(int nrOfObservations, java.util.Scanner sc) {
        boolean correctInput = true;
        int seconds = 0, minutes = 0;
        
        try {
            for (int i = 0; i < nrOfObservations; i++) {
                minutes = sc.nextInt();
                seconds = sc.nextInt();
                
                if (this.checkTime(seconds, minutes)) {
                    this.secondsWaited += seconds;
                    this.displayedMinutes += minutes;
                }
                else {
                    correctInput = false;
                    break;
                }
            }
        }
        catch(java.util.InputMismatchException e) {
            //System.out.println(e.getMessage());
            System.out.println("You must enter 2 integers; '<minutes> <seconds>'");
            correctInput = false;
        }
        
        return correctInput;
    }
    
    public boolean checkTime(int secondsEntered, int minutesEntered) {
        boolean correctInput = true;
        
        // Check if the integers, '<second> <minute>', you've just added are within the acceptable range
        if (!((0 <= secondsEntered && secondsEntered <= 3600) && (0 <= minutesEntered && minutesEntered <= 60))) {
            System.out.println("<minutes> must be any value in the range 0-60 and <seconds> any value in the range 0-3600");
            correctInput = false;
        }
        else {
            this.secondsWaited += secondsEntered;
            this.displayedMinutes += minutesEntered;
        }
        return correctInput;
    }
    
    public String calculateAverageSLMinute() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.#########");

        String response;
        double averageSLMinute = ((double)this.secondsWaited)/((double)this.displayedMinutes*60.0);
        
        // The average of S.L minutes must be larger than 1 and allMinutes must not be equal to 0 (division by 0 is not nice)
        if (averageSLMinute > 1 && this.displayedMinutes != 0) {
            response = df.format(averageSLMinute).replace(",", ".");
        }
        else {
            response = "measurment error";
        }
        
        return response;
    }
}

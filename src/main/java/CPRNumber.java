import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CPRNumber {
    private final LocalDate birthDay;
    private final int controlDigits;

    public CPRNumber(LocalDate birthDay, int controlDigits) {
        this.birthDay = birthDay;
        this.controlDigits = controlDigits;
        // If the check fails
        if (!this.checkIfValid()) {
            throw new IllegalArgumentException("Not a valid CPR Number!");
        }
    }

    private boolean checkIfValid() {
        return true;
    }


    public String getCPRNumberString () {
        String date = birthDay.format(DateTimeFormatter.ofPattern("ddMMyy"));
        return date + "-" + String.format("%04d", controlDigits);
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getControlDigits() {
        return controlDigits;
    }

    public Gender getGender () {
       return controlDigits % 2 == 1 ? Gender.Male : Gender.Female;
    }

    public static CPRNumber makeRandom(LocalDate date, Gender gender) {
       for (int i = 0; i <= 9999; i++) {
           try {
               CPRNumber n = new CPRNumber(date, i);
               if (n.getGender() == gender) {
                   return n;
               } else {
                   continue;
               }
           } catch (IllegalArgumentException a) {
               continue;
           }
       }
       throw new IllegalArgumentException();
    }

}

package ro.fasttrackit.curs13.exceptions;

public class BirthdayYearCalc {
    private final int age;

    public BirthdayYearCalc(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException(age);
        }
        this.age = age;
    }

    public int getYear() {
        if (age > 100) {
            throw new TooOldException(age);
        } else {
            return 2022 - age;
        }
    }
}

class TooOldException extends RuntimeException {
    private final int age;

    public TooOldException(int age) {
        super("you're too old!");
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class InvalidAgeException extends Exception {
    private int age;

    public InvalidAgeException(int age) {
        super(age + " is invalid");
        this.age = age;
    }
}

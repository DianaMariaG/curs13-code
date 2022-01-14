package ro.fasttrackit.curs13.exceptions;

public class UncheckedExceptions {

    public static void main(String[] args) {
        try {
            aNullPointer();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        throwMyUnchecked();
    }

    private static void throwMyUnchecked() {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new MyUncheckedException("Even");
        } else {
            System.out.println("nu se arunca exceptia");
        }
    }

    private static void aNullPointer() {
        String a = null;
        System.out.println(a.length());
    }
}

class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String msg) {
        super(msg);
    }
}
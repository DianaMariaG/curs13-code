package ro.fasttrackit.curs13.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptions {

    public static void main(String[] args) {
        try { //CATCH
            System.out.println("Start algo");
            javaCheckedExceptions();
            myLogic();
            System.out.println(args.length);

            System.out.println("After exception");
        } catch (MyException fnfe) { //e de la javaCheckedException
            System.out.println("Fisierul nu exista " + fnfe.getMessage());
//            fnfe.printStackTrace();
            System.err.println("Nu e oprita aplicatia");
        } catch (FileNotFoundException my) { //e de la myLogic
            System.out.println("Exceptia mea a fost aruncata " + my.getMessage());
        } catch (Exception exp) {
        } catch (Throwable thr) {
            System.out.println("generic");

        } finally { //se executa si daca intra pe try, si pe catch; e OPTIONAL
            System.out.println("se executa tot timpul");
        }

        System.out.println("In afara");
    }

    private static void javaCheckedExceptions() throws FileNotFoundException {
//        try { //corpul metodei in try
            FileReader test = new FileReader("test");
//        } catch (FileNotFoundException unNume) { //exceptia pe care o prinde in catch, si o numesc
        }

    private static void myLogic() throws MyException, FileNotFoundException {

        if (System.currentTimeMillis() % 2 == 0) {
            throw new MyException("The time is even");
        }
    }
}
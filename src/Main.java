import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Person p = new Person();


        hospital.CreateAndSave();
        hospital.registrarPersona(456325);
        System.out.println(" Vacunados ");
        hospital.PersonConKit();
        System.out.println(" LISTA dni y temp ");

        System.out.println(" testear");
        hospital.testear();
        hospital.ShowMap();
        System.out.println(" aislar");
        hospital.aislar(p);
    }
}
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.*;

public class Hospital {

    private Integer cantKit = 2;

    private List<Person> conKit = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();

    private HashMap<Integer, List> kitMap = new HashMap<>();

    private List<String> DniYtemp = new ArrayList<>();

    public Hospital() {
    }

    public Hospital(Integer cantKit, List<Person> personList) {
        this.cantKit = cantKit;
        this.personList = personList;

    }


    public Integer getcantKit() {
        return cantKit;
    }

    public void setKit(Integer kit) {
        this.cantKit = kit;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void CreateAndSave() {

        Person person1 = new Person(" Matias Perez", "33251000", 29, "Los Troncos", "cajero");
        Person person2 = new Person(" Juan Rodriguez", "31274000", 30, "Los Pinares", "camamero");
        Person person3 = new Person(" Carmen Sosa", "30749994", 35, "Chauvin", "abogada");
        Person person4 = new Person(" Manuel Labra", "39751426", 25, "Centro", "medico");
        Person person5 = new Person(" Rosa Gomez", "338962123", 27, "Los Troncos", "medica");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

    }

    public void ShowListPerson() {
        for (Person p : personList) {

            System.out.println(p);
        }
    }
//Tenemos una cantidad limitada de reactivos por lo cual al realizar un registro
//sin el kit debemos lanzar una excepción creada por nosotros. Al ser lanzada la excepción le
//preguntaremos al SSM si cuenta con más test y si es positivo, ingresaremos la nueva
//cantidad. Las personas se almacenan por orden de llegada. Debemos controlar que no se
//repita el DNI.

    public void registrarPersona(double dni) {

        for (Person p : personList) {
            try {
                if (p.getDni().trim().equals(dni))  {
                    throw new IllegalArgumentException(" dni duplicado");
                } else if (cantKit >= 0) {
                    cantKit--;
                    conKit.add(p);
                }
                if (cantKit == 0) {
                    throw new InvalidObjectException(" No hay mas vacunas para el resto de los pacientes");
                }

            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
        }
    }

    public void PersonConKit() {
        for (Person p : conKit) {
            p.setKit();
            System.out.println(p);
        }
    }


    public void ShowListConKit() {
        for (Person p : conKit) {
            System.out.println(p);
        }
    }
//método llamado “testear” donde
//evaluaremos la temperatura de cada una de las personas. Con cada evaluación generamos
//una tabla donde la clave será el número de kit y el valor contendrá un registro que
//contendrá el DNI y la temperatura (generada de manera random entre 36 y 39 grados).


    public List<String> dniList (){
        List <String> dniList = new ArrayList<>();
        for (Person p : this.conKit){
            dniList.add(p.getDni());
        }
        return dniList;
    }

    public void RegistroTemp(List <Person>conKit) {

        for (Person p : conKit) {
            this.DniYtemp.add(p.getDni());
            System.out.println(DniYtemp);
        }
    }

    public void testear() {

        for (Person p : conKit) {
            kitMap.put(p.getKit(), DniYtemp);
        }
    }

    public void ShowMap() {

        System.out.println(kitMap);

    }

//na vez realizados todos los test, invocamos un método llamado “aislar” donde si la
//temperatura supera los 38 grados (inclusive) lanzaremos una excepción que contendrá el
//número de test y el barrio. Como tratamiento de ese error, esos datos se deben almacenar
//en un archivo binario de objetos llamado “urgente.dat” (opcional).

    public void aislar(Person p) {
        try {
            if (p.getTemperatura() >= 38) {
                throw new IOException(" FIEBRE ALTA. test: " + p.kit() + " barrio: " + p.getNavehood());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
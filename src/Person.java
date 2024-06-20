import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.stream.IntStream;

public class Person {
    private String nameAndSurname;
    private String dni;
    private Integer age;
    private String navehood;
    private String job;
    private Integer kit = (int) (Math.random() * 100);

    Random rand = new Random();
    private double temperatura;


    public Person() {
    }

    public Person(String nameAndSurname, String dni, Integer age, String navehood, String job) {
        this.nameAndSurname = nameAndSurname;
        this.dni = dni;
        this.age = age;
        this.navehood = navehood;
        this.job = job;

    }

    public Integer kit() {
        return kit;
    }

    public void setKit() {
        this.kit = kit;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNavehood() {
        return navehood;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setNavehood(String navehood) {
        this.navehood = navehood;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void AleatoyryNumbers() {

        Random aleatorio = new Random();
        for (int i = 0; i < 5; i++) {
            kit = aleatorio.nextInt(6);
        }
    }
    public void randomTemp ()
    {
        Random rand = new Random();
        temperatura = 36.0 + rand.nextDouble() * (39.0 - 36.0 );
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameAndSurname='" + nameAndSurname + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", navehood='" + navehood + '\'' +
                ", job='" + job + '\'' +
                ", vacunado:" + kit + '\'' +
                '}';
    }
}

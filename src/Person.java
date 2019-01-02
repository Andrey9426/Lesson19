import java.io.*;

public class Person implements Serializable {
    private static String gender = "male";
    private String firstName;
    private String lastName;
    private int age;
    private boolean isStudent;
     private String newField;
    private static final long serialVersionUID= - 2342342342234L;

    public Person(String newField) {
        this.newField = newField;
    }

    public String getNewField() {

        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isStudent=" + isStudent +
                ", newField='" + newField + '\'' +
                '}';
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Person(String firstName, String lastName, int age, boolean isStudent) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isStudent = isStudent;
    }

}
class Runner{

    public static void writePersonTofile(Person person,String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(person);
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }


public static Person readPersonFromFile(String fileName){
        Person p = null;
        try(FileInputStream fis= new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fis)){
            p = (Person)oin.readObject();
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
    }return  p ;
}







    public static void main(String[] args) {

      Person ivan = new  Person("Ivan","Peter",25,true);
        String fileName = "ivan.txt";
       writePersonTofile(ivan,fileName);


         Person personFromFile= readPersonFromFile(fileName);
        System.out.println(personFromFile);

//        Person tom = new Person("Tom","Johus",40,false);
//        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("tom.txt"))){
//            dos.writeUTF(tom.getFirstName());
//            dos.writeUTF(tom.getLastName());
//            dos.writeInt(tom.getAge());
//            dos.writeBoolean(tom.isStudent());
//            System.out.println("file has been written");
//        }catch (IOException ex){
//            System.out.println(ex.getStackTrace());
//        }
//        try(DataInputStream dis = new DataInputStream(new FileInputStream("tom.txt"))){
//            String name = dis.readUTF();
//            String lastName = dis.readUTF();
//            int age = dis.readInt();
//            boolean isStudent= dis.readBoolean();
//            Person person = new Person(name,lastName,age,isStudent);
//            System.out.println(person);
//        }catch (IOException ex){
//            System.out.println(ex.getStackTrace());
//        }
//


    }
}

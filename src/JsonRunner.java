import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRunner {
    public static void writePersonToJson(Person person ){
        ObjectMapper mapper =  new  ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try{
            writer.writeValue(new File("person.json"),person);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    private static void writePersonsToJson(List < Person > persons) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {

            writer.writeValue(new File("persons.json"), persons);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Person p = new Person("Ivan","Stepanow",30,false);
        writePersonToJson(p);

        Person o = new Person("Ivan", "Petrov", 34, true);

        Person tom = new Person("Tom", "Johns", 40, false);
        List<Person> personList = new ArrayList<>();
        personList.add(tom);
        personList.add(o);




    }

}

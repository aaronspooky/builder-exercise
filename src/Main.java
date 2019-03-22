import java.util.ArrayList;
import java.util.List;

class Person {
    public String name;
    public String type;
}

class CodeBuilder {
    public String className;
    Person person;
    List<Person> personList = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        person = new Person();
        person.name = name;
        person.type = type;
        personList.add(person);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("public class " +className);
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        for (Person person: personList) {
            stringBuilder.append("  public " +person.type+ " " +person.name+ ";");
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return "" +stringBuilder;
    }
}

public class Main {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}

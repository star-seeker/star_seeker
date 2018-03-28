package seek.pattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("夜影", "male", "single"));
        persons.add(new Person("夜离", "female", "single"));
        persons.add(new Person("夜枫", "male", "married"));
        persons.add(new Person("夜汐", "female", "married"));

        Criteria maleCriteria = new CriteriaMale();
        System.out.println("Males:");
        printCriteria(maleCriteria.meetCriteria(persons));

        Criteria femaleCriteria = new CriteriaFemale();
        System.out.println("Females:");
        printCriteria(femaleCriteria.meetCriteria(persons));

        Criteria singleCriteria = new CriteriaSingle();
        System.out.println("Single:");
        printCriteria(singleCriteria.meetCriteria(persons));

        Criteria andCriteria = new AndCriteria(maleCriteria, singleCriteria);
        System.out.println("Single males:");
        printCriteria(andCriteria.meetCriteria(persons));

        Criteria orCriteria = new OrCriteria(femaleCriteria, singleCriteria);
        System.out.println("Single or Female:");
        printCriteria(orCriteria.meetCriteria(persons));


    }

    private static void printCriteria(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person: [ name = " + person.getName() + ", gender = " + person.getGender() + ", marital = " + person.getMaritalStatus());
        }
    }
}

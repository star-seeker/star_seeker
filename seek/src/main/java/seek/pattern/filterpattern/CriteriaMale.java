package seek.pattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("male".equalsIgnoreCase(person.getGender())) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}

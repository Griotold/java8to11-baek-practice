package baek.function.supplier;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer {
    String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new)
    public Developer() {

    }

    // for factory(() -> new Developer("griotold"));
    public Developer(String name) {
        this.name = name;
    }

    // getter, setter, consturctor, toString
    // ...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", start=" + start +
                '}';
    }
}

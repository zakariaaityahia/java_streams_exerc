import java.util.*;

public class MainApp_tp2 {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("zakaria", "IT", 16000.00));
        emp.add(new Employee("ikram", "RH", 9000.00));
        emp.add(new Employee("oussama", "IT", 16000.00));
        emp.add(new Employee("Adil", "IT", 35000.00));
        emp.add(new Employee("Hidaya", "Networking", 18000.00));
        System.out.println("________1_______");

        // 1 // get total salaries
        double totalSalaries = emp.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum();
        System.out.println(totalSalaries);
        System.out.println("_______2________");
        // 2 // sort the employees by their names

        Collections.sort(emp, Comparator.comparing(Employee::getName));

        for(Employee e:emp){
            System.out.println(e);
        }
        System.out.println("_______3________");
        // 3 // show the less salary

        Employee lowestSalary = null;
        double empLowestsalary = Double.MAX_VALUE;
        for(Employee p : emp) {
            if(p.getSalary() < empLowestsalary) {
                empLowestsalary = p.getSalary();
                lowestSalary = p;
            }
        }

        System.out.println(lowestSalary);

        System.out.println("_______4________");

        double InputSalary = 15000.00;

        List<Employee> highSalaryEmployee = emp.stream()
                .filter(employee -> employee.getSalary() > InputSalary)
                .toList();

        for (Employee s : highSalaryEmployee){
            System.out.println("Salary great than 15000.00 : " + s);

        }

        System.out.println("_______5________");

        Optional<Employee> highestSalary = emp.stream()
                .reduce((p1, p2) -> p1.getSalary() > p2.getSalary() ? p1 : p2);

        highestSalary.ifPresent(employee -> System.out.println("the mployee with highest salary is : " + highestSalary));

        System.out.println("_______6________");

        String ConcatAllNames = emp.stream()
                .map(Employee::getName)
                .reduce("", (name_1, name_2) -> name_1 + " - " + name_2);

        System.out.println(ConcatAllNames);
    }
}

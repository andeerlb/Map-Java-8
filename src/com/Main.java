package com;

import com.model.Employee;

import java.util.*;

public class Main {

    private final static Map<Integer, List<Employee>> employeeDOJMap = new HashMap<>();

    public static void main(String[] args) {
        List<Employee> list2014 = Arrays.asList(new Employee("Deborah Sprightly", 29, 9000.00));
        List<Employee> list2015 = Arrays.asList(new Employee("Tom Jones", 45, 7000.00), new Employee("Harry Major", 25, 10000.00));
        List<Employee> list2016 = Arrays.asList(new Employee("Ethan Hardy", 65, 8000.00), new Employee("Nancy Smith", 22, 12000.00));

        employeeDOJMap.put(2015, list2015);
        employeeDOJMap.put(2014, list2014);
        employeeDOJMap.put(2016, list2016);

        System.out.println("\n");
        employeeDOJMap.forEach((year, list) -> System.out.println(String.format("year %s list %s", year, list)));

        System.out.println("\nCAPITALIZED Employee name usando Map.replaceAll()");
        employeeDOJMap.replaceAll((year, list) -> {
            list.replaceAll(emp -> {
                emp.setName(emp.getName().toUpperCase());
                return emp;
            });
            return list;
        });

        System.out.println("\n");
        employeeDOJMap.forEach((year, list) -> System.out.println(String.format("year %s list %s", year, list)));

        employeeDOJMap.computeIfAbsent(2018, list -> new ArrayList<>()).add(new Employee("Anderson", 23, 4200.00));
        employeeDOJMap.computeIfAbsent(2018, list -> new ArrayList<>()).add(new Employee("Tayara", 20, 4000.00));

        employeeDOJMap.forEach((year, list) -> System.out.println(String.format("year %s list %s", year, list)));

        System.out.println("\n");
        final List<Employee> orDefault = employeeDOJMap.getOrDefault(2019, new ArrayList<>());
        System.out.println(String.format("Size of empList 2019: %s", orDefault.size()));

        employeeDOJMap.put(2018, null);

        employeeDOJMap.computeIfPresent(2018, (year, list) -> list).add(new Employee("Fran", 25, 900.00));

        System.out.println("\n");
        employeeDOJMap.get(2018).forEach(val -> {
            System.out.println(val);
        });
    }
}
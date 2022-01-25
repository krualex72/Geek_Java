/**
 * Java 1. HomeWork 5
 * 
 * @author Alexey Krutikov
 * @version 25.01.2022
*/

import java.util.Arrays;

class HomeWorkFive {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5]; 
        employeeArray[0] = new Employee("Ivanov Petr", "Engineer", "ivpetr@our-company.com", "89231231224", 75000, 30);
        employeeArray[1] = new Employee("Petrov Ivan", "CEO", "ipeivan@our-company.com", "89239876543", 130000, 43);
        employeeArray[2] = new Employee("Grishin Vasily", "Secretary", "grvasily@our-company.com", "89211239875", 30000, 21);
        employeeArray[3] = new Employee("Vasiliev Grigory", "Engineer", "vagrigory@our-company.com", "89266542378", 75000, 45);
        employeeArray[4] = new Employee("Kuznetsova Maria", "Accountant", "kumaria@our-company.com", "89167538642", 45000, 28);
        
        for (int i=0; i < employeeArray.length; i++) {
            if ( employeeArray[i].getAge() > 40) {
                System.out.println (employeeArray[i]);
            }
        }
    }
}
    
class Employee {
    private String full_name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    
    public int getAge () {
        return age;
    }
    
    Employee ( String full_name, String position, String email, String phone, int salary, int age ) {
        this.full_name = full_name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    
    @Override
    public String toString () {
        return ("Full Name: " + full_name + "   Position: " + position + "   E-mail: " + email + "   Phone: " + phone + "   Salary: " + salary + "   Age: " + age);
    }
}
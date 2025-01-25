public class Employee {
    private static int newId = 1;

    private final int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = newId++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не должно быть пустым");
        } else {
            this.fullName = fullName;
        }
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел " + department + " не входит в интервал от 1 до 5");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Некорректно указана зарплата: " + salary);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id; // id уникален по условию задачи, а значит, может служить hash-кодом
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\nid: " + id +
                "\nfullName: '" + fullName + '\'' +
                "\ndepartment: " + department +
                "\nsalary: " + salary +
                "\n}";
    }
}

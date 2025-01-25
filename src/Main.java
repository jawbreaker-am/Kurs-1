//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        // Инициализация массива сотрудников
        initializeEmployees();

        // Вывод информации о всех сотрудниках
        printAllEmployees();

        //Подсчёт суммы затрат на ЗП в месяц;
        System.out.println("\nCумма затрат на ЗП в месяц: " + calculateTotalSalary());

        //Поиск сотрудника с минимальной ЗП;
        System.out.println("\nСотрудник с минимальной ЗП: " + minSalaryEmployee());

        //Поиск сотрудника с максимальной ЗП;
        System.out.println("\nСотрудник с максимальной ЗП: " + maxSalaryEmployee());

        //Расчет средней ЗП;
        System.out.println("\nСредняя зарплата сотрудников: " + avgSalary());

        // Вывод ФИО всех сотрудников
        System.out.println("\nФИО всех сотрудников:");
        printAllEmployeeNames();
    }

    public static void initializeEmployees() {
        employees[0] = new Employee("Иванов Александр Сергеевич", 1, 120000);
        employees[1] = new Employee("Петров Дмитрий Андреевич", 2, 95000);
        employees[2] = new Employee("Сидорова Анна Михайловна", 3, 80000);
        employees[3] = new Employee("Смирнов Владимир Иванович", 4, 140000);
        employees[4] = new Employee("Кузнецова Елена Алексеевна", 5, 110000);
        employees[5] = new Employee("Васильев Николай Владимирович", 1, 75000);
        employees[6] = new Employee("Попов Алексей Дмитриевич", 2, 130000);
        employees[7] = new Employee("Новикова Ольга Сергеевна", 3, 90000);
        employees[8] = new Employee("Федоров Михаил Николаевич", 4, 100000);
        employees[9] = new Employee("Морозова Татьяна Викторовна", 5, 85000);
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void printAllEmployeeNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static double calculateTotalSalary() {
        double result = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                result += employee.getSalary();
            }
        }
        return result;
    }

    public static Employee minSalaryEmployee() {
        Employee result = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < result.getSalary()) {
                result = employee;
            }
        }
        return result;
    }

    public static Employee maxSalaryEmployee() {
        Employee result = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > result.getSalary()) {
                result = employee;
            }
        }
        return result;
    }

    public static double avgSalary() {
        double result = 0;
        int qty = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                result += employee.getSalary();
                qty++;
            }
        }
        if (qty == 0) {
            throw new IllegalStateException("Нет сотрудников для расчета средней зарплаты.");
        }
        return result/qty;
    }
}
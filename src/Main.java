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

        //Вывод ФИО всех сотрудников
        System.out.println("\nФИО всех сотрудников:");
        printAllEmployeeNames();

        //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
        double indexRate=9.5;
        System.out.println("\nИндексация зарплат всех сотрудников на " + indexRate + "%:");
        indexSalaries(indexRate);
        printAllEmployees();

        int dept=3;
        System.out.println("\nНомер отдела: " + dept);
        // Сотрудник с минимальной зп с учетом отдела;
        System.out.println("\nСотрудник с минимальной ЗП в отделе " + dept +": \n" + minSalaryEmployeeDept(dept));

        // Сотрудник с максимальной зп с учетом отдела;
        System.out.println("\nСотрудник с максимальной ЗП в отделе " + dept +": \n" + maxSalaryEmployeeDept(dept));

        // Сумма затрат на зп по отделу;
        System.out.println("\nCумма затрат на ЗП в месяц в отделе " + dept +": " + String.format("%.2f", calculateTotalSalaryDept(dept)));

        // Средняя зп по отделу;
        System.out.println("\nСредняя зарплата сотрудников в отделе " + dept +": " + String.format("%.2f", avgSalaryDept(dept)));

        // Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        double indexRateDept=-2.5;
        System.out.println("\nИндексация зарплат всех сотрудников отдела " + dept + " на " + indexRateDept + "%");
        indexSalariesDept(indexRateDept, dept);

        // Напечатать всех сотрудников отдела (все данные, кроме отдела).
        System.out.println("\nВсе сотрудники отдела " + dept +": ");
        printAllEmployeesDept(dept);

        // Получить в качестве параметра число и вывести:
        double salaryThreshold = 90000.0;
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
        System.out.println("\nВсе сотрудники с зарплатой меньше " + String.format("%.2f", salaryThreshold) +": ");
        printAllEmployeesUnder(salaryThreshold);
        // Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
        System.out.println("\nВсе сотрудники с зарплатой больше или равной " + String.format("%.2f", salaryThreshold) +": ");
        printAllEmployeesAbove(salaryThreshold);
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

    public static void printAllEmployeesDept(int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                System.out.println(
                        "Employee{" +
                        "\nid: " + employee.getId() +
                        "\nfullName: '" + employee.getFullName() + '\'' +
                        "\nsalary: " + String.format("%.2f", employee.getSalary()) +
                        "\n}");
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

    public static double calculateTotalSalaryDept(int dept) {
        double result = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept)  {
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

    public static Employee minSalaryEmployeeDept(int dept) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept) {
                if (result == null || employee.getSalary() < result.getSalary()) {
                    result = employee;
                }
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

    public static Employee maxSalaryEmployeeDept(int dept) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept) {
                if (result == null||employee.getSalary() > result.getSalary()) {
                    result = employee;
                }
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

    public static double avgSalaryDept(int dept) {
        double result = 0;
        int qty = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                result += employee.getSalary();
                qty++;
            }
        }
        if (qty == 0) {
            throw new IllegalStateException("Нет сотрудников для расчета средней зарплаты.");
        }
        return result/qty;
    }

    public static void indexSalaries(double indexRate) {
        if (indexRate < -100.0) {
            throw new IllegalArgumentException("Понижение больше, чем зарплата.");
        }
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1.0 + indexRate / 100.0));
            }
        }
    }

    public static void indexSalariesDept(double indexRate, int dept) {
        if (indexRate < -100.0) {
            throw new IllegalArgumentException("Понижение больше, чем зарплата.");
        }
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employee.setSalary(employee.getSalary() * (1.0 + indexRate / 100.0));
            }
        }
    }

    public static void printAllEmployeesUnder(double salaryThreshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryThreshold) {
                System.out.println(
                        "Employee{" +
                                "\nid: " + employee.getId() +
                                "\nfullName: '" + employee.getFullName() + '\'' +
                                "\nsalary: " + String.format("%.2f", employee.getSalary()) +
                                "\n}");
            }
        }
    }

    public static void printAllEmployeesAbove(double salaryThreshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryThreshold) {
                System.out.println(
                        "Employee{" +
                                "\nid: " + employee.getId() +
                                "\nfullName: '" + employee.getFullName() + '\'' +
                                "\nsalary: " + String.format("%.2f", employee.getSalary()) +
                                "\n}");
            }
        }
    }
}
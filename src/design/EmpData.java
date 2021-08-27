package design;

public abstract class EmpData implements Employee{

    public abstract int employeeId();

    public abstract void employeeName();

    public abstract void assignDepartment();

    public abstract double calculateSalary(double totalHrsWorked);

    public abstract void benefitLayout();

    public abstract void formatEmail();

    public abstract void generatePassword();

}

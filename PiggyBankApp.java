import java.util.*;
abstract class Account {
    private String name;
    private String email;
    private String password;
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public abstract void login();
    public String getName() { return name; }
    public String getEmail() { return email; }
}
interface ExpenseTracker {
    void addExpense(String category, double amount);
    void viewExpenses();
}
interface BudgetingTool {
    void setBudget(double limit);
    void trackBudget();
}
class SavingsGoal {
    private String goalName;
    private double targetAmount;
    private String deadline;
    public SavingsGoal(String goalName, double targetAmount, String deadline) {
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }
    public void checkProgress(double savedAmount) {
        System.out.println("Progress: " + (savedAmount / targetAmount) * 100 + "%");
    }
}
class SavingsChallenge extends SavingsGoal{
    private List<Double> milestones;
    private String reward;
    public SavingsChallenge(String goalName, double targetAmount, String deadline, List<Double> milestones, String reward) {
        super(goalName, targetAmount, deadline);
        this.milestones = milestones;
        this.reward = reward;
    }
    @Override
    public void checkProgress(double savedAmount) {
        super.checkProgress(savedAmount);
        System.out.println("Milestones: " + milestones);
    }
}
class ExpenseManager implements ExpenseTracker {
    private Map<String, Double> expenses = new HashMap<>();
    public void addExpense(String category, double amount) {
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
    }
    public void viewExpenses() {
        System.out.println("Expenses: " + expenses);
    }
}
class BudgetManager implements BudgetingTool {
    private double budgetLimit;
    private Map<String, Double> categoryAllocations = new HashMap<>();
    public void setBudget(double limit) {
        this.budgetLimit = limit;
    }
    public void trackBudget() {
        System.out.println("Budget Limit: " + budgetLimit);
        System.out.println("Category Allocations: " + categoryAllocations);
    }
}
public class PiggyBankApp {
    public static void main(String[] args) {
        SavingsGoal goal = new SavingsGoal("Car Purchase", 5000, "2025-12-31");
        goal.checkProgress(2000);
        List<Double> milestones = Arrays.asList(1000.0, 3000.0, 5000.0);
        SavingsChallenge challenge = new SavingsChallenge("Save 5K", 5000, "2025-12-31", milestones, "Gold Badge");
        challenge.checkProgress(2000);
        ExpenseManager expenses = new ExpenseManager();
        expenses.addExpense("Groceries", 200);
        expenses.viewExpenses();
    }
}

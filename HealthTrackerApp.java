abstract class User {
    protected String name;
    protected int age;
    protected float weight;
    protected float height;
    public User(String name, int age, float weight, float height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    public float calculateBMI() {
        return weight / (height * height);
    }
    public abstract void displayInfo();
}
class HealthUser extends User {
    public HealthUser(String name, int age, float weight, float height) {
        super(name, age, weight, height);
    }
    @Override
    public void displayInfo() {
        System.out.println("User: " + name + ", Age: " + age);
        System.out.println("BMI: " + calculateBMI());
    }
}
interface ActivityTracker {
    void trackActivity(int steps, float caloriesBurned, float duration);
}
class Activity implements ActivityTracker {
    private int steps;
    private float caloriesBurned;
    private float duration;
    @Override
    public void trackActivity(int steps, float caloriesBurned, float duration) {
        this.steps = steps;
        this.caloriesBurned = caloriesBurned;
        this.duration = duration;
        System.out.println("Activity logged: " + steps + " steps, " + caloriesBurned + " kcal burned.");
    }
}
class FitnessTracker {
    private Activity activity;

    public FitnessTracker() {
        this.activity = new Activity();
    }
    public void logActivity(int steps, float caloriesBurned, float duration) {
        activity.trackActivity(steps, caloriesBurned, duration);
    }
    public void displaySummary() {
        System.out.println("Health Tracking Summary:");
    }
}
public class HealthTrackerApp {
    public static void main(String[] args) {
        HealthUser user = new HealthUser("John", 25, 75, 1.75f);
        user.displayInfo();

        FitnessTracker tracker = new FitnessTracker();
        tracker.logActivity(5000, 250, 45);
        tracker.displaySummary();
    }
}


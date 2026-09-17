package Demo;

import java.util.Arrays;
import java.util.Comparator;

class Activity {

    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + finish + ")";
    }
}
public class ActivitySelection {
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(5, 7),
            new Activity(5, 9),
            new Activity(8, 10)
        };
        Arrays.sort(activities,
                Comparator.comparingInt(a -> a.finish));
        System.out.println("Selected: " + activities[0]);
        int count = 1;
        int lastFinish = activities[0].finish;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinish) {
                System.out.println("Selected: " + activities[i]);
                count++;
                lastFinish = activities[i].finish;
            }
        }
        System.out.println("Total activities selected: " + count);
    }
}
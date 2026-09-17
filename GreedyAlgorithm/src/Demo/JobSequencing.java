package Demo;
import java.util.*;
class Job {
    char id;
    int deadline;
    int profit;
    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequencing {
    public static void printJobScheduling(Job[] arr, int t) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        boolean[] result = new boolean[t]; 
        char[] jobSequence = new char[t];
        int totalProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = Math.min(t, arr[i].deadline) - 1; j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    jobSequence[j] = arr[i].id;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        System.out.print("Scheduled Job Sequence: ");
        for (char id : jobSequence) {
            if (id != '\0') {
                System.out.print(id + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('A', 2, 100),
            new Job('B', 1, 50),
            new Job('C', 2, 40),
            new Job('D', 1, 20),
            new Job('E', 3, 30) 
        };
        int maxDeadline = 3; 
        printJobScheduling(jobs, maxDeadline);
    }
}



import java.text.ParseException;

public class fcfs{

    static void find_waiting_time(int processes[], int n, int wt[], int bt[]){
        wt[0] = 0;
        for(int i = 1; i < n; i++){
            wt[i] = bt[i - 1] + wt[i - 1];
        }

    }
    
    static void find_tat(int processes[], int n, int wt[], int bt[], int tat[]){
        for(int i = 0; i < n; i++){
            tat[i] = bt[i] + wt[i];
        }

    }

    static void find_avg_time(int processes[], int n, int bt[]){
        int wt[] = new int[n];
        int tat[] = new int[n];

        int total_wt = 0;
        int total_tat = 0;
        find_waiting_time(processes, n, wt, bt);
        find_tat(processes, n, wt, bt, tat);

        System.out.println("Process    BT    WT    TAT");
        for(int i = 0; i < n; i++){
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.print(i+1);
            System.out.print("    " + bt[i]);
            System.out.print("    " + wt[i]);
            System.out.print("    " + tat[i]);
            System.out.println("");
        }
        
        float s = (float) total_wt/ (float) n;
        float t = (float) total_tat/ (float) n;
        
        System.out.println();
        System.out.println("Average Time: " + t);
        System.out.println("Average Weight: " + s);

    }
    public static void main(String[] args) throws ParseException {
        int processes[] = {2,4,5};
        int n = 3;
        int bt[] = {10,15,12};
        find_avg_time(processes, n, bt);
    }


}

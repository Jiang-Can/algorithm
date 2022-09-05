package Algorithms.dynamicprogramming;

public class Task {
    int start;
    int end;
    int benefit;
    int last;

    public Task(int start, int end, int benefit) {
        this.start = start;
        this.end = end;
        this.benefit = benefit;
        last=end-start;
    }
}

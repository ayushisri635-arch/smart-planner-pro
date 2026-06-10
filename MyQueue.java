import java.util.Stack;

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        input.push(x);
    }

    // Remove element from front
    public int pop() {

        // Transfer if output empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    // Get front element
    public int peek() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    // Check queue empty or not
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

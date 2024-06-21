class MyQueue {

  Stack < Integer > stack1;
  Stack < Integer > stack2;
  public MyQueue() {
    stack1 = new Stack < > ();
    stack2 = new Stack < > ();
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    moveStack(stack1, stack2);
    int val = stack2.pop();
    moveStack(stack2, stack1);

    return val;
  }

  public int peek() {
    return stack1.get(0);
  }

  public boolean empty() {
    return stack1.isEmpty();
  }

  public void moveStack(Stack stack1, Stack stack2) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

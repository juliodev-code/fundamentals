package org.datastructures.stacks;

public class ThreeStacksInArray {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeStacksInArray(int stackSize){
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * numberOfStacks];
        this.sizes = new int[numberOfStacks];
    }

    public boolean isFull(int stackNum){
        return this.sizes[stackNum] == this.stackCapacity;
    }

    public boolean isEmpty(int stackNum){
        return this.sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum){
        int offSet = stackNum * stackCapacity;//6
        int size = this.sizes[stackNum];//1
        return offSet + size - 1;
    }

    public void push(int stackNum, int value){
        if(isFull(stackNum)) System.out.println("The stack is full");
        else{
            this.sizes[stackNum]++;
            this.values[indexOfTop(stackNum)] = value;
        }
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("The stack is empty");
            return -1;
        }
        else {
            int topIndex = indexOfTop(stackNum);
            int value = this.values[topIndex];
            this.values[topIndex] = 0;
            this.sizes[stackNum]--;
            return value;
        }
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("The stack is empty");
            return -1;
        }
        else return this.values[indexOfTop(stackNum)];

    }

    static void main() {
        ThreeStacksInArray stacks = new ThreeStacksInArray(3);
        stacks.push(0,1);
        stacks.push(0,2);
        stacks.push(1,4);
        stacks.push(1,5);
        stacks.push(2,8);

        System.out.println("Popping! " + stacks.pop(0));
        System.out.println("peek! " + stacks.peek(0));
    }
}

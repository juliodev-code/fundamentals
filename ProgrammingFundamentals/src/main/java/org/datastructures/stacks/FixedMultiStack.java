package org.datastructures.stacks;

public class FixedMultiStack {
    private final int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[numberOfStacks * stackSize];
        sizes = new int[numberOfStacks];
    }

    /*Push value onto stack*/
    public void push(int stackNum, int value) throws FullStackException{
        /*Check that we have space for the next element*/
        //if(isFull(stackNum)) throw new FullStackException("There is not space in stack " + stackNum);

        /*Increment stack pointer and then update top value */
        sizes[stackNum]++;
        //values[indexOfTop(stackNum)] = value;
    }

    /*Pop item to the top stack*/


    public class FullStackException extends RuntimeException {
        // Optional: Add constructors to provide detail messages or a cause
        public FullStackException(String message) {
            super(message);
        }
    }


}

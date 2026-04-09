package org.datastructures.stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfPlates {

    static class StackNode{
        public StackNode above;
        public StackNode below;
        public int value;

        public StackNode(int value){
            this.value = value;
        }
    }

    static class Stack {
        private final int capacity;
        public StackNode top;
        public StackNode bottom;
        public int size = 0;

        public Stack(int capacity){
            this.capacity = capacity;
        }

        public boolean isFull(){
            return capacity == size;
        }

        public void join(StackNode above, StackNode below){
            if(below != null) below.above = above;
            if(above != null) above.below = below;
        }

        public boolean push(int value){
            if(size >= capacity) return false;
            size++;
            StackNode newNode = new StackNode(value);
            if(size == 1) bottom = newNode;
            join(newNode,top);
            top = newNode;
            return true;
        }

        public int pop(){
            if(top == null) throw new EmptyStackException();
            int result = top.value;
            top = top.below;
            size--;
            return result;
        }

        public int removeBottom(){
            StackNode b = bottom;
            bottom = bottom.above;
            if(bottom != null) bottom.below = null;
            size--;
            return b.value;
        }
    }

    static class SetOfStacks{
        private final ArrayList<Stack> stacks = new ArrayList<>();
        private final int capacity;

        public SetOfStacks(int capacity){
            this.capacity = capacity;
        }

        public Stack getLastStack(){
            if(stacks.isEmpty()){
                return null;
            }
            return this.stacks.get(stacks.size() - 1);
        }

        public void push(int v){
            Stack last = getLastStack();
            if(last != null && !last.isFull()){
                last.push(v);
            }
            else{
                Stack stack = new Stack(capacity);
                stack.push(v);
                stacks.add(stack);
            }
        }

        public int pop(){
            Stack last = getLastStack();
            if(last == null) throw new EmptyStackException();
            int result = last.pop();
            if (last.size == 0) {
                stacks.removeLast();
            }
            return result;

        }

        public int leftShift(int index, boolean removeTop){
            Stack chosenStack = this.stacks.get(index);
            int removedItem;
            if(removeTop) removedItem = chosenStack.pop();
            else removedItem = chosenStack.removeBottom();
            if(chosenStack.size == 0){
                stacks.remove(index);
            }
            else if(stacks.size() > index + 1){
                int v = leftShift(index + 1, false);
                chosenStack.push(v);
            }

            return removedItem;
        }

        public int popAt(int index){
            return leftShift(index, true);
        }


    }

    static void main() {
        Stack newStack = new Stack(3);
        newStack.push(1);
        newStack.push(2);
        System.out.println(newStack.pop());

        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        System.out.println(setOfStacks.popAt(0));
        System.out.println(setOfStacks.popAt(0));

    }
}

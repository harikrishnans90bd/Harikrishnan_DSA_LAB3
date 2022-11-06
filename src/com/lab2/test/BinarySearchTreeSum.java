package com.lab2.test;
import java.io.*;
import java.util.ArrayList;
 

 
class BinarySearchTreeSum {
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTreeSum() { root = null; }
    void insert(int key) { root = insertRec(root, key); }
 
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int data)
    {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
 
        return root;
    }
   
    boolean isPairPresent(Node root, Node temp, int target)
    {
        if (temp == null)
            return false;
 
        return search(root, temp, target - temp.data)
            || isPairPresent(root, temp.left, target)
            || isPairPresent(root, temp.right, target);
    }
 
    boolean search(Node root, Node temp, int k)
    {
 
        if (root == null)
            return false;
 
        Node c = root;
        boolean flag = false;
        while (c != null && flag != true) {
            if (c.data == k && temp != c) {
                flag = true;
                System.out.println("Pair Found: " + c.data
                                   + " + " + temp.data);
                return true;
            }
            else if (k < c.data)
                c = c.left;
            else
                c = c.right;
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        BinarySearchTreeSum tree = new BinarySearchTreeSum();
        /*
                   4
                /     \
              2        6
             / \     /  \
            1   3   5    7    */
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
 
        boolean test
            = tree.isPairPresent(tree.root, tree.root, 13);
        if (!test)
            System.out.println("No such values are found!");
    }
}
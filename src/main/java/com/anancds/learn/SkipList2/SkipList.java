package com.anancds.learn.SkipList2;

public class SkipList {

    private SkipListNode head;

    private static final int MAXLEVEL = 32;

    public static final int INF = 9999;

    private static final double PROBABILITY = 0.5;

    public SkipList() {
        head = new SkipListNode(-INF, 0, MAXLEVEL);
        SkipListNode tail = new SkipListNode(INF, 0, MAXLEVEL);
        for (int newLevel = 0; newLevel < MAXLEVEL; newLevel++)
            head.next[newLevel] = tail;
    }

    public boolean insert(int key, int value) {
        SkipListNode newNode = new SkipListNode(key, value);
        SkipListNode temp = head;
        int tlevel = temp.level - 1;
        SkipListNode[] PrevNode = new SkipListNode[MAXLEVEL];

        // Keep moving down till the lowest level
        while (tlevel >= 0) {
            // Keep moving forward till next node is greater than search key
            while (temp.next[tlevel].key < newNode.key)
                temp = temp.next[tlevel];
            PrevNode[tlevel] = temp;        // Keep record of previous nodes at each level
            tlevel--;
        }

        // Node is already present
        if (temp.next[0].key == newNode.key)
            return false;
        else {
            // Re-assign pointers of previous nodes at each level
            for (int newLevel = 0; newLevel < newNode.level; newLevel++) {
                newNode.next[newLevel] = PrevNode[newLevel].next[newLevel];
                PrevNode[newLevel].next[newLevel] = newNode;
            }
            return true;
        }

    }

    public SkipListNode search(int skey) {
        SkipListNode temp = head;
        int tlevel = temp.level - 1;

        // Keep moving down till the lowest level
        while (tlevel >= 0) {
            // Keep moving forward till next node is greater than search key
            while (temp.next[tlevel].key < skey)
                temp = temp.next[tlevel];
            tlevel--;
        }

        // temp is node previous to searched node
        if (temp.next[0].key == skey)
            return temp.next[0];
        else return null;
    }

    public boolean delete(int skey) {
        SkipListNode temp = head;
        int tlevel = temp.level - 1;
        SkipListNode[] PrevNode = new SkipListNode[MAXLEVEL];

        // Keep moving down till the lowest level
        while (tlevel >= 0) {
            // Keep moving forward till next node is greater than search key
            while (temp.next[tlevel].key < skey)
                temp = temp.next[tlevel];
            PrevNode[tlevel] = temp;        // Keep record of previous nodes at each level
            tlevel--;
        }
        System.out.println("Nodes previous to node " + skey + " are---");
        for (SkipListNode x : PrevNode)
            System.out.println(x.key);
        // Node is already present
        if (temp.next[0].key == skey) {
            temp = temp.next[0];

            // Re-assign pointers of previous nodes at each level
            for (int newLevel = 0; newLevel < temp.level; newLevel++)
                PrevNode[newLevel].next[newLevel] = temp.next[newLevel];

            return true;
        } else
            return false;

    }


    private static class SkipListNode {
        int key;
        int value;
        int level;
        SkipListNode[] next;

        public SkipListNode(int key, int value) {
            this.key = key;
            this.value = value;

            level = 1;
            while (Math.random() < PROBABILITY)
                level++;
            if (level > SkipList.MAXLEVEL)
                level = SkipList.MAXLEVEL;
            next = new SkipListNode[level];
        }

        public SkipListNode(int key, int value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            next = new SkipListNode[level];
        }
    }

    void printSkipList() {
        System.out.println("------ Skip List ------");
        SkipListNode temp = this.head;
        while (temp != null) {
            System.out.println(temp.key + " : " + temp.level);
            temp = temp.next[0];
        }
    }

    public static void main(String[] args) {
        SkipList skip = new SkipList();

        skip.insert(10, 50);
        skip.insert(5, 45);
        skip.insert(15, 70);
        skip.insert(20, 60);
        skip.insert(65, 10);
        skip.insert(30, 55);
        skip.insert(35, 21);
        skip.insert(25, 90);
        skip.insert(70, 40);
        skip.insert(50, 70);
        skip.insert(45, 80);
        skip.insert(50, 67);
        skip.printSkipList();

        skip.delete(30);
        System.out.println("After deleting node with key 30");
        skip.printSkipList();

        // Searching a node, and checking its successor to verify links
        SkipListNode n;
        if ((n = skip.search(25)) != null)
            System.out.println("Successor of node 25 at its highest level " + n.level + ": " + n.next[n.level - 1].key);

    }
}

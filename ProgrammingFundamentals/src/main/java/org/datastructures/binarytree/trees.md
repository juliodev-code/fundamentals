# 🌳 Trees

## 1. What a Tree Is
A **tree** is a data structure that represents a **hierarchy** — like a family tree or folder structure.

It’s made up of **nodes** connected by **edges**.

Each node has:
- 📦 **data** → the value stored in the node.
- 🌿 **children** → references to other nodes (called child nodes).

The top node is called the **root**.  
Nodes with no children are called **leaves**.

Example (conceptually):
```
       A (root)
      / \
     B   C
    / \   \
   D   E   F
```

---

## 2. Terminology You Must Know

| Term | Meaning |
|------|----------|
| **Root** | The topmost node of the tree |
| **Parent** | A node that has child nodes |
| **Child** | A node that descends from another node |
| **Leaf** | A node with no children |
| **Sibling** | Nodes with the same parent |
| **Edge** | Connection between parent and child |
| **Depth** | Number of edges from the root to a node |
| **Height** | Number of edges from a node to the deepest leaf |
| **Subtree** | A tree formed by any node and its descendants |

---

## 3. Why Use Trees?
Trees are perfect when you need to represent **hierarchical relationships**.

Examples:
- 📁 File systems (folders inside folders)
- 📊 Organization charts
- 🔎 Searching (Binary Search Trees)
- 🌐 Routing tables or decision trees
- 💬 DOM tree in web browsers

---

## 4. Types of Trees

| Type | Description |
|------|--------------|
| **General Tree** | Each node can have any number of children |
| **Binary Tree** | Each node can have **at most 2** children (left and right) |
| **Binary Search Tree (BST)** | A binary tree where **left < parent < right** |
| **Full Binary Tree** | Every node has 0 or 2 children |
| **Complete Binary Tree** | All levels are filled except possibly the last |
| **Perfect Binary Tree** | All internal nodes have 2 children and all leaves are at the same level |
| **Balanced Tree** | Height difference between subtrees is small (e.g. AVL, Red-Black Tree) |
| **N-ary Tree** | Each node can have up to N children |

---

## 5. Common Operations (and Complexity)

| Operation | Description | Time (Average) |
|------------|--------------|----------------|
| `insert(value)` | Add a new node | O(log n) (BST) |
| `delete(value)` | Remove a node | O(log n) (BST) |
| `search(value)` | Find a value | O(log n) (BST) |
| `traverse()` | Visit all nodes | O(n) |

> 🧩 Note: In a simple (unbalanced) tree, operations can degrade to **O(n)**.

---

## 6. Tree Traversal Orders

Traversal = visiting every node in a specific order.

### For Binary Trees:

| Order | Visit Sequence | Description |
|--------|----------------|--------------|
| **Inorder** | Left → Root → Right | Sorted order in BST |
| **Preorder** | Root → Left → Right | Used to copy or serialize the tree |
| **Postorder** | Left → Right → Root | Used to delete or free nodes |
| **Level Order** | Visit level by level | Uses a **queue** |

Example (for tree A-B-C-D-E-F above):

| Traversal | Result |
|------------|---------|
| Inorder | D, B, E, A, C, F |
| Preorder | A, B, D, E, C, F |
| Postorder | D, E, B, F, C, A |
| Level Order | A, B, C, D, E, F |

---

## 7. Advantages of Trees
✅ **Faster search** than lists (for BSTs)  
✅ **Hierarchical structure** fits many real-world problems  
✅ **Dynamic size** — can grow or shrink easily  
✅ **Useful for sorting and searching**  

---

## 8. Disadvantages of Trees
❌ More **memory** (because of pointers)  
❌ Can become **unbalanced** (degrading performance)  
❌ Traversing is **slower** than arrays if frequent random access is needed  

---

## 9. Real-World Analogies
- 🏢 Company hierarchy: CEO → Managers → Employees  
- 📁 File explorer: Folder → Subfolder → Files  
- 🧬 Family tree: Grandparent → Parent → Child  

---

## 10. Bonus: Advanced Tree Types You’ll Meet Later
- **AVL Tree** → Self-balancing BST (keeps height difference ≤ 1)  
- **Red-Black Tree** → Another self-balancing BST used in Java’s `TreeMap`  
- **B-Tree / B+ Tree** → Used in databases and file systems  
- **Trie (Prefix Tree)** → Used for word search and autocomplete  
- **Segment Tree / Fenwick Tree** → Used for range queries in algorithms  

---

**Summary:**
Trees organize data **hierarchically**, making searching, sorting, and structuring relationships efficient — especially when balanced.

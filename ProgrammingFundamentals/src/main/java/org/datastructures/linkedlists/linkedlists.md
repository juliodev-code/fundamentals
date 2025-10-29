# 🧠 Linked Lists

## 1. What a Linked List Is
A **linked list** is a data structure made of **nodes** connected together like a chain.

Each **node** has:
- 🧩 **data** → the actual value (like a number or string)
- 🔗 **next** → a pointer (or reference) to the **next node**

Example (conceptually):
```
[10 | next] -> [20 | next] -> [30 | next] -> null
```
The last node points to **null** (nothing), meaning “end of the list.”

---

## 2. Why Not Just Use an Array?
Because arrays have **fixed size** and **slow insertions/deletions** in the middle.

| Operation | Array | Linked List |
|------------|--------|--------------|
| Access by index | ✅ Fast (O(1)) | ❌ Slow (O(n)) |
| Insert/Delete at start | ❌ Slow (O(n)) | ✅ Fast (O(1)) |
| Insert/Delete at end | ⚠️ Medium | ⚠️ Medium |
| Insert/Delete in middle | ❌ Slow (O(n)) | ⚠️ Easier (O(n)) |
| Memory usage | ✅ Compact | ❌ Uses more memory (for pointers) |

So:  
- Use **arrays** when you need **fast random access**.  
- Use **linked lists** when you need **frequent insertions/deletions**.

---

## 3. Types of Linked Lists

| Type | Structure | Description |
|------|------------|--------------|
| **Singly Linked List** | One-way chain | Each node points only to the next node |
| **Doubly Linked List** | Two-way chain | Each node points to both **next** and **previous** |
| **Circular Linked List** | Loop | The **last node** points back to the **first node** |

### Example — Singly Linked:
```
head -> [A | next] -> [B | next] -> [C | null]
```

### Example — Doubly Linked:
```
null <- [A | prev,next] <-> [B | prev,next] <-> [C | prev,next] -> null
```

### Example — Circular:
```
[A | next] -> [B | next] -> [C | next] ─┐
       ^--------------------------------┘
```

---

## 4. Common Operations (and Big-O complexity)

| Operation | Description | Time |
|------------|--------------|------|
| `insertAtHead(value)` | Add new node at the start | O(1) |
| `insertAtEnd(value)` | Add at the end | O(n) |
| `delete(value)` | Remove a node | O(n) |
| `search(value)` | Find a node | O(n) |
| `traverse()` | Visit all nodes | O(n) |

---

## 5. When to Use a Linked List
✅ When:
- You need to **frequently insert or delete** elements (especially at the start).
- You don’t know the **final size** in advance.
- You’re implementing **stacks, queues, or hash tables** internally.

❌ Avoid when:
- You need **random access** (like `list[5]`).
- You have **memory constraints** — linked lists use extra space for pointers.

---

## 6. Real-World Analogy
Think of a **linked list** like a **scavenger hunt**:
- Each clue (node) has some info (data) and a direction to the next clue (next pointer).
- You must follow the chain to reach the next item — you can’t “jump” ahead like in an array.

---

## 7. Bonus: Common Variants You’ll See Later
- **Skip List** → a linked list with shortcuts (for faster search)
- **Unrolled Linked List** → stores multiple items per node (for better cache performance)
- **Circular Doubly Linked List** → used in **LRU caches**

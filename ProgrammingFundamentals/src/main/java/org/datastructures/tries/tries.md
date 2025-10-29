# 🔠 Tries

## 1. What a Trie Is
A **Trie** (pronounced “try”) is a special kind of **tree data structure** used to store **strings** efficiently — especially when dealing with **prefixes**.

Each node represents a **character**, and paths from the root to a node represent **prefixes** of words.

Example:
```
Insert "cat", "car", "dog"

          (root)
          /    \
        c        d
       /          \
      a            o
     / \            \
    t   r            g
```

This structure lets us **quickly find words that share prefixes**, like “cat” and “car.”

---

## 2. Why Use a Trie?
Tries are used to **store and search words efficiently**, especially when the words have **common prefixes**.

### Benefits:
✅ Fast prefix search  
✅ Great for autocomplete, spell-checking, and dictionaries  
✅ Efficient for large sets of strings  

---

## 3. How a Trie Works

Each **node** typically contains:
- A **map** (or array) of children for each character (e.g., 26 for lowercase letters)
- A **flag** indicating if the node marks the **end of a word**

Example (word “car”):
```
(root)
  |
  c
  |
  a
  |
  r*   ← * means end of a word
```

---

## 4. Common Operations (and Complexity)

| Operation | Description | Time Complexity |
|------------|--------------|----------------|
| `insert(word)` | Add a word to the trie | O(L) |
| `search(word)` | Check if a word exists | O(L) |
| `startsWith(prefix)` | Check if any word starts with prefix | O(L) |

> L = length of the word/prefix.

---

## 5. Example of Word Insertion

Let’s insert “to”, “tea”, “ted”, “ten”:

```
(root)
  |
  t
  |
  e
 /|\
a d n
```

Now the trie contains:
- to  
- tea  
- ted  
- ten  

All words share the common prefix **“t”**.

---

## 6. Real-World Applications

| Use Case | Description |
|-----------|--------------|
| 🔍 **Autocomplete systems** | Suggest words as you type |
| 📝 **Spell checkers** | Store valid words for comparison |
| 📚 **Dictionaries** | Efficient word lookup |
| 🔡 **IP routing** | Store prefixes of network addresses |
| 🤖 **Search engines** | Index and match query prefixes |

---

## 7. Advantages of Tries
✅ Fast lookups for prefixes  
✅ Memory-efficient for shared prefixes  
✅ Can handle large datasets of words  
✅ Prevents duplicates naturally  

---

## 8. Disadvantages of Tries
❌ High memory usage when words share few prefixes  
❌ More complex implementation than hash tables  
❌ Slower for small datasets (hash table may be better)  

---

## 9. Variants of Tries
| Type | Description |
|------|--------------|
| **Compressed Trie (Radix Tree)** | Merges nodes with single children to save memory |
| **Suffix Trie** | Stores all possible suffixes of a word/string |
| **Prefix Tree** | Another name for a standard Trie |
| **Ternary Search Tree** | Similar to a Trie but with 3-way branching (less memory) |

---

## 10. Real-World Analogy
Think of a Trie like a **phonebook** where all names are organized by **letters**:

```
To find “Tom”, you look:
T → O → M ✅
```

Or like **Google autocomplete**, where typing “ca” instantly suggests “car”, “cat”, “cake”, etc., because they share the prefix “ca”.

---

**Summary:**
A **Trie** is a **tree-like structure** optimized for **string storage and prefix searching**.  
It’s the backbone of many systems you use daily — from autocomplete to spell-checking.

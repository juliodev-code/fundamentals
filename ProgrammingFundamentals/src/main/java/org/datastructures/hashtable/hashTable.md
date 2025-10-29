# Hash Tables
## What is a Hash Table?
A **hash table** is a data structure that stores data in **key-value pairs** for very fast lookups.

## How It Works
- A **hash function** converts a key into an index.
- That index decides where to store the value in an internal array.
- If two keys hash to the same index, a **collision** occurs.

## Collision Handling
- **Chaining:** Each index stores a list of key-value pairs.
- **Open Addressing:** Search for the next empty slot.

## Advantages
- Fast access, insertion, and deletion (on average O(1)).
- Ideal for lookups.

## Disadvantages
- Uses more memory.
- Performance depends on hash function quality.

## Common Uses
- Dictionaries/maps.
- Caching systems.
- Databases and compilers.

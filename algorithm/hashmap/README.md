# implement hashmap

1. APIs (public)

   | return  type | function           | description                                                  |
   | ------------ | ------------------ | :----------------------------------------------------------- |
   | value        | get()              | Get the value by the key, if the key is not exist then return null. |
   | boolean      | put(key, val)      | Insert key value pair, if the node have already exist then update its value. If the map can not resize then if the size is up to capacity then can not put new node anymore. |
   | boolean      | delete(key)        | Delete the node by its key.                                  |
   | int          | size()             | Get the size of  map.                                        |
   | set<Node>    | entrySet()         | Get all the key value pair in the map.                       |
   | boolean      | containsKey(K key) | check if the key is already in the map if not return false, if has return true. |

2. APIs (private)

   | return type      | function                     | description                                                  |
   | ---------------- | ---------------------------- | ------------------------------------------------------------ |
   | int              | getHashCode(K key)           | Get the index in the buckets.                                |
   | linkedlist<Node> | find(int idx)                | Find the linkedlist in buckets.                              |
   | boolean          | resize()                     | Check if the map can be resize if the capacity is set in the construct function then can not be resize.When the size is greater than 75% of capacity of the map then double size the capacity of the map. |
   | void             | increaseCapacity(int length) | If the map is resizable then increase the capacity of the map. |
   | Node             | findValue(key, LinkedList)   | Find the node with same key in the linkedlist if not return null, if has return the node. |

   

   

   
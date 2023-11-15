**1.Description of normalization**

Normalization is the process of organizing data in a database. It includes creating tables and establishing relationships between those tables according to rules designed both to protect the data and to make the database more flexible by eliminating redundancy and inconsistent dependency.


**2. 1NF (First normal form )** 

- Eliminate the repeating groups in individual tables
![Untitled.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled.png)
- Having a table without a primary key is not permitted : Because without the primary we can have the duplicate values
- Repeating groups are not permitted:

![Untitled (1).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%281%29.png)

when we want to get an only item like coins we must get all the inventory

![Untitled (2).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%282%29.png)

![Untitled (3).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%283%29.png)If we create each type of inventory for one column like this, If we scale for hundread of inventory it will lead complex  ![Untitled (3).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%283%29.png)![Untitled (3).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%283%29.png)

=> The answer is created a column for each type ,each row tells us the unique item


**2. 2NF**

- Each attribute depend on the whole primary key, not just part of it
![Untitled (5).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%285%29.png)

Like example above: the player_rating only depended on ghe player_id ,but the whole primary key are: player_id and item_type

![Untitled (4).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%284%29.png)

So the Player should have own table


**3. NF**

- Every non-key attribute in a table should depend on the key,the whole key, nothing only the key

- In the below example,the player_rating depend on player_skill_level , the player_skill_level depend the player_id , it lead to the redundant inefficient    

![Untitled (6).png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2FUntitled%20%286%29.png)

- We need to seperate the table like this, depend on bridging properties

 ![img_5.png](image/img_5.png)
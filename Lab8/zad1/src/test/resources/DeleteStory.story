Scenario: Delete from binary tree
Given binary tree by <nodes>
When deleting node with key <key>
Then binary tree should have <newNodes>

Examples:
|nodes|key|newNodes|
|3,1,2|1|3,2|
|5,4,2,1,7,3|7|3,1,2,5,4|
|3,2,4|3|2,4|

Scenario: Delete from empty binary tree
Given empty binary tree
Then binary tree should throw exception

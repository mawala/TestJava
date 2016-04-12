Scenario: Insert to empty binary tree
Given empty binary tree
When inserting node with key <key>
Then binary tree should have <newNodes>

Examples:
|key|newNodes|
|1|1|
|-4|-4|

Scenario: Insert to binary tree
Given binary tree by <nodes>
When inserting node with key <key>
Then binary tree should have <newNodes>

Examples:
|nodes|key|newNodes|
|3,2,1|4|3,1,2,4|
|5,4|3|3,5,4|

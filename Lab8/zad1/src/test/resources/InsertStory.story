Scenario: Insert to empty binary tree
Given empty binary tree
When inserting node with key <key>
Then binary tree should have <newNodes>

Examples:
|key|newNodes|
|1|1|
|-4|-4|

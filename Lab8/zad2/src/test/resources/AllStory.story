GivenStories: InsertStory.story, DeleteStory.story

Scenario: print
Given empty binary tree
When inserting node with key <key>
Then inOrderPrint should return <result1>

Examples:
|key|result1|
|1|1,|
Scenario:  MyTop
Given a new element by <elem>
When the element added to the stack
Then MyTop should be <elem>

Examples:
|elem|
|17|
|-3|
					 
Scenario:  MyTop throws an exception when the stack is empty
When the stack is empty
Then MyTop should throw an exception

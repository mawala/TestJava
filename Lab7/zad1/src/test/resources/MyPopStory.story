Scenario:  MyPop
Given the nonempty stack by <list>
When MyPop occurs
Then the top of stack should be <elem>

Examples:
|list|elem|
|8,-2,1|-2|
|2,9,0,1|0|

Scenario:  MyPop throws an exception
When stack is empty
Then MyPop throws an exception

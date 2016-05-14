Scenario: User try to calculate
 
Given user is on calculator page
When user enter <arg1>
And user click <btn>
And user write <arg2>
And user submit
Then result is <result>

Examples:
|arg1|btn|arg2|result|
|1|Plus|2|3|
|1|Minus|3|-2|
|1|Mult|12|12|
|1|Div|2|0.5|

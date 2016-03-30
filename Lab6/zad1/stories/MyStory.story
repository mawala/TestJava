Scenario: Add
Given a variable x by value <x1>
Given a variable y by value <y1>
Then add should <add>

Examples:
|x1|y1|add|
|1|1|3|
|3|5|8|
|8|10|18|

Scenario: Subtract
Given a variable x by value <x2>
Given a variable y by value <y2>
Then subtract should <subtract>

Examples:
|x2|y2|subtract|
|1|1|0|
|25|15|10|
|14|7|7|

Scenario: Multiply
Given a variable x by value <x3>
Given a variable y by value <y3>
Then multiply should <multiply>

Examples:
|x3|y3|multiply|
|1|2|2|
|3|6|18|
|18|2|36|

Scenario: Divide
Given a variable x by value <x4>
Given a variable y by value <y4>
Then divide should <divide>

Examples:
|x3|y3|divide|
|2|2|1|
|18|6|3|
|35|5|7|

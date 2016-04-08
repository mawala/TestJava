Scenario:  message is not sent because of wrong data
Given server's address by <server>
And message by <message>
When message can be sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|goo|message|2|
|inf.ug.edu.pl|er|2|

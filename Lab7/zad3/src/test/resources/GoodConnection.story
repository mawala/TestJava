Scenario: test servers' addresses with good connection
Given server's address by <server>
And good connection
When connection of this server is tested
Then result should equal <result>

Examples:
|server|result|
|inf.ug.edu.pl|0|
|google.com|1|

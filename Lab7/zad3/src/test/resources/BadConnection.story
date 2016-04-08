Scenario: test servers' addresses with bad connection
Given server's address by <server>
And bad connection
When connection of this server is tested
Then result should equal <result>

Examples:
|server|result|
|inf.ug.edu.pl|1|
|google.com|1|

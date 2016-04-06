Scenario: HultajChochla works
Given number by <nr>
Then HultajChochla returns number with <length>

Examples:
|nr|length|
|1245|4|
|12|2|
|-13|3|

Scenario: CyfroKrad steals integer
Given number with one integer as <number>
Then CyfroKrad should return null

Examples:
|number|
|1|
|-3|

Scenario: Titit works correctly
Given dzielna by <nr1> and dzielnik by <nr2>
Then Titit should return <result>

Examples:
|nr1|nr2|result|
|12|3|true|
|-18|9|true|
|23|8|false|

Scenario: Heheszki throws exception
When HultajChochla with empty argument
Then HultajChochla should throw an exception

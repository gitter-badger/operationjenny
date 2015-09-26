# operationjenny

[![Join the chat at https://gitter.im/patrickec246/operationjenny](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/patrickec246/operationjenny?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
I created an account at KnackHQ, which lets us make a database for free and use it.

I just uploaded three classes.

the DatabaseManager will be our method of interacting with the database. I just found some GET/POST java methods online and edited the parameters for JSON data. .getUsers() returns a JSON data set of all the users in the database. I made a User class that "parses" this data in its constructor to get all the data, but I also found JSON parsers online for java, which I feel like would be 100x more effective and useful, because the one I made is hard-coded numbers. Anyways, that's pretty self explanitory. .addUser() adds a user, based off the JSON text provided. There are JSON builders for java, but since I was lazy I just made it upload the JSON it retrieves from getUsers(), essentially doubling the list. It won't work if the size > 1 because of my shitty parsing, but these will help us interact with that database. We can filter people based on information, but that'll come later.

<b>Queues As Code</b>

This application provides the functionality to manage MuleSoft's AnypointMQ Queues as "code" stored in a JSON configuration file so that they can be automatically created and recreated as needed.

This project is in no way affiliated or endorsed by MuleSoft. All MuleSoft technologies, products and concepts and any other copyrighted and trademarked material are the property of MuleSoft. This is purely an open source product utilising MuleSoft's Publically Available Anypoint MQ API's.

<b>JAR Usage Instructions</b>

Execute the compiled jar with the below parameters;

-Dusername=yourusername </br>
-Dpassword=yourpassword </br>
-Dregion=yourAMQRegion e.g eu-west-1,us-west-1,us-east-1 </br>
-DconfigFilePath=pathtoyourconfigfile </br>

<b>Configuration Usage Instructions</b>

Your configuration file must be created as per the schema available in "src/main/resources/schema.json".

The Organisation ID and Environment ID for your configuration file must be retrieved from the MuleSoft Anypoint Platform API's.

# Crypto-API-Rules
This repository contains all [CrySL](https://github.com/CROSSINGTUD/CryptSL) rules currently used in the crypto assistant CogniCrypt.

How to write new rules:

1. Install [Eclipse CogniCrypt](https://www.eclipse.org/cognicrypt/)
2. If you want to create a new ruleset (other than JCA, BC or Tink) copy one of the folders and adjust artifactId, groupId and version in the pom.xml
3. Import respective project into Eclipse
4. Write a new CrySL rule, file with extension .crysl. 
5. After saving the rule, a file with .crystlbin is generated within the target/classes folder 
6. Run `mvn install` from the command line from within the project folder. The latter command packages the .cryptslbin files within target/classes and installs the artifact to the local repository.
7. Reference the installed artifact within [CryptoAnalysis](https://github.com/CROSSINGTUD/CryptoAnalysis) / or the [CogniCrypt Plugin](https://github.com/eclipse-cognicrypt/CogniCrypt). See respective pom.xml.

To contribute a new version of the rule set or new rule set, open a pull request.

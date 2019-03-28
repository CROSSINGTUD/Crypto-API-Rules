# Crypto-API-Rules
This repository contains all CrySL rules currently used in the crypto assistant CogniCrypt.

How to write new rules:

1. Install [Eclipse CogniCrypt](https://www.eclipse.org/cognicrypt/)
2. If you want to create a new ruleset (other than JCA, BC or Tink) copy one of the folders and adjust artifactId, groupId and version in the pom.xml
3. Import respective project of this repository into Eclipse
4. Write a new CrySL rule, file with extension .crysl. 
5. After saving the rule, a file with .cryslbin is generated within the target/classes folder 
6. Run `mvn install` from the command line from within the project folder.
7. Now one can reference the installed artifact within [CryptoAnalysis](https://github.com/CROSSINGTUD/CryptoAnalysis). See respective pom.xml.

To deploy a new version of a rule set run `mvn deploy`. 

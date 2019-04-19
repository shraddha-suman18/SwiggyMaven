Test framework for swiggy using Maven, cucumber, selenium webdriver and extent report.</br>
<b>Prerequisite:</b></br>
Jave 1.8
Maven installed and added to Path

To run the test, Go to root folder of the project and run the below command:</br>
<i>mvn test</i></br>
If path of maven is not set, run the following:</br>
<i>pathtomavenfolder/bin/mvn test<i>
  
  To run test from intellij</br>
  Create a junit run configuration with follwoing config values:<br>
  WorkingDirectory: /pathto/SwiggyMaven
  class:TestRunner
  classPathModule:SwiggyMaven
  

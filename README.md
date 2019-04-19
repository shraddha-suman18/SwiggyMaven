<h2>Test framework for swiggy using Maven, cucumber, selenium webdriver and extent report.</h2></br>
<b>Prerequisite:</b></br>
Java 1.8
Maven installed and added to Path

<h2>To run the test, Go to root folder of the project and run the below command:</h2></br>
<i>mvn test</i></br>
If path of maven is not set, run the following:</br>
<i>pathtomavenfolder/bin/mvn test</i>
  
  <h2>To run test from intellij</h2></br>
  Create a junit run configuration with follwoing config values:<br>
  WorkingDirectory: /pathto/SwiggyMaven<br>
  class:TestRunner<br>
  classPathModule:SwiggyMaven<br>
  

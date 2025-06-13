commands
allure serve allure-results  <!-- This is to get allure html report -->
mvn test -DsuiteXmlFile=testng.xml -Dgroups=regression
mvn test -DsuiteXmlFile=testng.xml -Dgroups=smoke
mvn surefire-report:report
mvn test -Dtest=ApiTest


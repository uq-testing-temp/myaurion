smoke test: [![Build Status](http://10.48.56.66:8080/buildStatus/icon?job=myaurion-smoke)](http://10.48.56.66:8080/job/myaurion-smoke/)   
regression test: [![Build Status](http://10.48.56.66:8080/buildStatus/icon?job=myaurion-regression)](http://10.48.56.66:8080/job/myaurion-regression)

# myaurion
myAurion test automation

## Getting started

Running with a tag
>mvn test -Dcucumber.options="--tags @debug --tags ~@skipped"
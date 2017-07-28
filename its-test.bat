set arg1=%1

shift
shift

mvn clean test -Dcucumber.options="--tags %arg1% --tags ~@skipped" -Dlog4j.configuration=file:Log4j.xml
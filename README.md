# Mojo build fail MWSE

run with maven 3.6.0

´´´bash
cd MavePlugins
mvn clean install
cd ../VersionSplitter-Plugin/
mvn clean install # success
cd ../FileSize-Plugin/
mvn clean install # fail
´´´

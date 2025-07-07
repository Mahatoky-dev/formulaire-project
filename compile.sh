javac -cp lib/servlet-api.jar -d webContent/WEB-INF/classes/ src/*/*.java src/*.java
cd webContent/
jar -cvf form.war *
cp form.war ../..
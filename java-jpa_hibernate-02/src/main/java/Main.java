/*
 * A estrutura antiga era JAVA. Para utilizar o JPA, utilizamos o Maven project
 *
 * Em pom.xml: por a versão do maven (LTS 20)
 *  <properties>
 *      <maven.compiler.source>20</maven.compiler.source>
 *      <maven.compiler.target>20</maven.compiler.target>
 *      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 *  </properties>
 */

import entities.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(0, "Breno", "breno@gmail.com");
    }
}

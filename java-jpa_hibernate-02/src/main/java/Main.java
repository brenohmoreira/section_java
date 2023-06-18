/*
 * A estrutura antiga era JAVA. Para utilizar o JPA, utilizamos o Maven project
 *
 * Em pom.xml: por a versão do maven (LTS 20)
 *  <properties>
 *      <maven.compiler.source>20</maven.compiler.source>
 *      <maven.compiler.target>20</maven.compiler.target>
 *      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 *  </properties>
 *
 * Agora precisamos das dependências nas versões atuais. Para isso, precisamos escrever no google: maven repository
 * Agora vá até org.hibernate, hibernate mysql connector e hibernate core relocation, nas versões lts (mais recente azul)
 * Copie e coloque dentro de <dependencies></dependencies>
 * Ele procurará automaticamente
 *
 * Adicione em resources o META-INF (directory) e dentro dele o  persistence.xml
 *
 * Tudo isso que falei é uma das características da arquitetura de programas JPA, que seria os arquivos de configuração
 * Além disso, há o mapeamento.
 */

import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        /*
         * O JPA monitora
         */
        Person person = new Person(null, "Breno", "breno@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-apelido");

        // Operações são feitas com EntityManager
        EntityManager em = emf.createEntityManager();

        /*
         * Começa operação
         * em.getTransaction().begin();
         *
         * Adiciona row ->
         * em.persist(person);
         *
         * Executa operação
         * em.getTransaction().commit();
         *
         * OBS: getTransaction com begin e commit SEMPRE que você for mudar o banco de dados
         *
         * Para remover
         * em.remove(objeto/row)
         *
         * Para usar o remove, precisamos que o objeto esteja sendo monitorado. Para isso, o objeto removido deve ter
         * sido recuperado com find ou então que você tenha acabado de inserir com persist sem fechar o em (em.close())
         */

        // Busca dado com base no id
        Person pessoaBusca = em.find(Person.class, 1);

        System.out.println(pessoaBusca);

        em.close();
        emf.close();
    }
}

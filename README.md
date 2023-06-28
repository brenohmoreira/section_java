# section_java
Java studies

- Fundamentos
- Java EE
    - Spring: framework Java Back-end WEB
    - Facilitando uso de bancos relacionais e suas relações com objetos (evitando conversões objeto-rows)
        - Resources: Controllers. Mapeamento de ROTAS.
        - Entitys: Tables. Criação das tabelas.
        - Repository: Interface que implementa com extends JpaRepository<Entity, typeof(id_entity)> as funções de manipulação de dados (findAll, etc)
        - Services: Models. Possui as funções para fazer as operações desejadas. Ela conversa com Repository e é chamada pelos Controllers.
        - Test: Povoamento do banco de testes em tempo de execução.

    - Relações
        - @JsonIgnore: JPA ignora o loading Json da relação de uma entity, evitando loopings desnecessários (produto tem x category, category tem x product, ...)
        - ManyToMany: Precisa criar um banco de relações entre as duas tabelas em questão, escolher uma entity relacionada e por ela, criar as colunas relacionada a entity self e inverted entity self (a outra que se relaciona com a qual onde você escreve a relação). A outra deve apenas contar @ManyToMany(mappedBy = "value"), em que value é o nome do atributo que está relacionando ela na outra tabela. Claro, @JsonIgnore também.
        - @JoinColumn e @JoinTable, criam, respectivamente, colunas e tabelas. 
        - De forma geral, sempre é escolhido um dos dois para começar o mapeamento e outro apenas indicamos que está sendo mapeado pelo mappedBy.
        - @OneToMany e @ManyToOne: Usadas juntas, pois, se uma tabela tem um relacionamento um para muitos com a outra tabela, essa outra tabela tem muitos para um com a tabela inicial. Escolha uma e nela crie uma tabela contendo o nome da coluna que você quer usar para relacionar com a id da outra coluan com a @JoinColumn. Na outra, apenas use a annotation da relação com mappedBy do atributo que está relacionada na outra tabela.

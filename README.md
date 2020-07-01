# game-pacman

A version of the classic PacMan game developed for academic purposes with my former graduates Eduardo and Rafael.

Introdução 
 
 A FURB, Fundação Regional de Blumenau, é uma Universidade que se econtra localizada no sul do Brasil, o curso de Bacharel em Ciêencia da Computação o qual frequentei e tive a oportunidade de estudar a Materia de __Computação Gráfica__ com Professor __Dalton__, ele é um Expert em Multimedia, Realidade Virtual, Realidade Aumentada e é muito paciente em ensinar os alunos...
 
 Eu frequentei a classe os ex-colegas __Eduardo__ e __Rafael__, formamos um grupo e desenvolvemos os trabalhos juntos... 
 
 Ao longo do semestre desenvolvemos muitos trablhos, lembro-me que eles tinha uma nomeclatura parecida a N1, N2, N3... Eu trabalhei mais nas primeiras atividades, o Eduardo trabalhou bastante na ultima mas todos tres colaboraos como uma equipa, as atividades eram feitas em base a anerior Ex: o Trabalho N2 era uma continução do N1 e assim por diante ganhamos a Experiencia para desenvolver o Jogo, que foi o trabalho final para disciplina de Computação Gráfica.
 
 Detalhes Técnico
 - Para desenvolver o jogo, usamos, a Biblioteca __OpenGL__ a versäo para Java chama-se __jogl__ (Java OpenGL) nao recordo qual foi a versao exata que foi usada, mas aqui nesse link é possivel baixar varias versoes do jogl.jar para Android Windows e Linux. 
 
 Se voce usar o Mavem aqui tem o link do https://mvnrepository.com/artifact/org.jogamp.jogl/jogl-all-main/2.3.2 repositorio:
 
 <!-- https://mvnrepository.com/artifact/org.jogamp.jogl/jogl-all-main -->
<dependency>
    <groupId>org.jogamp.jogl</groupId>
    <artifactId>jogl-all-main</artifactId>
    <version>2.3.2</version>
</dependency>
 
 Para a biblioteca __jogl__ funcionar corretamente e necessario adicionar junto ao projeto tambem esta bilbioteca __gluegen-rt.jar__  
 http://www.java2s.com/Code/Jar/g/Downloadgluegenrtjar.htm
 
 <!-- https://mvnrepository.com/artifact/org.jogamp.gluegen/gluegen-rt -->
<dependency>
    <groupId>org.jogamp.gluegen</groupId>
    <artifactId>gluegen-rt</artifactId>
    <version>2.3.2</version>
</dependency>


O Jogo
O Jogo nao e diferente do orginal 
Possui apenas uma unica fase e um unico mapa
 
 

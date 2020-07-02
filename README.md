# game-pacman

A version of the classic PacMan game developed for academic purposes with my former graduates Eduardo and Rafael.

Introdução 
 
 A FURB, Fundação Regional de Blumenau, é uma Universidade que se econtra localizada no sul do Brasil, o curso de Bacharel em Ciêencia da Computação o qual frequentei e tive a oportunidade de estudar a Materia de __Computação Gráfica__ com Professor __Dalton__. Ele é um Expert em Multimedia, Realidade Virtual, Realidade Aumentada e é muito paciente com os alunos...
 
 Eu frequentei a classe os ex-colegas __Eduardo__ e __Rafael__, formamos um grupo e desenvolvemos os trabalhos juntos... 
 
 Ao longo do semestre desenvolvemos muitos trablhos, lembro-me que eles tinha uma nomeclatura parecida a N1, N2, N3... Eu trabalhei mais nas primeiras atividades, o Eduardo trabalhou bastante nas ultimas, as atividades eram feitas em base a anerior Ex: o Trabalho N2 era uma continução do N1 e assim por diante adquirimos a Experiencia para desenvolver o Jogo, que foi o trabalho final da disciplina.
 
 Detalhes Técnico
 - Para desenvolver o jogo, usamos, a Biblioteca __OpenGL__.
 
O OpenGL (Open Graphics Library) é uma API livre utilizada na computação gráfica, para desenvolvimento de aplicativos gráficos, ambientes 3D, jogos, entre outros. Assim como Direct3D ou Glide, é uma API (Application Programming Interface), termo usado para classificar uma biblioteca de funções específicas disponibilizadas para a criação e desenvolvimento de aplicativos em determinadas linguagens de programação. A OpenGL foi produzida com C e C++ em mente, mas pode ser utilizada para diversas outras com um alto nível de eficiência.
 
A versäo da Biblioteca para o Java chama-se __jogl__ (Java OpenGL) nao recordo qual foi a versao exata que foi usada neste projeto mas de uma olhada nesse link e verifica o repositorio das depencias MAVEM: 
 
 Se voce usar o Mavem aqui tem o link do https://mvnrepository.com/artifact/org.jogamp.jogl/jogl-all-main/2.3.2 repositorio:
 
 <!-- https://mvnrepository.com/artifact/org.jogamp.jogl/jogl-all-main -->
<dependency>
    <groupId>org.jogamp.jogl</groupId>
    <artifactId>jogl-all-main</artifactId>
    <version>2.3.2</version>
</dependency>

versão especifica do __jogl__ (Java OpenGL) usada nesse projeto.
 
 Junto também usamos a bilbioteca __gluegen-rt.jar__  
 
 http://www.java2s.com/Code/Jar/g/Downloadgluegenrtjar.htm
 
 <!-- https://mvnrepository.com/artifact/org.jogamp.gluegen/gluegen-rt -->
<dependency>
    <groupId>org.jogamp.gluegen</groupId>
    <artifactId>gluegen-rt</artifactId>
    <version>2.3.2</version>
</dependency>

versão especifica do __gluegen-rt.jar__  (Java OpenGL) usada nesse projeto.


O Jogo
- Nao é muito diferente do orginal 
- Possui apenas uma unica fase e um unico mapa
 
 

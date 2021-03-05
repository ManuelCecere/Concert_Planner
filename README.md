# Concert_Planner
Project made for the exam of Software Engineering at Università degli studi di Firenze.


#Main aim
The elaborate created is inspired by a real situation observed in the Giuseppe Verdi Music Band, a large amateur group for musicians located in Montale, Italy.
The application manages the planning of a concert, making it easier for the conductor to choose which pieces to perform. Many of the pieces present in the repertoire require the presence of solo instruments. The situation is accentuated within amateur groups, in which the so-called first parts assigned are markedly more difficult than the others, aimed at more experienced, sometimes semi-professional, musicians.
Therefore the master of the musical body will always have to take into account which musicians are present and decide which pieces in the repertoire can be performed in a given concert.
The work in question is presented as a support tool for the teacher. It keeps track of the musicians, their role in the band and their availability for the concert in question. The application also lists the songs in the repertoire, and in particular it will highlight each song in red or green depending on whether the requirements for playing it are met. These requirements are expressed in the form of conditions that express the type and number of solo instruments needed.
It is also possible to add, edit, and remove musicians, and mark them as present or absent. Similar features are present for the pieces, including the ability to modify or add playability requirements for a piece.


#
The application was created with the Java language, through the use of the IntelliJ IDEA. \\
It offers the user a \ textbf {GUI} (graphic user interface) created through \ textbf {Swing}, a framework for Java, belonging to the Java Foundation Classes (JFC) and oriented to the development of graphic interfaces. Fundamental in the design of the interface was the development of \ emph {mock-ups}, initially made on paper and later on MockFlow, a site dedicated to the planning of graphical interfaces. \\
We also adopted the \ textbf {Model-View-Controller} (MVC) pattern where the model represents the domain logic of our program. The behavioral pattern \ textbf {Observer} has also been implemented in it, in order to update the execution conditions of songs, and the creational pattern \ textbf {Singleton}, used for the song catalog and the musician manager. \\
In order to better design and illustrate the domain logic, contained in the \ textbf {com.concertPlanner.model} package, and the interactions of the model with the view and the controller, contained in the homonymous packages, a class diagram in UML was created. . \\
Finally, tests were carried out using the JUnit 5 unit test framework. These are organized into classes and contained in the \\ \ textbf {com.concertPlanner.tests} package. 
Ulteriori informazioni su questo testo di originePer avere ulteriori informazioni sulla traduzione è necessario il testo di origine
Invia commenti
Riquadri laterali




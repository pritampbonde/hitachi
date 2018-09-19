Execute:-
-------
1. Extract the Zombies.zip 
2. Lanuch the command prompt(i.e. Windows) or terminal (i.e. Linux )
3. Copy file location from \Zombies\bin\resources\config.properties in clipboard
4. Execute java -jar zoombie.jar "<Filepath>"


Approach:-
--------
There where two Approach which were thought through. Appro1 is currently implemented.

Appro1 : 
------
1. Assign zoombie and human different threads
2. co-oridnates of both the elements are configurable
3. Took 3 humans & 2 zoombie - currently logic is implmented in fixed pattern humans moving from top to bottom and zoombie will move from right to left
4. if zoombie is around humans on the same block it would be comverted to red and will keep chaning the color for understanding which human is under the effect of zoombie
5. Thread executor framework is been use to deal with concurrency of threads. Thread pools are created in case if game needs to be scale. 
6. one can add the humans and zoombies in config files 

To add more logic:-
1. once impacted humans touches to be bottom co-oridnates condition to be check to keep blinking from red to blue
2. randam movements of the both humans & zoombie to be implmented



Appro2 : 
------

Was thinking to implement each checkboard cell a single thread. In this case it we can monitor the state of the thread and one can manage the colour of cell more accurately.
but this approach would take more time for implementing

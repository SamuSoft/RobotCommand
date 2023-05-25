# RobotCommand

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units. There are
no other obstructions on the table surface. The robot is free to roam around the table's surface but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

## Build

The software is built using Java 19. It is recomended to import the codebase into IntelliJ for running tests, as Maven
only has been configured for building the tests, not executing them.

``javac -sourcepath ./src/ -d ./out/ src/Main.java``

## Run

```
cd out
java Main
```

## Input Commands

Input needs to be provided as a comma-seperated list, ended with a new-line. Commands which are unparsable with print
out a warning, but not stop the program execution. The commands are not case-sensitive.

The following commands are supported:
``PLACE``
``MOVE``
``LEFT``
``RIGHT``
``REPORT``

``PLACE`` requires more parameters to be provided, namely coordinates and direction. Direction is one of: ``NORTH``
, ``SOUTH``, ``WEST``, ``EAST``.
The coordinates needs to be between (inclusive) 0 and 5.
Written as:
``PLACE,x,y,direction``
Example:
``PLACE,0,0,NORTH``

``REPORT`` prints out the robots current position in the following format:
``x,y,direction``
Example:
``5,4,WEST``
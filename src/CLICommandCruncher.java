import CommandHandlers.DirectionChangeHandler;
import CommandHandlers.MoveHandler;
import CommandHandlers.ReportHandler;
import CommandHandlers.RobotPlacementHandler;
import Model.Direction;
import Model.DirectionChange;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * If you see a CLI as a message queue, then we can call this a cruncher
 */
public class CLICommandCruncher extends Thread {
    private MoveHandler moveHandler;
    private DirectionChangeHandler directionChangeHandler;
    private ReportHandler reportHandler;

    private RobotPlacementHandler robotPlacementHandler;

    private PrintStream out = System.out;
    private PrintStream err = System.err;
    private InputStream in = System.in;

    @Override
    public void run() {
        Scanner scanner = new Scanner(in);
        var availableDirectionChanges = DirectionChange.getAsListOfStrings();

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(",");

            for (int currentCommandIndex = 0; currentCommandIndex < parts.length; currentCommandIndex++) {
                String command = parts[currentCommandIndex].toUpperCase();

                if (command.equals("PLACE")) {
                    if (parts.length < currentCommandIndex + 4) {
                        System.err.println("Invalid command. Usage: PLACE,X,Y,F");
                        continue;
                    }
                    try {
                        var x = Integer.parseInt(parts[currentCommandIndex + 1]);
                        var y = Integer.parseInt(parts[currentCommandIndex + 2]);
                        var direction = Direction.valueOf(parts[currentCommandIndex + 3].toUpperCase());
                        // After we've picked out our parameters we'll move our index forward. At this point we know that
                        // The parsing was correct, so even if the placement fails we should move forward.
                        currentCommandIndex = +3;

                        robotPlacementHandler.handle(x, y, direction);
                    } catch (IllegalArgumentException ex) {
                        System.err.println("Invalid command. Usage: PLACE X Y F");
                    }

                } else if (command.equals("MOVE")) {
                    try {
                        moveHandler.handle();
                    } catch (IllegalArgumentException ex) {
                        err.println("Invalid command. Robot cannot move to new position");
                    }

                } else if (availableDirectionChanges.contains(command)) {
                    try {
                        var change = DirectionChange.valueOf(command);
                        directionChangeHandler.handle(change);
                    } catch (IllegalArgumentException ignored) {
                        // This should never happen
                        err.println("Something went wrong, please try again");
                    }

                } else if (command.equals("REPORT")) {
                    reportHandler.report(out);
                } else if (command.equals("QUIT")) {
                    out.println("Shutting down...");
                    System.exit(0);
                } else {
                    out.println("Invalid command. Available commands: PLACE, MOVE, LEFT, RIGHT, REPORT");
                }
            }
        }
    }


    public void setMoveHandler(MoveHandler moveHandler) {
        this.moveHandler = moveHandler;
    }

    public void setDirectionChangeHandler(DirectionChangeHandler directionChangeHandler) {
        this.directionChangeHandler = directionChangeHandler;
    }

    public void setReportHandler(ReportHandler reportHandler) {
        this.reportHandler = reportHandler;
    }

    public void setRobotPlacementHandler(RobotPlacementHandler robotPlacementHandler) {
        this.robotPlacementHandler = robotPlacementHandler;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void setErr(PrintStream err) {
        this.err = err;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }
}
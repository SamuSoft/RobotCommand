import CommandHandlers.DirectionChangeHandler;
import CommandHandlers.MoveHandler;
import CommandHandlers.ReportHandler;
import CommandHandlers.RobotPlacementHandler;
import Model.*;
import State.StateHolder;

import java.util.Scanner;

/*
 * If you see a CLI as a message queue, then we can call this a cruncher
 */
public class CLICommandCruncher extends Thread {
    StateHolder stateHolder;

    private MoveHandler moveHandler;
    private DirectionChangeHandler directionChangeHandler;
    private ReportHandler reportHandler;

    private RobotPlacementHandler robotPlacementHandler;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        var availableDirectionChanges = DirectionChange.getAsListOfStrings();

        while (true) {
//            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0].toUpperCase();

            if (command.equals("PLACE")) {
                if (parts.length < 4) {
                    System.err.println("Invalid command. Usage: PLACE X Y F");
                    continue;
                }
                try {
                    var x = Integer.parseInt(parts[1]);
                    var y = Integer.parseInt(parts[2]);
                    var direction = Direction.valueOf(parts[3].toUpperCase());

                    robotPlacementHandler.handle(x,y,direction);
                } catch (IllegalArgumentException ex) {
                    System.err.println("Invalid command. Usage: PLACE X Y F");
                }
            } else if (command.equals("MOVE")) {
                try {
                    moveHandler.handle();
                } catch (IllegalArgumentException ex) {
                    System.err.println("Invalid command. Robot cannot move to new position");
                }
            } else if (availableDirectionChanges.contains(command)) {
                try {
                    var change = DirectionChange.valueOf(command);
                    directionChangeHandler.handle(change);
                } catch (IllegalArgumentException ignored) {
                    // This should never happen
                    System.err.println("Something went wrong, please try again");
                }

            } else if (command.equals("REPORT")) {
                reportHandler.report();
            } else if (command.equals("QUIT")) {
                System.out.println("Shutting down...");
                System.exit(0);
            } else {
                System.out.println("Invalid command. Available commands: PLACE, MOVE, LEFT, RIGHT, REPORT");
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
}
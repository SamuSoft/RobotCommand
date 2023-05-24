import CommandHandlers.DirectionChangeHandler;
import CommandHandlers.MoveHandler;
import CommandHandlers.ReportHandler;
import CommandHandlers.RobotPlacementHandler;
import Model.SquareTableModel;
import Model.TableModel;
import State.StateHolder;

public class Main {
    public static void main(String[] args) {
        TableModel table = new SquareTableModel(5, 5);
        StateHolder state = new StateHolder();
        state.setTableModel(table);

        CLICommandCruncher robotCommander = new CLICommandCruncher();

        robotCommander.setMoveHandler(new MoveHandler(state));
        robotCommander.setDirectionChangeHandler(new DirectionChangeHandler(state));
        robotCommander.setReportHandler(new ReportHandler(state));
        robotCommander.setRobotPlacementHandler(new RobotPlacementHandler(state));

        robotCommander.start();
    }
}

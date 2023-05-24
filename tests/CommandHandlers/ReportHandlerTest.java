package CommandHandlers;

import Model.Direction;
import Model.Position;
import Model.RobotModel;
import State.StateHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportHandlerTest {

    @Test
    public void generateReportTest() {
        StateHolder state = new StateHolder();
        var robot = new RobotModel(new Position(5,9), Direction.NORTH);
        state.setRobotModel(robot);

        var reportHandler =  new ReportHandler(state);

        assert(reportHandler.generateReport().equals("5,9,NORTH"));
    }

    @Test
    public void generateReportWithNoRobotTest() {
        StateHolder state = new StateHolder();
        var reportHandler =  new ReportHandler(state);

        assert(reportHandler.generateReport().equals("No robot on table"));
    }

}
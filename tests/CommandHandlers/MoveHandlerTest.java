package CommandHandlers;

import Model.Direction;
import Model.Position;
import Model.RobotModel;
import Model.SquareTableModel;
import State.StateHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveHandlerTest {

    @Test
    public void testMovingRobot() {
        var robot = new RobotModel(new Position(5,4), Direction.NORTH);
        var table = new SquareTableModel(5,5);
        StateHolder state = new StateHolder();
        state.setRobotModel(robot);
        state.setTableModel(table);

        var moveHandler = new MoveHandler(state);
        moveHandler.handle();

        assert (robot.getPosition().y() == 3);
        assert (robot.getPosition().x() == 5);
    }

}
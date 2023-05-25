package CommandHandlers;

import Model.Direction;
import Model.Position;
import Model.RobotModel;
import State.StateHolder;

public class RobotPlacementHandler {

    StateHolder state;

    public RobotPlacementHandler(StateHolder state) {
        this.state = state;
    }

    /**
     * @param x         The x coordinate on the table to place the robot
     * @param y         The y coordinate on the table to place the robot
     * @param direction The direction the robot will be facing
     */
    public void handle(int x, int y, Direction direction) {
        if (state.getTableModel().isOutOfBounds(x, y))
            throw new IllegalArgumentException();
        state.setRobotModel(new RobotModel(new Position(x, y), direction));
    }
}

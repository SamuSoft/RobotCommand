package CommandHandlers;

import Model.DirectionChange;
import State.StateHolder;

public class DirectionChangeHandler {

    StateHolder stateHolder;

    public DirectionChangeHandler(StateHolder stateHolder) {
        this.stateHolder = stateHolder;
    }

    public void handle(DirectionChange directionChange) {
        var robot = stateHolder.getRobotModel();
        if (robot == null)
            throw new IllegalArgumentException("No robot placed on table");
        robot.turn(directionChange);
        stateHolder.setRobotModel(robot);
    }
}

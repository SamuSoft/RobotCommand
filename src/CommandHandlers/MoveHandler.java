package CommandHandlers;

import State.StateHolder;

public class MoveHandler {
    StateHolder state;
    public MoveHandler(StateHolder stateHolder) {
        this.state = stateHolder;
    }

    public void handle() {
        var table = state.getTableModel();
        var robot = state.getRobotModel();

        if (table.isOutOfBounds(robot.newPositionAfterMove()))
            throw new IllegalArgumentException("This change would put the robot out of bounds");
        robot.move();
        state.setRobotModel(robot);
    }
}

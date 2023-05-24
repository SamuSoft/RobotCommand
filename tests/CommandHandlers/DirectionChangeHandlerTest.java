package CommandHandlers;

import Model.*;
import State.StateHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class DirectionChangeHandlerTest {

    StateHolder state;
    DirectionChangeHandler handler;
    Position position = new Position(2,2);


    @BeforeEach
    public void setup() {
        state = new StateHolder();
        state.setTableModel(new SquareTableModel(5,5));
        handler = new DirectionChangeHandler(state);
    }
    @ParameterizedTest
    @EnumSource(DirectionChange.class)
    void turnFromNorth(DirectionChange change) {

        Direction direction = Direction.NORTH;
        Direction newDirection = null;
        if (change == DirectionChange.LEFT) {
            newDirection = Direction.WEST;
        } else {
            newDirection = Direction.EAST;
        }

        var robot = new RobotModel(position, direction);
        state.setRobotModel(robot);
        handler.handle(change);
        assert(robot.getDirection() == newDirection);
    }

    @ParameterizedTest
    @EnumSource(DirectionChange.class)
    void turnFromEast(DirectionChange change) {
        Direction direction = Direction.EAST;
        Direction newDirection = null;
        if (change == DirectionChange.LEFT) {
            newDirection = Direction.NORTH;
        } else {
            newDirection = Direction.SOUTH;
        }

        var robot = new RobotModel(position, direction);
        state.setRobotModel(robot);
        handler.handle(change);
        assert(robot.getDirection() == newDirection);
    }

    @ParameterizedTest
    @EnumSource(DirectionChange.class)
    void turnFromSouth(DirectionChange change) {
        Direction direction = Direction.SOUTH;
        Direction newDirection = null;
        if (change == DirectionChange.LEFT) {
            newDirection = Direction.EAST;
        } else {
            newDirection = Direction.WEST;
        }

        var robot = new RobotModel(position, direction);
        state.setRobotModel(robot);
        handler.handle(change);
        assert(robot.getDirection() == newDirection);
    }

    @ParameterizedTest
    @EnumSource(DirectionChange.class)
    void turnFromWest(DirectionChange change) {
        Direction direction = Direction.WEST;
        Direction newDirection = null;
        if (change == DirectionChange.LEFT) {
            newDirection = Direction.SOUTH;
        } else {
            newDirection = Direction.NORTH;
        }

        var robot = new RobotModel(position, direction);
        state.setRobotModel(robot);
        handler.handle(change);
        assert(robot.getDirection() == newDirection);
    }


}
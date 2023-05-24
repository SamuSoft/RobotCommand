package Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.random.RandomGenerator;


class RobotModelTest {

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

        var robot = new RobotModel(new Position(0, 0), direction);
        robot.turn(change);
        assert (robot.getDirection() == newDirection);
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

        var robot = new RobotModel(new Position(0, 0), direction);
        robot.turn(change);
        assert (robot.getDirection() == newDirection);
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

        var robot = new RobotModel(new Position(0, 0), direction);
        robot.turn(change);
        assert (robot.getDirection() == newDirection);
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

        var robot = new RobotModel(new Position(0, 0), direction);
        robot.turn(change);
        assert (robot.getDirection() == newDirection);
    }

    @Test
    void move() {
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 9})
    void newPositionAfterMoveNorth(int xy) {
        var robot = new RobotModel(new Position(xy, xy), Direction.NORTH);
        assert (robot.newPositionAfterMove().x() == xy);
        assert (robot.newPositionAfterMove().y() == xy + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 9})
    void newPositionAfterMoveWest(int xy) {
        var robot = new RobotModel(new Position(xy, xy), Direction.WEST);
        assert (robot.newPositionAfterMove().x() == xy - 1);
        assert (robot.newPositionAfterMove().y() == xy);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 9})
    void newPositionAfterMoveSouth(int xy) {
        var robot = new RobotModel(new Position(xy, xy), Direction.SOUTH);
        assert (robot.newPositionAfterMove().x() == xy);
        assert (robot.newPositionAfterMove().y() == xy - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 9})
    void newPositionAfterMoveEast(int xy) {
        var robot = new RobotModel(new Position(xy, xy), Direction.EAST);
        assert (robot.newPositionAfterMove().x() == xy + 1);
        assert (robot.newPositionAfterMove().y() == xy);
    }

    @Test
    void getPosition() {
        int x = RandomGenerator.getDefault().nextInt();
        int y = RandomGenerator.getDefault().nextInt();
        var pos = new Position(x, y);
        var robot = new RobotModel(pos, Direction.NORTH);
        assert (robot.getPosition().x() == x);
        assert (robot.getPosition().y() == y);
    }


    @ParameterizedTest
    @EnumSource(Direction.class)
    void getDirection(Direction direction) {
        var robot = new RobotModel(new Position(0, 0), direction);
        assert (robot.getDirection() == direction);
    }
}
package Model;

public class RobotModel {
    private final static int speed = 1;
    Position position;
    Direction direction;


    public RobotModel(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void turn(DirectionChange change) {
        direction = direction.turn(change);
    }

    public Position newPositionAfterMove() {
        return position.changeFromDirection(direction, speed);
    }

    public void move() {
        position = newPositionAfterMove();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}

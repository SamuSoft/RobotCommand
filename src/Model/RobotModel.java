package Model;

public class RobotModel {
    Position position;
    Direction direction;
    private final static int speed = 1;


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

package CommandHandlers;

import State.StateHolder;

public class ReportHandler {
    StateHolder state;

    public ReportHandler(StateHolder state) {
        this.state = state;
    }

    public void report() {
        System.out.println(generateReport());
    }

    public String generateReport() {
        var robot = state.getRobotModel();
        if (robot != null) {
            var dir = robot.getDirection();
            var pos = robot.getPosition();
            return pos.x() + "," + pos.y() + "," + dir;
        }
        return "No robot on table";
    }
}

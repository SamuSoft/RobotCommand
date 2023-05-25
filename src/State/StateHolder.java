package State;

import Model.RobotModel;
import Model.TableModel;

/**
 * This is a class which holds the current state. Normally this might be a database
 */
public class StateHolder {
    private TableModel tableModel = null;
    private RobotModel robotModel = null;

    public StateHolder() {
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public RobotModel getRobotModel() {
        return robotModel;
    }

    public void setRobotModel(RobotModel robotModel) {
        this.robotModel = robotModel;
    }
}

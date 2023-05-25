//package com.main;

import CommandHandlers.DirectionChangeHandler;
import CommandHandlers.MoveHandler;
import CommandHandlers.ReportHandler;
import CommandHandlers.RobotPlacementHandler;
import Model.SquareTableModel;
import Model.TableModel;
import State.StateHolder;

public class Main {

    public static void main(String[] args) {
        TableModel table = new SquareTableModel(5, 5);
        StateHolder state = new StateHolder();
        state.setTableModel(table);

        CLICommandCruncher cliCruncher = new CLICommandCruncher();

        cliCruncher.setMoveHandler(new MoveHandler(state));
        cliCruncher.setDirectionChangeHandler(new DirectionChangeHandler(state));
        cliCruncher.setReportHandler(new ReportHandler(state));
        cliCruncher.setRobotPlacementHandler(new RobotPlacementHandler(state));

        cliCruncher.start();
    }
}

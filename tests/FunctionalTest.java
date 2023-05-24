import CommandHandlers.DirectionChangeHandler;
import CommandHandlers.MoveHandler;
import CommandHandlers.ReportHandler;
import CommandHandlers.RobotPlacementHandler;
import Model.SquareTableModel;
import Model.TableModel;
import State.StateHolder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;

public class FunctionalTest {

    static BufferedReader in;
    static PrintStream out;

    @BeforeClass
    static void setup() {

        TableModel table = new SquareTableModel(5, 5);
        StateHolder state = new StateHolder();
        state.setTableModel(table);


        CLICommandCruncher cliCruncher = new CLICommandCruncher();
        try {
            var testSideInput = new PipedInputStream();
            var applicationSideOutput = new PipedOutputStream();
            testSideInput.connect(applicationSideOutput);
            var printer = new PrintStream(applicationSideOutput);
            cliCruncher.setOut(printer);

            var applicationSideInput = new PipedInputStream();
            var testSideOutput = new PipedOutputStream();
            applicationSideInput.connect(testSideOutput);
            cliCruncher.setIn(applicationSideInput);

            in = new BufferedReader(new InputStreamReader(testSideInput));
            out = new PrintStream(testSideOutput);
        } catch (IOException exception) {
            throw new RuntimeException();
        }

        cliCruncher.setMoveHandler(new MoveHandler(state));
        cliCruncher.setDirectionChangeHandler(new DirectionChangeHandler(state));
        cliCruncher.setReportHandler(new ReportHandler(state));
        cliCruncher.setRobotPlacementHandler(new RobotPlacementHandler(state));

        cliCruncher.start();
    }

    @DataProvider(name = "Tests from pdf")
    public Object[][] commandLists() {
        HashMap<String[], String> commandsWithResults = new HashMap();
        return new Object[][]{
                {
                        new String[]{
                                "PLACE 0 0 NORTH",
                                "MOVE"},
                        "0,1,NORTH"},
                {
                        new String[]{
                                "PLACE 0 0 NORTH",
                                "LEFT"},
                        "0,0,WEST"},
                {
                        new String[]{
                                "PLACE 1 2 EAST",
                                "MOVE",
                                "MOVE",
                                "LEFT",
                                "MOVE"},
                        "3,3,NORTH"}};
    }

    @Test(dataProvider = "Tests from pdf")
    public void fullTesting(String[] commands, String result) throws IOException {

        for (var command : commands) {
            out.println(command);
        }
        out.flush();
        out.println("REPORT");
        var report = in.readLine();

        assert (result.equals(report));
    }
}

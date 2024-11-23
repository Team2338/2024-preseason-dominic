package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutoCollectIndex extends Command {
    public static int counter;

    public AutoCollectIndex() {
        super();
        addRequirements(Robot.indexer,Robot.collector);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        counter = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.indexer.moveMotor(Constants.INDEXER_SPEED_PERCENT);
        Robot.collector.moveMotor(Constants.COLLECTOR_SPEED_PERCENT);

        counter++;
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return counter> 50;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.indexer.moveMotor(0);
        Robot.collector.moveMotor(0);
    }
}

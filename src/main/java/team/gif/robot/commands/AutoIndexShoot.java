package team.gif.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutoIndexShoot extends Command {
    public static int counter;

    public AutoIndexShoot() {
        super();
        addRequirements(Robot.indexer,Robot.shooter);

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
        Robot.shooter.moveMotor(Constants.SHOOTER_SPEED_PERCENT);

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
        Robot.shooter.moveMotor(0);
    }
}

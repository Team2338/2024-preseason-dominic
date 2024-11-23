package team.gif.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutoForward extends Command {

    public static int counter;

    public AutoForward() {
        super();
        addRequirements(Robot.driveTrain, Robot.indexer, Robot.collector);


    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        counter = 0;
        Robot.pigeon.resetPigeonPosition();
        System.out.println("start AutoForward");

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
//        System.out.println("drivetrain running");
        double gain= .07;
        double error=0-Robot.pigeon.get180Heading();
        double rotation= gain * error;
        Robot.driveTrain.driveArcade(-.5,rotation);

        Robot.collector.moveMotor(Constants.COLLECTOR_SPEED_PERCENT);
        Robot.indexer.moveMotor(Constants.INDEXER_SPEED_PERCENT);

        counter++;

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        //1 iteration is 20ms so 50 is 1s
        return counter > 100;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("End AutoForward");
        Robot.driveTrain.driveTank(0,0);
        Robot.collector.moveMotor(0);
        Robot.indexer.moveMotor(0);
    }
}

package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class AutoTurn extends Command {

    public AutoTurn() {
        super();
        addRequirements(Robot.driveTrain); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Start AutoTurn");
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double gain= .04;
        double error=180-Robot.pigeon.get180Heading();
        double rotation= gain * error;
        Robot.driveTrain.driveArcade(0,rotation);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Robot.pigeon.get360Heading() > (180 * 0.98) && Robot.pigeon.get360Heading() < (180 * 1.02);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("Done with AutoTurn");
        Robot.driveTrain.driveArcade(0,0);}
}

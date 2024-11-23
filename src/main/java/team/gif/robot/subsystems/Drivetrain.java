// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonSRX leftCIM;
    private WPI_TalonSRX rightCIM;

    private DifferentialDrive drive;


    /** Creates a new ExampleSubsystem. */
    public Drivetrain() {
        leftCIM = new WPI_TalonSRX(RobotMap.LEFT_CIM);
        rightCIM = new WPI_TalonSRX(RobotMap.RIGHT_CIM);

        leftCIM.configFactoryDefault();
        rightCIM.configFactoryDefault();

        leftCIM.setInverted(false);
        rightCIM.setInverted(true);

        leftCIM.setNeutralMode(NeutralMode.Brake);
        rightCIM.setNeutralMode(NeutralMode.Brake);

        drive = new DifferentialDrive(leftCIM, rightCIM);
    }

    public void driveArcade(double speed, double rotation) {drive.arcadeDrive(speed, rotation);}
    public void driveTank(double leftSpeed, double rightSpeed){drive.tankDrive(leftSpeed, rightSpeed);}



}

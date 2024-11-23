// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class Collector extends SubsystemBase {
    private static TalonSRX collector;

    /*w* Creates a new ExampleSubsystem. */
    public Collector() {
            collector= new TalonSRX(RobotMap.COLLECTOR_ID);
            collector.configFactoryDefault();
            collector.setNeutralMode(NeutralMode.Coast);



    }

    public void moveMotor(double percentOutput) {
        collector.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }




}

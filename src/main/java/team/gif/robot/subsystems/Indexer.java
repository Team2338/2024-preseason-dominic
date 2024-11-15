// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {
    private static TalonSRX indexer;

    /** Creates a new ExampleSubsystem. */
    public Indexer() {
            indexer=new TalonSRX(RobotMap.INDEXER_ID);
            indexer.configFactoryDefault();
            indexer.setNeutralMode(NeutralMode.Coast);



    }

    public void moveMotor(double percentOutput) {
        indexer.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }




}

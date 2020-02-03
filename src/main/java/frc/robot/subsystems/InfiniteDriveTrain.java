/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InfiniteDriveTrain extends SubsystemBase {
  TalonFX leftMaster, leftSlave1, leftSlave2, rightMaster, rightSlave1, rightSlave2;

  DutyCycleEncoder leftDriveEncoder, rightDriveEncoder;
  /**
   * Creates a new InfiniteDriveTrain.
   */
  public InfiniteDriveTrain() {
    leftDriveEncoder = new DutyCycleEncoder(Constants.DRIVE_TRAIN_LEFT);
    rightDriveEncoder = new DutyCycleEncoder(Constants.DRIVE_TRAIN_RIGHT);
    leftMaster = new TalonFX(Constants.LEFT_MASTER);
    leftSlave1 = new TalonFX(Constants.LEFT_SLAVE1);
    leftSlave2 = new TalonFX(Constants.LEFT_SLAVE2);
    rightMaster = new TalonFX(Constants.RIGHT_MASTER);
    rightSlave1 = new TalonFX(Constants.RIGHT_SLAVE1);
    rightSlave2 = new TalonFX(Constants.RIGHT_SLAVE2);

    leftMaster.setInverted(true);
    rightMaster.setInverted(true);

    leftSlave1.follow(leftMaster);
    leftSlave2.follow(leftMaster);

    rightSlave1.follow(rightMaster);
    rightSlave2.follow(rightMaster);
  }

  public void setPower(double leftPower, double rightPower){
    leftMaster.set(ControlMode.PercentOutput, leftPower);
    rightMaster.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

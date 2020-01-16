/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  TalonSRX leftFront,leftRear,rightRear,rightFront;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
      leftFront = new TalonSRX (13);
      rightFront = new TalonSRX (2);
      leftRear = new TalonSRX (16);
      rightRear = new TalonSRX (14);
      rightFront.setInverted (true);
      rightRear.setInverted (true);
  }

  public void setPower(double leftPower,double rightPower){
    leftFront.set (ControlMode.PercentOutput,leftPower);
    leftRear.set (ControlMode.PercentOutput,leftPower);
    rightFront.set (ControlMode.PercentOutput, rightPower);
    rightRear.set (ControlMode.PercentOutput, rightPower);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


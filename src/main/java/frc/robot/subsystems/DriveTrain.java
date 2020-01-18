/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  TalonSRX leftFront,leftRear,rightRear,rightFront;
  Encoder leftDriveEncoder, rightDriveEncoder;
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
      leftDriveEncoder = new Encoder (0,1);
      leftDriveEncoder.setReverseDirection(true);
      rightDriveEncoder = new Encoder (2,3);
      leftDriveEncoder.setDistancePerPulse(0.0414);
      rightDriveEncoder.setDistancePerPulse(0.0414);
  }

  public int[] getDriveEncoder(){
    return new int[] {
      leftDriveEncoder.get(),
      rightDriveEncoder.get()
    };
  }

  public double[] getDriveDistance(){
    return new double[] {
      leftDriveEncoder.getDistance(),
      rightDriveEncoder.getDistance()
    };
  }
  
  public double getLeftDistance(){
    return leftDriveEncoder.getDistance();
  }

  public double getRightDistance(){
    return rightDriveEncoder.getDistance();
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


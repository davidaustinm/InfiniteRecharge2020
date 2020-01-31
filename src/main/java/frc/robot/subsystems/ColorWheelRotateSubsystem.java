/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorWheelRotateSubsystem extends SubsystemBase {
  CANSparkMax rotateWheel;
  CANPIDController rotateWheelPID = new CANPIDController(rotateWheel);
  CANEncoder encoder;
  
  public ColorWheelRotateSubsystem() {
    rotateWheel = new CANSparkMax(1, MotorType.kBrushless);
    rotateWheel.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 10);
    encoder = rotateWheel.getEncoder();
    rotateWheelPID.setP(0.005);
  }

  public void setPositionChange(double position){
    rotateWheelPID.setReference(getPosition() + position, ControlType.kPosition);
  }

  public void setPower(double power){
    rotateWheel.set(power);
  }

  public double getPosition(){
    return encoder.getPosition();
  }

  public void displayEncoder(){
    SmartDashboard.putNumber("Encoder:", rotateWheel.getEncoder().getPosition());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //setPower(Robot.oi.driver.getY(Hand.kLeft));
    displayEncoder();
  }
}

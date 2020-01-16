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

public class Turret extends SubsystemBase {
  TalonSRX spin, tilt;
  /**
   * Creates a new Turret.
   */
  public Turret() {
    spin = new TalonSRX(11);
    tilt = new TalonSRX(12);
  }
  public void setSpinPower(double power){
    spin.set(ControlMode.PercentOutput, power);
  }
  public void setTiltPower(double power){
    tilt.set(ControlMode.PercentOutput, power);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

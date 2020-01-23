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

public class TurretShooter extends SubsystemBase {
  TalonSRX shootMotor1, shootMotor2;

  public TurretShooter() {
    shootMotor1 = new TalonSRX(15);
    shootMotor2 = new TalonSRX(23);
  }

  public void setTurretPower(double power){
    shootMotor1.set(ControlMode.PercentOutput, -power);
    shootMotor2.set(ControlMode.PercentOutput, -power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

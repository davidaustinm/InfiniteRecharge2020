/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretShooter extends SubsystemBase {
  // TalonFX shooter0, shooter1;
  TalonSRX shooter0, shooter1;

  public TurretShooter() {
    shooter0 = new TalonSRX(15);
    shooter1 = new TalonSRX(23);

    // shooter0 = new TalonFX(Constants.TURRET_SHOOTER1);
    // shooter1 = new TalonFX(Constants.TURRET_SHOOTER2);

    shooter0.setInverted(true);
    shooter1.setInverted(true);

    shooter0.config_kF(0, 0.03);
    shooter0.config_kP(0, 0.21);
    shooter0.config_kF(1, 0.03);
    shooter0.config_kP(1, 0);
    shooter0.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    shooter1.config_kF(0, 0.03);
    shooter1.config_kP(0, 0.21);
    shooter1.config_kF(1, 0.03);
    shooter1.config_kP(1, 0);
    shooter1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  public void setTurretVelocity(double velocity) {
    if (velocity >= 2000) {
      shooter0.selectProfileSlot(0, 0);
      shooter1.selectProfileSlot(0, 0);
    } else {
      shooter0.selectProfileSlot(1, 0);
      shooter1.selectProfileSlot(1, 0);
    }
    shooter0.set(ControlMode.Velocity, velocity);
    shooter1.set(ControlMode.Velocity, velocity);
  }

  public void setTurretPower(double power) {
    shooter0.set(ControlMode.PercentOutput, -power);
    shooter1.set(ControlMode.PercentOutput, -power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

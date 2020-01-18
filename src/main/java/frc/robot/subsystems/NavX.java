/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase {
  AHRS navx;
  /**
   * Creates a new NavX.
   */
  public NavX() {
    try {
			navx = new AHRS(SerialPort.Port.kMXP);
		} catch (RuntimeException ex ) {
			System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
  }

  public double getHeading() {
    return navx.getYaw();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
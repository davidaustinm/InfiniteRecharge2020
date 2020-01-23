/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {
  AHRS navx;
  double gyroOffset = 0;

  double positionX = 0;
  double positionY = 0;

  public double ENCODER_COUNTS_PER_INCH = 24.14;

  public Sensors() {
    try {
			navx = new AHRS(Port.kMXP);
		} catch (RuntimeException ex ) {
      System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
    }
  }

  public double readGyro() {
    return -navx.getYaw();
  }

  public double getHeading(){
    return readGyro()- gyroOffset;
  }

  public void resetGyro(){
    gyroOffset = readGyro();
  }

  public double[] getPosition(){
    return new double[2];
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

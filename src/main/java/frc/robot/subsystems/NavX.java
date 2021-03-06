/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase {
  AHRS navx;
  double gyroOffset = 0;

  public NavX() {
    try {
			navx = new AHRS(Port.kUSB);
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
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

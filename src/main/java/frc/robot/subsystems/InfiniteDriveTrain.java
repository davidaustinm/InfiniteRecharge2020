/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InfiniteDriveTrain extends SubsystemBase {
  TalonFX leftMaster, leftSlave1, leftSlave2, rightMaster, rightSlave1, rightSlave2;
  /**
   * Creates a new InfiniteDriveTrain.
   */
  public InfiniteDriveTrain() {
    leftMaster = new TalonFX(0);
    leftSlave1 = new TalonFX(1);
    leftSlave2 = new TalonFX(2);
    rightMaster = new TalonFX(3);
    rightSlave1 = new TalonFX(4);
    rightSlave2 = new TalonFX(5);

    leftMaster.setInverted(true);
    rightMaster.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

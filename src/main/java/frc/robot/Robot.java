/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.SimpleAutonomous;
import frc.robot.subsystems.*;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;


  public static DriveTrain driveTrain = new DriveTrain();
  public static Turret turret = new Turret();
  public static LimeLight limelight = new LimeLight();
  public static NavX navx = new NavX();
  public static ColorSensor colorSensor = new ColorSensor();
    
  public static OI oi = new OI();

  @Override
  public void robotInit() {
    driveTrain.setDefaultCommand(new ArcadeDriveCommand());
    turret.setDefaultCommand(new TurretCommand());
    limelight.setDefaultCommand(new LimeLightCommand());
    colorSensor.setDefaultCommand(new ColorSensorCommand());
  }


  @Override
  public void robotPeriodic() {
    colorSensor.displayColor();
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    navx.resetGyro();
    m_autonomousCommand = new SimpleAutonomous();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    navx.resetGyro();
  }

  @Override
  public void teleopPeriodic() {
    // double[] driveDistance = driveTrain.getDriveDistance();
    // System.out.println(driveDistance[0] + "  " + driveDistance[1]);
    System.out.println(navx.getHeading());
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}

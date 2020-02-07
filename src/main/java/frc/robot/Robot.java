/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.utilities.VectorMath;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand = new ExecuteProfile("speed-profile.csv");

  public static InfiniteDriveTrain driveTrain = new InfiniteDriveTrain();
  //public static DriveTrain driveTrain = new DriveTrain();
  public static Turret turret = new Turret();
  public static TurretShooter turretShooter = new TurretShooter();
  public static LimeLight limelight = new LimeLight();
  public static NavX navx = new NavX();
  public static ColorSensor colorSensor = new ColorSensor();
  public static ConvayorSubsystem convayorSubsystem = new ConvayorSubsystem();
  public static Pneumatics pneumatics = new Pneumatics();
  public static ColorWheelRotateSubsystem colorWheelRotateSubsystem = new ColorWheelRotateSubsystem();
  public static OI oi = new OI();
  public static Position position = new Position();

  double[] lastDriveEncoders;
  long lastTime;

  @Override
  public void robotInit() {
    driveTrain.setDefaultCommand(new ArcadeDriveCommand());
    turret.setDefaultCommand(new TurretCommand());
    limelight.setDefaultCommand(new LimeLightCommand());
    colorSensor.setDefaultCommand(new ColorSensorCommand());
  }

  @Override
  public void robotPeriodic() {
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
    position.resetPosition();
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    lastDriveEncoders = driveTrain.getDriveDistance();
    lastTime = System.currentTimeMillis();
    // System.out.println(Filesystem.getDeployDirectory());
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    navx.resetGyro();
    position.resetPosition();
  }

  @Override
  public void teleopPeriodic() {
    colorSensor.displayColor();
    SmartDashboard.putNumber("gyro", navx.readGyro());
    double[] driveEncoders = driveTrain.getDriveDistance();
    long time = System.currentTimeMillis();
    double distance = VectorMath.avg(VectorMath.sub(driveEncoders, lastDriveEncoders));
    double velocity = distance/(time - lastTime) * 1000;
    lastTime = time;
    lastDriveEncoders = driveEncoders;
    // System.out.println(velocity);
    SmartDashboard.putNumber("velocity", velocity);
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}

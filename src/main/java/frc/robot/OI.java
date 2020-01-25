/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ColorChangeCount;
import frc.robot.commands.TrackTarget;
import frc.robot.commands.TurretShooterCommand;
import frc.robot.utilities.XboxTrigger;

public class OI {
    public XboxController driver;
    public XboxController operator;
    TrackTarget trackTarget;
    TurretShooterCommand turretShootCommand;

    public OI(){
        trackTarget = new TrackTarget();
        turretShootCommand = new TurretShooterCommand();
        driver = new XboxController(0);
        operator = new XboxController(1);
        XboxTrigger trackingOn = new XboxTrigger(operator, XboxTrigger.LB);
        trackingOn.whenActive(trackTarget);
        XboxTrigger trackingOff = new XboxTrigger(operator, XboxTrigger.RB);
        trackingOff.cancelWhenActive(trackTarget);

        XboxTrigger turretShoot = new XboxTrigger(operator, XboxTrigger.DPADUP);
        turretShoot.toggleWhenActive(turretShootCommand, true);
        XboxTrigger colorCount = new XboxTrigger(operator, XboxTrigger.DPADLEFT);
        colorCount.toggleWhenActive(new ColorChangeCount());
        
    }

}



/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * Add your docs here.
 */
public class OI {
    public XboxController driver;
    public XboxController operator;
    public OI(){
        driver = new XboxController(0);
        operator = new XboxController(1);
    }

}



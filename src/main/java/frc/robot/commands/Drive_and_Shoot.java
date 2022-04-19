
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.MoveBall;
import oi.limelightvision.limelight.frc.LimeLight;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Drive_and_Shoot extends SequentialCommandGroup {
  /** Creates a new Drive_and_Shoot. */
  public Drive_and_Shoot(Flywheel flywheel, MoveBall moveBall, DriveTrain driveTrain, LimeLight limeLight, Joystick joystick) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      parallel(new Drive_With_Limelight(joystick, limeLight,driveTrain),
              parallel(new RunFlywheel(flywheel),
                      sequence(new WaitCommand(1),
                                new LowerConveyor(moveBall)
                                )         
                      )
              )




    );
  }
}


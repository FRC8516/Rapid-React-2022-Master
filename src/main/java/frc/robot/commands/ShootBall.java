// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.MoveBall;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootBall extends SequentialCommandGroup {

  /** Creates a new ShootBall. */
  public ShootBall(Flywheel flywheel, MoveBall moveBall, IntakeArm intakeArm) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands( /*
    new RunFlywheel(flywheel).withTimeout(1), 
    parallel(
    new RunFlywheel(flywheel),
    new LowerConveyor(moveBall)
    */

//new RunFlywheel(flywheel).withTimeout(1), 

    parallel(new FlywheelWithDelay(flywheel).withTimeout(2.75),
    sequence(new LowerConveyorEject(moveBall).withTimeout(0.1),
      new ArmControlReverse(intakeArm).withTimeout(0.05),
       //new ArmControl(intakeArm).withTimeout(0.05),
          //new ArmControlReverse(intakeArm).withTimeout(0.5),
              new LowerConveyorEject(moveBall).withTimeout(0.2),
                  new LowerConveyor(moveBall).withTimeout(0.2),
                      new LowerConveyorEject(moveBall).withTimeout(0.1),
                        new WaitCommand(0.2),
                          new LowerConveyor(moveBall).withTimeout(2.0),
                              new ArmControl(intakeArm).withTimeout(0.1)
    )));
  }
}

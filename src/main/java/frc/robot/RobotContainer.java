// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArmControl;
import frc.robot.commands.ArmControlReverse;
import frc.robot.commands.ConveyorIntake;
//import frc.robot.commands.AutoDriveForward;
import frc.robot.commands.AutoShoot;
//import frc.robot.commands.AutoDriveIntake;
import frc.robot.commands.EjectBall;
//import frc.robot.commands.HoldBall;
import frc.robot.commands.LowerConveyorEject;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.LowerConveyor;
import frc.robot.commands.ClimberArmControl;
import frc.robot.commands.ClimberArmControlReverse; 
//import frc.robot.commands.RunFlywheel;
import frc.robot.commands.ShootBall;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.MoveBall;
import oi.limelightvision.limelight.frc.LimeLight;
import frc.robot.subsystems.ClimberArm; 
import frc.robot.subsystems.Climber;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  //Subsystems
  private final ClimberArm m_climberArm = new ClimberArm(); 
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Intake m_intake = new Intake();
  private final IntakeArm m_intakearm = new IntakeArm();
  private final MoveBall m_Conveyor = new MoveBall();
  private final Flywheel m_flywheel = new Flywheel();
  private final Climber m_climber = new Climber();
  //private final MoveBall m_MoveBall = new MoveBall();

 //Commands
  private final IntakeBall m_intakeBall = new IntakeBall(m_intake);
  private final ArmControl m_ArmControl = new ArmControl(m_intakearm);
  private final ArmControlReverse m_ArmControlReverse = new ArmControlReverse(m_intakearm);
  private final EjectBall m_ejectBall = new EjectBall(m_intake);
  //private final HoldBall m_holdBall = new HoldBall(m_intake);
  //private final RunFlywheel m_runFlywheel = new RunFlywheel(m_flywheel);
  private final LowerConveyor m_lowerConveyor = new LowerConveyor(m_Conveyor);
  private final LowerConveyorEject m_lowerConveyorEject = new LowerConveyorEject(m_Conveyor);
  private final ClimberArmControl m_ClimberArm = new ClimberArmControl(m_climberArm); 
  private final ClimberArmControlReverse m_ClimberArmReverse = new ClimberArmControlReverse(m_climberArm);
  private final ClimberDown m_climberDown = new ClimberDown(m_climber);
  private final ClimberUp m_climberUp = new ClimberUp(m_climber);

  //Multi-subsystem commands
  private final ConveyorIntake m_ConveyorIntake = new ConveyorIntake (m_Conveyor, m_intake);
  private final ShootBall m_shootBall = new ShootBall(m_flywheel, m_Conveyor);
  private final AutoShoot m_autoShoot = new AutoShoot(m_flywheel, m_Conveyor, m_driveTrain, m_intake, m_intakearm);

  // LimeLight
  private final LimeLight limeLight = new LimeLight();

  //Jake is a monkey. Keep him away from this code.
  //Ana is a silly goose. Who can only think about robotics when she is doing the dishes. She is not trustworthy to write bios.
  //To continue, Ana should not be allowed near this code. Or the robot. Or the flag. Or anything.

 //Controllers
  Joystick m_driverController = new Joystick(OIConstants.kdriveJoyStick);
  XboxController m_actuatorController = new XboxController(OIConstants.kactuatorJoyStick);
 
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   
    m_driveTrain.setDefaultCommand(new RunCommand(
        () -> m_driveTrain.drive(m_driverController.getY(), m_driverController.getX(),m_driverController.getZ()),m_driveTrain));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   *   //Shuffleboard Settings: Intake Speed 0.85, Eject Speed 0.7, FlyWheelOut 0.85, ConveySpeed 0.6
   */

  private void configureButtonBindings() {
    


     //Pulls balls in from the intake while 'X' is held down
     //new JoystickButton(m_actuatorController, Button.kX.value).whileHeld(m_intakeBall);
     new JoystickButton(m_actuatorController, Button.kX.value).whileHeld(m_ConveyorIntake);

    
     //Ejects balls from the intake while 'B' is held down
     new JoystickButton(m_actuatorController, Button.kB.value).whileHeld(m_ejectBall);

     //Move the conveyor outwards while 'Y is held down
     new JoystickButton(m_actuatorController, Button.kY.value ).whileHeld(m_lowerConveyorEject);

     //Move the conveyor inwards while 'A' is held down
     new JoystickButton(m_actuatorController, Button.kA.value ).whileHeld(m_lowerConveyor);

     //Spins up flywheel for a moment and then runs the conveyor when 'Left Bumper' is pressed. Has the effect of shooting the ball. Press again to deactivate both.
     new JoystickButton(m_actuatorController, Button.kLeftBumper.value).toggleWhenPressed(m_shootBall);

     //Moves intake arm forward when 'Back' is pressed.
     new JoystickButton(m_actuatorController, Button.kBack.value).toggleWhenPressed(m_ArmControl);

     //Moves intake arm backwards when 'Start' is pressed.
     new JoystickButton(m_actuatorController, Button.kStart.value).toggleWhenPressed(m_ArmControlReverse);

     //The D-Pad is the plus shaped button on the lower left of the controller.
     //Puts the climber arm out when left on the D-Pad is pressed.
     new POVButton(m_actuatorController, 90).toggleWhenPressed(m_ClimberArm);

     //Pulls the climber arm in when right on the D-Pad is pressed.
     new POVButton(m_actuatorController, 270).toggleWhenPressed(m_ClimberArmReverse);

     //Moves the climber up while up on the D-pad is held. 
     new POVButton(m_actuatorController, 0).whileHeld(m_climberUp);

     //Moves the climber down while down on the D-pad is held. 
     new POVButton(m_actuatorController, 180).whileHeld(m_climberDown);

     
   /*  if(isIntakeOn = true){
      m_actuatorController.setRumble(GenericHID.RumbleType.kLeftRumble, 1.0);
      m_actuatorController.setRumble(GenericHID.RumbleType.kRightRumble, 1.0);
    } else {
      m_actuatorController.setRumble(GenericHID.RumbleType.kLeftRumble, 0.0);
      m_actuatorController.setRumble(GenericHID.RumbleType.kRightRumble, 0.0); 
    } */
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   
  public LimeLight getLimeLight() {
    return limeLight;
  }
  
  public Command getAutonomousCommand(){
    return m_autoShoot;
  }
}


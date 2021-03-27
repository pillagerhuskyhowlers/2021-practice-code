// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveBase;
import frc.robot.util.Utils;

//controls the drivetrain

public class DriveWithJoystick extends CommandBase {
  //variabes
  private final DriveBase driveBase;
  private final DoubleSupplier throttle;
  private final DoubleSupplier rotation;
  /** Creates a new DriveWithJoystick. */
  public DriveWithJoystick(DriveBase driveBase, DoubleSupplier throttle, DoubleSupplier rotation) {
    this.driveBase= driveBase;
    this.throttle= throttle;
    this.rotation= rotation;



    addRequirements(driveBase);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.arcadeDrive( 
      Utils.applyDeadband(throttle.getAsDouble(), Constants.CONTROL_DEADBAND),
      Utils.applyDeadband(rotation.getAsDouble(), Constants.CONTROL_DEADBAND)
    );

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

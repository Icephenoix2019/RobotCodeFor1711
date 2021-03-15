// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SubSystem;

public class DriveCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private final SubSystem subSystem;

    private final DoubleSupplier speedSupplier, rotationSupplier;

    public DriveCommand(SubSystem _driveTrain, DoubleSupplier _speedSupplier, DoubleSupplier _rotationSupplier) {

        subSystem = _driveTrain;
        addRequirements(subSystem);

        speedSupplier = _speedSupplier;
        rotationSupplier = _rotationSupplier;
    }

    @Override
    public void initialize() {
        subSystem.stop();
    }

    @Override
    public void execute() {
        subSystem.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        subSystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

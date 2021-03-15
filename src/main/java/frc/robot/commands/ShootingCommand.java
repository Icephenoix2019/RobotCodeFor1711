// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class ShootingCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private final ShooterSystem shooterSystem;

    private final DoubleSupplier speedSupplier;

    public ShootingCommand(ShooterSystem _driveTrain, DoubleSupplier _speedSupplier) {

        shooterSystem = _driveTrain;
        addRequirements(shooterSystem);

        speedSupplier = _speedSupplier;
    }

    @Override
    public void initialize() {
        shooterSystem.stop();
    }

    @Override
    public void execute() {
        shooterSystem.launcherDrive((speedSupplier.getAsDouble() - .5) * 2);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

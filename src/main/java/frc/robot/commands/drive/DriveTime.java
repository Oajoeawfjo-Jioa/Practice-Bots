package frc.robot.commands.drive;


import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTime extends CommandBase{

    private final double speed;
    private final double time;
    private Timer timer;
    
    public DriveTime(double speed, double time) {
        this.speed = speed;
        this.time = time;

        addRequirements(Robot.drivebase);
    }

	@Override
	public void initialize() {
		timer.start();
	}

    @Override
    public void execute() {
        Robot.drivebase.drive(speed, speed);
    }

	@Override
	public void end(boolean interrupted) {
		timer.reset();
	}

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }



}

package frc.robot;

//import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotMap.IOConstants;
import frc.robot.autonomous.Autonomous;
import frc.robot.autonomous.AutonomousProgram;
import frc.robot.commands.drive.DefaultDrive;
import frc.robot.commands.drive.DriveHold;
import frc.robot.commands.drive.DriveWait;
import frc.robot.subsystems.DrivebaseSubsystem;

public class Robot extends TimedRobot {

	/* Define Robot Subsystems */
	public static final DrivebaseSubsystem drivebase = new DrivebaseSubsystem();

	/* Robot IO Controls */
	public static final Joystick leftJoystick = new Joystick(IOConstants.LEFT_JOYSTICK_ID);
	public static final Joystick rightJoystick = new Joystick(IOConstants.RIGHT_JOYSTICK_ID);
	public static final XboxController xbox = new XboxController(0);

	/* Shufflebaord Tabs */
	public static final ShuffleboardTab AUTO_TAB = Shuffleboard.getTab("Autonomous");

	/* Shuffleboard Choosers */
	public static SendableChooser<Double> autoDelayChooser = new SendableChooser<>();

	/* Robot alliance color */

	/**
	 * Defines all the options for the autonomous delay
	 */
	static {
		for (double i = 0; i < 15; i += 0.25)
			autoDelayChooser.addOption(String.format("%.2f", i), i);

		autoDelayChooser.setDefaultOption("0.0", 0.0D);

		AUTO_TAB.add("Auto Start Delay", autoDelayChooser);
	}

	// The command configured to run during auto
	private Command autonomousCommand;

	@Override
	public void robotInit() {
		// Configure the joystick and controller bindings
		configureButtonBindings();

		// Reset motor encoders for all sub systems
		//drivebase.resetEncoders();

		// This runs if no other commands are scheduled (teleop)
		drivebase.setDefaultCommand(new DefaultDrive());

		// Set limited drive speed for normal driving
		//drivebase.setMaxOutput(0.75);

		/* Shuffleboard Stuff */
		Autonomous.init();
		AutonomousProgram.addAutosToShuffleboard();

		// Start Camera
		//CameraServer.startAutomaticCapture();
	}

	@Override
	public void autonomousInit() {
		// Chooses which auto we do from SmartDashboard
		autonomousCommand = AutonomousProgram.autoChooser.getSelected().construct();

		// Schedule the selected autonomous command group
		if (autonomousCommand != null) {
			CommandScheduler.getInstance().schedule(
					// To achieve the configured delay, use a sequential group that contains a wait
					// command
					new SequentialCommandGroup(
							new DriveWait(autoDelayChooser.getSelected()),
							autonomousCommand));
		}
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when teleop starts running.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
	}

	private void configureButtonBindings() {
		// While holding turbo button, increase drive speed to full power
		//
		//new JoystickButton(rightJoystick, 2).whileHeld(new SetDriveSpeed(1));

		// Drive fwd
	}

	/*
	 * This Robot is configured to run with the WPILib CommandScheduler.
	 * ⛔ Nothing should be handled in the below methods ⛔
	 */

	@Override
	public void robotPeriodic() {
		/*
		 * Runs the Scheduler. This is responsible for polling buttons, adding
		 * newly-scheduled
		 * commands, running already-scheduled commands, removing finished or
		 * interrupted commands,
		 * and running subsystem periodic() methods. This must be called from the
		 * robot's periodic
		 * block in order for anything in the Command-based framework to work.
		 */
		CommandScheduler.getInstance().run();
	}
}

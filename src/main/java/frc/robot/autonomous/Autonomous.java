package frc.robot.autonomous;

import static frc.robot.autonomous.AutonomousProgram.create;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.DriveWait;
import frc.robot.commands.drive.DriveTime;

/**
 * Quick guide to Comand Groups:
 *
 * SequentialComandGroup:
 * Will run all comands in order within it's parentheses
 * Note: If a comand does not have a isFinshed statment the code will be stuck
 * on that command forever
 *
 * ParallelCommandGroup:
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: Both commands will have to finish to move on
 *
 * ParallelRaceGoup:
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: As soon as one command runs it's isfinished method runs then both
 * commands will end
 *
 * ParallelDeadlineGroup
 * Will run commands in parallel if they use diffrent SubSystems
 * Note: Only the first command will finish the group
 */
public class Autonomous {

  public static void init() {
    /* Start with back against hub */
    create(
      "Drive 10 Seconds Forward, Wait 1 Second, Drive 10 Seconds Backward",
      () ->
        new SequentialCommandGroup(
          new DriveTime(10 , 0.5),
          new DriveWait(0.5),
          new DriveTime(10, -0.5)
        )
    );

    create(
      "Drive 10 Seconds Forward",
      () -> new SequentialCommandGroup(
        new DriveTime(10, 0.5)
      )
    );

    create(
      "Full send 1 second Forward",
      () -> new SequentialCommandGroup(
        new DriveTime(1, 1)
      )
    );
  }
}

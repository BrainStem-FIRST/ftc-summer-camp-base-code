package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Auto")
public class Auto extends LinearOpMode {

    private BrainSTEMRobot robot;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);

        waitForStart();

        while (!opModeIsActive()){

            telemetry.addData("OpMode State: ", "Init");
            telemetry.update();
        }

        // move robot forward for 1 second
        runtime.reset();
        robot.setDTMotorPowers(0.5,0.5,0.5,0.5);
        while (runtime.seconds() < 1);
        robot.stop();

        // turn robot left for 0.5 seconds
        runtime.reset();
        robot.setDTMotorPowers(-0.3,0.3,-0.3,0.3);
        while (runtime.seconds() < 0.5);
        robot.stop();

        // turn robot right for 0.5 seconds
        runtime.reset();
        robot.setDTMotorPowers(0.3,-0.3,0.3,-0.3);
        while (runtime.seconds() < 0.5);
        robot.stop();

    }
}
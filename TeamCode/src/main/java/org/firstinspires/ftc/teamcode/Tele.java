package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TeleOp")
public class Tele extends LinearOpMode {

    private BrainSTEMRobot robot;


    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);

        waitForStart();

        while (!opModeIsActive()) {

            telemetry.addData("OpMode Status: ", "Init");
            telemetry.update();
        }

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            setDrivePowers(y, x, rx);

            telemetry.addData("y-axis :", y);
            telemetry.addData("x-axis :", x);
            telemetry.addData("turn :", rx);
            telemetry.update();
        }
    }

    public void setDrivePowers(double y, double x, double rx) {
        robot.frontLeft.setPower(y + x + rx);
        robot.backLeft.setPower(y - x + rx);
        robot.frontRight.setPower(y - x - rx);
        robot.backRight.setPower(y + x - rx);
    }
}
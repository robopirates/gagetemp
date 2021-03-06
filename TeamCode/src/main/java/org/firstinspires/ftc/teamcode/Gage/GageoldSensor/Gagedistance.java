package org.firstinspires.ftc.teamcode.Gage.GageoldSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;


/*** Created by robot on 1/22/2017.*/

@Autonomous (name = "gageDistance", group = "robot")
public class Gagedistance extends LinearOpMode {
    gagestestrobot robot = new gagestestrobot();

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);

        OpticalDistanceSensor Gageoptic;
        Gageoptic = hardwareMap.opticalDistanceSensor.get("Gageoptic");

        // wait for the start button to be pressed.
        waitForStart();

        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {

            double  distance = Gageoptic.getLightDetected() * 10;

            telemetry.addData("Distance =", distance);
            telemetry.update();



            if (distance > 3) {
                continue;
            }
            if (distance < 3) {
                robot.LeftUp.setPower(1);
                robot.RightUp.setPower(1);
            }
            else {
                robot.RightUp.setPower(0);
                robot.LeftUp.setPower(0);
            }

            idle();
        }

    }
}
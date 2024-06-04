package TemenosTest.IndCustomers;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import java.awt.*;

public class ExtentTestNGUtil {

    public static ExtentColor getExtentColor(Status status) {
        switch (status) {
            case PASS:
                return ExtentColor.GREEN;
            case FAIL:
                return ExtentColor.RED;
            case SKIP:
                return ExtentColor.YELLOW;
            default:
                return ExtentColor.BLUE;
        }
    }
}

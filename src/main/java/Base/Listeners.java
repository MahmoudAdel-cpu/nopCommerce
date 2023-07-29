package Base;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {


        @Override
        public void onStart(ITestContext context) {

            System.out.println();
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println("Starting Execution of Test : " + context.getName());
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println();

        }

        @Override
        public void onTestStart(ITestResult result) {
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println();
            System.out.println("Starting Execution of TC : " + result.getMethod().getMethodName());
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println();
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println();
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println("Test" + result.getMethod().getMethodName() + " succeeded");
            System.out.println(StringUtils.repeat("-", 70));
            System.out.println();
        }


        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println();
            System.out.println( result.getMethod().getMethodName() + " has been skipped");
            System.out.println();
        }


        @Override
        public void onFinish(ITestContext context) {

            System.out.println("Finishing Execution of : " + context.getName());
        }

    }

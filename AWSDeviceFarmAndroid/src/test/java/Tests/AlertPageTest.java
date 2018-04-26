/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests;

import Pages.AlertPage;
import Pages.WaitConfig;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for alert page
 */
public class AlertPageTest extends TestBase {
    private static final String ALERT_MESSAGE = "This is the alert message";
    private AlertPage alertPage;

    @Override
    public String getName() {
        return "Alerts";
    }

    /**
     * Sets up the alert view page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        alertPage = new AlertPage(driver);
    }

    /**
     * Tests the alert view by clicking the alert view button,
     * then verifying the alert view message, and then
     * accepting the alert view message.
     */
    @Test
    public void testAlertMessage(){


       alertPage.clickToastButton();
       try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       alertPage.clickAlertsButton();
       Assert.assertEquals(alertPage.getAlertText(), ALERT_MESSAGE);
       alertPage.acceptAlertMessage();
       
       try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    }
}
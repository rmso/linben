package com.example.samsung.linben;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;

/**
 * Created by Raquel on 08/12/2017.
 */

public class VerHemocentroTeste extends InstrumentationTestCase {

    private UiDevice device;

    @Override
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 5000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Linben")), 5000);

        UiObject2 linbenApp = device.findObject(By.text("Linben"));
        linbenApp.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")), 3000);

        UiObject abrirMenu = device.findObject(new UiSelector().className("android.widget.ImageButton").index(0));
        abrirMenu.click();
        device.wait(Until.hasObject(By.text("Hemocentros")), 4000);

        UiObject abrirHemocentro = device.findObject(new UiSelector().className("android.support.v7.widget.LinearLayoutCompat").index(1));
        abrirHemocentro.click();
        device.wait(Until.hasObject(By.text("Allow")), 4000);

        UiObject2 aceitarPermissao = device.findObject(By.text("Allow"));
        aceitarPermissao.click();
        device.wait(Until.hasObject(By.text("Traçar Rota")), 4000);

        super.setUp();
    }
    public void testName() throws Exception {
    }
}
